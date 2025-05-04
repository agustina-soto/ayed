package clases;

public class ej9_ParcialArboles {

	public BinaryTree<Resultado> sumAndDif(BinaryTree<Integer> raiz) {
		if(!raiz.isEmpty()) {
			Resultado res = new Resultado(raiz.getData(), raiz.getData());
			BinaryTree<Resultado> nuevoArbol = new BinaryTree<Resultado>(res);
			
			if(raiz.hasLeftChild()) {
				nuevoArbol.addLeftChild(calcularValores(raiz.getData(), raiz.getData(), raiz.getLeftChild()));
			}
			if(raiz.hasRightChild()) {
				nuevoArbol.addRightChild(calcularValores(raiz.getData(), raiz.getData(), raiz.getRightChild()));
			}
			return nuevoArbol;
		}
		return null;
	}

	private BinaryTree<Resultado> calcularValores(int sumaPadre, int difPadre, BinaryTree<Integer> a) {
		int suma = a.getData() + sumaPadre;
		int dif = a.getData() - difPadre;
		Resultado res = new Resultado(suma, dif);
		BinaryTree<Resultado> arbolRes = new BinaryTree<Resultado>(res);
		if(a.hasLeftChild()) {
			arbolRes.addLeftChild(calcularValores(suma, dif, a.getLeftChild()));
		}
		if(a.hasRightChild()) {
			arbolRes.addRightChild(calcularValores(suma, dif, a.getRightChild()));
		}
		return arbolRes;
	}
}
