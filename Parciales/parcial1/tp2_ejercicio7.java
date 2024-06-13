package Parciales.parcial1;

import clases.*;

public class tp2_ejercicio7 {
    public static void main(String[] args) {
        BinaryTree<Integer> nodo1 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(-5);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(23);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(19);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(-3);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(55);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(18);

        ParcialArboles_1 arbol = new ParcialArboles_1(nodo1);
        nodo1.addLeftChild(nodo2);
        nodo1.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo2.addRightChild(nodo5);
        nodo3.addLeftChild(nodo6);
        nodo4.addLeftChild(nodo7);
        nodo5.addLeftChild(nodo8);
        nodo5.addRightChild(nodo9);
        nodo6.addRightChild(nodo10);
        nodo10.addLeftChild(nodo11);

        System.out.println("Is left tree? " + arbol.isLeftTree(-3));
    }
}
