package clases;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public void setTransformacion(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> getTransformacion(){
        return this.arbol;
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

}
