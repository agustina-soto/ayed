package ejercicio4;

import clases.BinaryTree;

public class tp2_ejercicio4 {
    public static void main(String[] args) {
        // Creación del árbol binario lleno
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(12);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);

        // Creación de la red binaria llena
        RedBinariaLlena red = new RedBinariaLlena(raiz);

        raiz.addLeftChild(nodo1);
        raiz.addRightChild(nodo2);
        nodo1.addLeftChild(nodo3);
        nodo1.addRightChild(nodo4);
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo6);
        nodo3.addLeftChild(nodo7);
        nodo3.addRightChild(nodo8);

        /*                                RAIZ: 10
                                            |
                            nodo1: 3 _______|_______ nodo2: 8
                              |                         |
                    nodo3: 5 _|_ nodo4: 9     nodo5: 6 _|_ nodo6: 12
                      |
           nodo7: 7 __|__ nodo8: 8
        
        El mayor retardo de este arbol es de 30 segundos.
        */

        // Cálculo del mayor retardo de reenvío
        int mayorRetardo = red.retardoReenvio();
        System.out.println("El mayor retardo de reenvío es: " + mayorRetardo);
    }
}