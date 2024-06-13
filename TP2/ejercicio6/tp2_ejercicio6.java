package ejercicio6;

import clases.*;

public class tp2_ejercicio6 {
    public static void main(String[] args) {
        // Creación del árbol binario lleno
        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);

        Transformacion transformacion = new Transformacion(nodo1);
        nodo1.addLeftChild(nodo2);
        nodo1.addRightChild(nodo3);
        nodo2.addRightChild(nodo4);
        nodo3.addLeftChild(nodo5);
        nodo3.addRightChild(nodo6);
        nodo5.addLeftChild(nodo7);
        nodo5.addRightChild(nodo8);

/*
                              nodo1
                                |
                   nodo2 _______|_______ nodo3
                     |                     |
                    _|__ nodo4     nodo5 __|__ nodo6
                                     |
                             nodo7 __|__ nodo8
*/

        // Método auxiliar para imprimir el árbol (recorrido en orden)
        System.out.println(" ----- Antes de la suma -----");
        nodo1.entreNiveles(0, 3);

        System.out.println();

        BinaryTree<Integer> nuevoArbol = transformacion.suma();
        System.out.println("----- Despues de la suma -----");
        nuevoArbol.entreNiveles(0, 3);
    }
}
