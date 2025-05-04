package ejercicio8;

import clases.*;

public class tp2_ejercicio8 {
	public static void main(String[] args) {
		// Armamos un árbol de ejemplo
		BinaryTree<Integer> raiz = new BinaryTree<>(7);
		BinaryTree<Integer> left = new BinaryTree<>(23);
		BinaryTree<Integer> right = new BinaryTree<>(2);
		raiz.addLeftChild(left);
		raiz.addRightChild(right);

		left.addLeftChild(new BinaryTree<>(-5));
		right.addLeftChild(new BinaryTree<>(19));
		right.addRightChild(new BinaryTree<>(4));
		

		BinaryTree<Integer> arbol1 = new BinaryTree<>(7);
		arbol1.addLeftChild(new BinaryTree<>(23));
		ej8_ParcialArboles parcial8 = new ej8_ParcialArboles();
		System.out.println("esPrefijo(arbol1, raiz): "+parcial8.esPrefijo(arbol1,raiz));
	}
}