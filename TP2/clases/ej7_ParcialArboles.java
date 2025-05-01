package clases;

public class ej7_ParcialArboles {
	private BinaryTree<Integer> a;
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> nodoABuscar = buscarNum(num);
		int valorIzq = 0, valorDer = 0;
		if (nodoABuscar != null) { // Si lo encontré
			if(!nodoABuscar.hasLeftChild())
				valorIzq = -1;
			else
				valorIzq = sumaSubarbol(nodoABuscar.getLeftChild());
			if(!nodoABuscar.hasRightChild())
				valorDer = -1;
			else
				valorDer = sumaSubarbol(nodoABuscar.getRightChild());
		}
		return (valorIzq > valorDer);
	}
	
	private BinaryTree<Integer> buscarNum(int num) {
		return null;
	}
	
	private int sumaSubarbol(BinaryTree<Integer> a) {
		if((a.hasLeftChild()) && (!a.hasRightChild())) {
			return 1 + sumaSubarbol(a.getLeftChild());
		}
		if((a.hasRightChild()) && (!a.hasLeftChild())) {
			return 1 + sumaSubarbol(a.getRightChild());
		}
		if(a.hasLeftChild() && (a.hasRightChild())) {
			int suma = sumaSubarbol(a.getLeftChild());
			suma += sumaSubarbol(a.getRightChild());
			return suma;
		}
		return 0; // en vez de esto acá deberia preguntar al inicio si es leaf? es lo mismo para mi solo que eso serian mas lineas....
		
		/*
		 tiene hi tiene hd --> no sumo, sugo buscando
		 tiene hi no tiene hd --> sumo
		 no tiene hi tiene hd --> sumo
		 no tiene hi no tiene hd --> creeria que no entra siquiera a este metodo
		 */
	}

	
}
