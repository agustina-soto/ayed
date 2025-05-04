package clases;

public class ej7_ParcialArboles {
	private BinaryTree<Integer> a;
	
	public ej7_ParcialArboles(BinaryTree<Integer> a) {
		this.a = a;
	}
	
	public boolean isLeftTree(int num) {
		int valorIzq = 0, valorDer = 0;
		if(a != null) { // Aca deberia preguntar x empty??
			BinaryTree<Integer> nodoABuscar = buscarNum(a, num);
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
		}
		return (valorIzq > valorDer);
	}

	private BinaryTree<Integer> buscarNum(BinaryTree<Integer> a, int num) {
		if(a.getData() == num) {
			return a;
		}
		//Si no lo encontré todavía
		BinaryTree<Integer> aux = null;
		if(a.hasLeftChild()) {
			aux = buscarNum(a.getLeftChild(), num);
		}
		if(a.hasRightChild() && (aux == null)) { // Si tiene hd y todavía no lo encontré
			aux = buscarNum(a.getRightChild(), num);
		}
		return aux;
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
		 no tiene hi no tiene hd --> no entra a este metodo
		 */
	}

	
}
