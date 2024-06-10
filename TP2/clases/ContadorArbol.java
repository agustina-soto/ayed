package clases;

import java.util.ArrayList;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getContadorArbol(){
        return this.arbol;
    }

    public void setContadorArbol(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public boolean esPar(int num){
        return (num % 2 == 0);
    }

    // Método para obtener los números pares del árbol en orden
    public ArrayList<Integer> numerosParesInOrden() {
        ArrayList<Integer> pares = new ArrayList<>();
        numerosParesInOrdenRecursivo(this.arbol, pares);
        return pares;
    }

    // Método auxiliar recursivo para obtener los números pares del árbol en orden
    private void numerosParesInOrdenRecursivo(BinaryTree<Integer> nodo, ArrayList<Integer> pares) {
        if (nodo != null) {
            // Recorremos recursivamente el hijo izquierdo
            if (nodo.hasLeftChild())
                numerosParesInOrdenRecursivo(nodo.getLeftChild(), pares);
            
            // Si el valor del nodo es par, lo agregamos a la lista
            if (esPar(nodo.getData())) {
                pares.add(nodo.getData());
            }

            // Recorremos recursivamente el hijo derecho
            if (nodo.hasRightChild())
                numerosParesInOrdenRecursivo(nodo.getRightChild(), pares);
        }
    }

    // Método para obtener los números pares del árbol en orden
    public ArrayList<Integer> numerosParesPostOrden() {
        ArrayList<Integer> pares = new ArrayList<>();
        numerosParesPostOrdenRecursivo(this.arbol, pares);
        return pares;
    }

    private void numerosParesPostOrdenRecursivo(BinaryTree<Integer> nodo, ArrayList<Integer> pares) {
        if (nodo != null) {
            // Recorremos recursivamente el hijo izquierdo
            if (nodo.hasLeftChild())
                numerosParesInOrdenRecursivo(nodo.getLeftChild(), pares);

            // Recorremos recursivamente el hijo derecho
            if (nodo.hasRightChild())
                numerosParesInOrdenRecursivo(nodo.getRightChild(), pares);

            // Si el valor del nodo es par, lo agregamos a la lista
            if (esPar(nodo.getData())) {
                pares.add(nodo.getData());
            }
        }
    }
}
