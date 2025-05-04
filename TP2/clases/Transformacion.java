package clases;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> suma(){
        sumaRecursiva(this.arbol);
        return arbol;
    }

    private int sumaRecursiva(BinaryTree<Integer> nodo){
        int aux = nodo.getData();
        if (nodo.isLeaf()){
            nodo.setData(0);
            return aux;
        }
        int suma = 0;
        if (nodo.hasLeftChild())
            suma += sumaRecursiva(nodo.getLeftChild());
        if (nodo.hasRightChild())
            suma += sumaRecursiva(nodo.getRightChild());
        nodo.setData(suma);
        return (suma+aux);
    }

    // ----- OPCION 2 (devolviendo un BinaryTree nuevo en vez de modificar el original
    public BinaryTree<Integer> suma2(){
    	return (sumaRecursiva2(this.arbol));
    }
   
    private BinaryTree<Integer> sumaRecursiva2(BinaryTree<Integer> a) {
    	BinaryTree<Integer> aux = new BinaryTree<Integer>();
    	if(a.isLeaf()) {
    		aux.setData(0);
    	}
    	else {
	    	int suma = 0;
	    	if(a.hasLeftChild()) {
	    		BinaryTree<Integer> hijoIzq = sumaRecursiva2(a.getLeftChild());
	    		aux.addLeftChild(hijoIzq);
	    		suma += a.getLeftChild().getData() + hijoIzq.getData();
	    	}	
	    	if(a.hasRightChild()) {
	    		BinaryTree<Integer> hijoDer = sumaRecursiva2(a.getRightChild());
	    		aux.addRightChild(hijoDer);
	    		suma += a.getRightChild().getData() + hijoDer.getData();
	    	}
	    	aux.setData(suma);
    	}
    	return aux;
    }
}

/*  public BinaryTree<Integer> suma(){
		if(a.isEmpty())
			return null;
		sumaRecursiva(a);
		return a;
	}

	private int sumaRecursiva(BinaryTree<Integer> a) {
		int aux = a.getData();
		int sumaIzq, sumaDer = 0;
		if (a.hasLeftChild())
			sumaIzq = sumaRecursiva(a.getLeftChild());
		if (a.hasRightChild())
			sumaDer = sumaRecursiva(a.getRightChild());
		a.setData(sumaIzq+sumaDer); // Si es hoja hace 0+0
		return aux + sumaIzq + sumaDer;
	}

    private int sumaRecursiva(BinaryTree<Integer> nodo){
        int aux = nodo.getData();
        if (nodo.isLeaf()){
            nodo.setData(0);
            return aux;
        }
        int suma = 0;
        if (nodo.hasLeftChild())
            suma += sumaRecursiva(nodo.getLeftChild());
        if (nodo.hasRightChild())
            suma += sumaRecursiva(nodo.getRightChild());
        nodo.setData(suma);
        return (suma+aux);
    }


// en la v2 se chequea si es leaf. en mi version se hace igual sin consultar explicitamente, esta bien o no? y la suma yo la separe pero no es necesario, igualmente prefiero dejarla separada porque fue lo que se me ocurrio y porque entiendo que no lo hace menos correcto para la catedra... verdad? 
// Es importante chequear por las hojas explicitamente?
  
 
*/