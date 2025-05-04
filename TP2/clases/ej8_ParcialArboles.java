package clases;

public class ej8_ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if(arbol1.isEmpty() || arbol2.isEmpty()) {  // Esta mal preguntar por empty aca? deberia preguntar por nul???
			return false;
		} // Tendria que preguntar por otro caso??
		return esPrefijoR(arbol1, arbol2);
		/*
 		a1 null - a2 null --> true or false? Si arbol1 es null, es prefijo de cualquier cosa? o no es prefijo de nada?
		a1 null - a2 not null --> false ?
		a1 not null - a2 null --> false
		a1 not null - a2 not null --> depende de los hijos
		 
		No se muy bien cual chequear de estos casos... :( supongo que si alguno o los dos son null, ya no se cumple, pero que sinpo tengo que procesa y fijarme 
		*/ 
	}
	
	private boolean esPrefijoR(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (!arbol1.getData().equals(arbol2.getData())) {
			return false;
		}
		boolean cumple = true;
		if (arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				cumple = esPrefijoR (arbol1.getLeftChild(), arbol2.getLeftChild());
			}
			else return false;
		}
		if(cumple && arbol1.hasRightChild()) {
 			if(arbol2.hasRightChild()) {
				cumple = esPrefijoR (arbol1.getRightChild(), arbol2.getRightChild());
 			}
 			else return false;
 		}
 		return cumple; // si llega hasta aca es porque sigue cumpliendo ser prefijo
	}
}
