package Parciales.parcial2;

import Parciales.ParcialArboles_1;
import clases.*;

public class tp2_ejercicio7 {

	public static void main(String[] args) {
		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
	    BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
	    BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
	    BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
	    BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
	    BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
	    
	    // Construyo el árbol
	    nodo1.addLeftChild(nodo2);
	    nodo1.addRightChild(nodo3);
	    nodo2.addLeftChild(nodo4);
	    nodo3.addLeftChild(nodo5);
	    nodo3.addRightChild(nodo6);

        ParcialArboles_2 arbol1 = new ParcialArboles_2(nodo1);
        ParcialArboles_2 arbol2 = new ParcialArboles_2(nodo1);

        System.out.println("Es prefijo? " + arbol1.esPrefijo(arbol1.getArbol(), arbol2.getArbol()));
    }

}