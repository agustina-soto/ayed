package ejercicio9;

import java.util.LinkedList;

import clases.*;

public class tp2_ejercicio9 {
    public static void main(String[] args) {
        // Crear el árbol de ejemplo:
        //       5
        //      / \
        //     3   8
        //    / \   \
        //   1   4   10
        BinaryTree<Integer> arbol = new BinaryTree<>(5);
        arbol.addLeftChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getRightChild().addRightChild(new BinaryTree<>(10));

        // Probar tu método
        ej9_ParcialArboles parcial = new ej9_ParcialArboles();
        BinaryTree<Resultado> resultado = parcial.sumAndDif(arbol);

        // Imprimir el resultado (recorrido por niveles para verificar)
        System.out.println("Árbol resultado (suma, diferencia):");
        imprimirArbol(resultado);
    }

    // Método auxiliar para imprimir el árbol por niveles (BFS)
    private static void imprimirArbol(BinaryTree<Resultado> arbol) {
        if (arbol == null || arbol.isEmpty()) {
            System.out.println("Árbol vacío.");
            return;
        }

        Queue<BinaryTree<Resultado>> cola = new Queue<>();
        cola.enqueue(arbol);
        int nivel = 0;

        while (!cola.isEmpty()) {
            int nodosEnNivel = cola.size();
            System.out.print("Nivel " + nivel + ": ");

            for (int i = 0; i < nodosEnNivel; i++) {
                BinaryTree<Resultado> nodo = cola.dequeue();
                Resultado res = nodo.getData();
                System.out.print("(Suma: " + res.getSuma() + ", Dif: " + res.getDiferencia() + ") ");

                if (nodo.hasLeftChild()) {
                    cola.enqueue(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()) {
                    cola.enqueue(nodo.getRightChild());
                }
            }
            System.out.println();
            nivel++;
        }
    }
}