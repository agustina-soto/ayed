package ejercicio3;

import clases.BinaryTree;
import clases.ContadorArbol;

public class tp2_ejercicio3 {
    public static void main(String[] args) {
        // Creación del árbol
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(12);

        ContadorArbol arbol = new ContadorArbol(raiz);

        raiz.addLeftChild(nodo1);
        raiz.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo6);

        /*                                RAIZ: 10
                                            |
                            nodo1: 3 _______|_______ nodo2: 8
                              |                         |
                    nodo3: 5 _|_ nodo4: 9     nodo5: 6 _|_ nodo6: 12
        
        Cantidad de nros pares = 
        */

        int cantInOrden = arbol.numerosParesInOrden().size();
        int cantPostOrden = arbol.numerosParesPostOrden().size();
        System.out.println("Cantidad de numeros pares InOrden: " + cantInOrden);
        System.out.println("Cantidad de numeros pares PostOrden: " + cantPostOrden);
    }
}