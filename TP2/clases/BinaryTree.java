package clases;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	 public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
        if (this.isLeaf())
		    return 1;
        int suma = 0; // Inicializa contador, solo ejecuta esta linea una vez por la raiz
        if (this.hasLeftChild())
            suma += this.getLeftChild().contarHojas();
        if (this.hasRightChild())
            suma += this.getRightChild().contarHojas();
		return suma;
	}


    public BinaryTree<T> espejo(){
        BinaryTree<T> arbolEspejo = new BinaryTree<T>(this.getData());
    	if (this.isLeaf())
    		return this;
    	if (this.hasLeftChild())
    		arbolEspejo.addRightChild(this.getLeftChild().espejo());
    	if (this.hasRightChild())
    		arbolEspejo.addLeftChild(this.getRightChild().espejo());
        return arbolEspejo;
    }

	// 0<=n<=m
    public void entreNiveles(int n, int m) {
        //Se utilizan dos colas, una para los nodos y otra para los niveles correspondientes de esos nodos
		Queue<BinaryTree<T>> nodos = new Queue<>();
		Queue<Integer> niveles = new Queue<Integer>();

		// Se agrega el nodo raíz y el nivel 0 a las colas
		nodos.enqueue(this);
		niveles.enqueue(0);

        while (!nodos.isEmpty()) {
			BinaryTree<T> nodoActual = nodos.dequeue();
			int nivelActual = niveles.dequeue();
			if (nivelActual >= n && nivelActual <= m){
				System.out.println("Nivel actual: " + nivelActual);
				System.out.println("Nodo actual: " + nodoActual.getData());
			}

			if (nodoActual.hasLeftChild()) {
				nodos.enqueue(nodoActual.getLeftChild());
				niveles.enqueue(nivelActual + 1); // Incrementa en uno el nivel almacenado
			}

			if (nodoActual.hasRightChild()) {
				nodos.enqueue(nodoActual.getRightChild());
				niveles.enqueue(nivelActual + 1);
			}
    	}
	}
}