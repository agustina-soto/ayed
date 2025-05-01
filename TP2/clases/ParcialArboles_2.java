package clases;

public class ParcialArboles_2 {
    private BinaryTree<Integer> arbol;

    public ParcialArboles_2(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public void setArbol(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> getArbol(){
        return this.arbol;
    }

    // Devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean ok = true;
        if (arbol1 == null || arbol2 == null){
            ok = false;
        }
        else{
            ok = esPrefijoR(arbol1, arbol2);
        }
        return ok;
    }

    private boolean esPrefijoR(BinaryTree<Integer> n1, BinaryTree<Integer> n2){
        boolean cumple = true;
        if (! (n1.getData().equals( n2.getData() )) )
            return false;
        if (n1.hasLeftChild()){
            if (!n2.hasLeftChild()){
                return false; // Si n2 no tiene hi se corta la recursion
            }
            cumple = esPrefijoR(n1.getLeftChild(), n2.getLeftChild());
        }
        if (n1.hasRightChild() && cumple){ // Si tiene hd y sigue siendo prefijo
            if (!n2.hasRightChild()){
                return false;
            }
            cumple = esPrefijoR(n1.getRightChild(), n2.getRightChild());
        }
        return cumple;
    }
    
    // --- creo que me falto algo en el de arriba
    // antes supuse que debian coincidir desde la raiz, esta es una solucion que no supone eso sino que busca el subarbol coicidente (si existe)

    // Devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
    public boolean esPrefijo2(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // Si arbol1 es nulo, siempre es un prefijo de cualquier árbol
        if (arbol1 == null) {
            return true;
        }

        // Si arbol2 es nulo, no puede contener un prefijo no vacío
        if (arbol2 == null) {
            return false;
        }
        // Buscar si hay un subárbol de arbol2 que sea igual a arbol1
        if (esSubarbol(arbol1, arbol2)) {
            return true;
        }
        // Recursivamente revisar los hijos izquierdo y derecho de arbol2
        return esPrefijo2(arbol1, arbol2.getLeftChild()) || esPrefijo2(arbol1, arbol2.getRightChild());
    }

	// Verifica si arbol1 es un prefijo exacto de arbol2
	private boolean esSubarbol(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null) {
			return true; // Un árbol vacío es siempre un prefijo de cualquier árbol
		}
		if (arbol2 == null) {
			return false; // Si arbol2 es nulo, no puede ser un prefijo
		}
		// Compara los datos de las raíces
		if (!arbol1.getData().equals(arbol2.getData())) {
			return false;
		}

		// Compara recursivamente los subárboles izquierdo y derecho
		return esSubarbol(arbol1.getLeftChild(), arbol2.getLeftChild())
				&& esSubarbol(arbol1.getRightChild(), arbol2.getRightChild());
	}
}