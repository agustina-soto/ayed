package Parciales;

import clases.BinaryTree;

public class ParcialArboles_2 {
    private BinaryTree<Integer> arbol;

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











/*
    if (arbol1 == null){
        return true;
    }
    si coinciden:
        si arbo1 tiene izquierdo && arbol2 tiene izquierdo:
            busca con izquierdo(nodo.getLeftChild(), arbolOriginal.getLeftChild())
        si tiene derecho:
            busca con derecho(nodo.getRightChild(), arbolOriginal)

    si es una hoja:
    si no es una hoja:
*/


}
