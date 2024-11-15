package clases;

public class RedBinariaLlena {
    private BinaryTree<Integer> a;

    public RedBinariaLlena(BinaryTree<Integer> arbol){
        this.a = arbol;
    }

    public void setRedBinariaLlena(BinaryTree<Integer> a){
        this.a = a;
    }

    public BinaryTree<Integer> getRedBinariaLlena(){
        return this.a;
    }

    private int mayorRetardoReenvio(BinaryTree<Integer> arbol){
        if (arbol.isLeaf())
            return arbol.getData();

        // Inicializa contadores de sus hijos
        int retardoIzq = 0;
        int retardoDer = 0;
    
        if (arbol.hasLeftChild())
            retardoIzq += mayorRetardoReenvio(arbol.getLeftChild());
        if (arbol.hasRightChild())
            retardoDer += mayorRetardoReenvio(arbol.getRightChild());

        return arbol.getData() + Math.max(retardoIzq, retardoDer);
        // La funcion Math.max se queda con el valor más alto
    }

    public int retardoReenvio(){
        return mayorRetardoReenvio(this.a);
    }

}
