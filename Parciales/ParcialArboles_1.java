package Parciales;

import clases.BinaryTree;

public class ParcialArboles_1 {
    private BinaryTree<Integer> arbol; // VALORES ENTEROS NO REPETIDOS!!!!!!!

    public ParcialArboles_1(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public void setArbol(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> getArbol(){
        return this.arbol;
    }

    public boolean isLeftTree (int num){
		BinaryTree<Integer> nodoABuscar = buscar(this.getArbol(), num);
		if (nodoABuscar == null){ // Si no se encontró
            return false;
        }

        // Encontró el nodo, inicializo contadores de cada subrama
        int cant_hi_unicos = 0;
        int cant_hd_unicos = 0;

        if (!nodoABuscar.hasLeftChild()) {
            cant_hi_unicos = -1;
        }
        if (!nodoABuscar.hasRightChild()) {
            cant_hd_unicos = -1;
        }

        return cant_hi_unicos > cant_hd_unicos;
    }

    private BinaryTree<Integer> buscar(BinaryTree<Integer> nodo, int num) {
        if (nodo == null){
            return null;
        }
        if (nodo.getData() == num){
            return nodo;
        }

        // Si no es null y si no lo encontró, tengo que seguir buscando
        BinaryTree<Integer> aux = null;
        if (nodo.hasLeftChild()){
            aux = buscar(nodo.getLeftChild(), num); // BUSCO RECURSIVAMENTE CON EL HIJO IZQ
        }
        if (nodo.hasRightChild()) // BUSCA EN LAS RAMAS DER SI EXISTEN
                aux = buscar(nodo.getRightChild(), num);
        return aux;
    }

    private int contarHijosUnicos(BinaryTree<Integer> nodo) {
        if (nodo == null) {
            return 0;
        }

        int count = 0;
        if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild())) {
            count = 1;
        }

        count += contarHijosUnicos(nodo.getLeftChild());
        count += contarHijosUnicos(nodo.getRightChild());

        return count;
    }
}