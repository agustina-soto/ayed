package ejercicio2;

import clases.*;


public class tp2_ejercicio2 {

	public static void main(String[] args) {
		BinaryTree<String> raiz = new BinaryTree<>("A");
	    BinaryTree<String> nodoB = new BinaryTree<>("B");
	    BinaryTree<String> nodoC = new BinaryTree<>("C");
	    BinaryTree<String> nodoD = new BinaryTree<>("D");
	    BinaryTree<String> nodoE = new BinaryTree<>("E");
	    BinaryTree<String> nodoF = new BinaryTree<>("F");
	    
	    // Construyo el árbol
	    raiz.addLeftChild(nodoB);
	    raiz.addRightChild(nodoC);
	    nodoB.addLeftChild(nodoD);
	    nodoC.addLeftChild(nodoE);
	    nodoC.addRightChild(nodoF);
	
	    // Imprime nodos entre los niveles 1 y 2
	    System.out.println("Nodos entre niveles 0 y 2:");
	    raiz.entreNiveles(0, 2);  // Debería imprimir: A B C D E F
	
	    // Imprime nodos en el nivel 1
	    System.out.println("Nodos en el nivel 1:");
	    raiz.entreNiveles(1, 1);  // Debería imprimir: B C
	    
		// Imprime nodos en el nivel 2
	    System.out.println("Nodos en el nivel 2:");
	    raiz.entreNiveles(2, 2);  // Debería imprimir: D E F
	
        System.out.println("Cantidad de hojas = " + raiz.contarHojas()); // Deberia imprimir 3

        System.out.println("Arbol espejo");
		BinaryTree<String> espejo = raiz.espejo();
		espejo.entreNiveles(0, 2);
    }

}


