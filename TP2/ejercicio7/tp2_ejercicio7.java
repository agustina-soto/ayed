package ejercicio7;

import clases.*;

public class tp2_ejercicio7 {
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
		

		ej7_ParcialArboles parcial7 = new ej7_ParcialArboles(raiz);
		System.out.println("isLeftTree(7): "+parcial7.isLeftTree(7)); // true
		System.out.println("isLeftTree(2): "+parcial7.isLeftTree(2)); // false
		System.out.println("isLeftTree(-5): "+parcial7.isLeftTree(-5)); // true
		System.out.println("isLeftTree(19): "+parcial7.isLeftTree(19)); // false
	}
}