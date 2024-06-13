package clases;
public class ParcialArboles_1 {
    private BinaryTree<Integer> arbol; // VALORES ENTEROS NO REPETIDOS!!!!!!!

    public ParcialArboles_1(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public void setArbol(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> getArbol(){
        return this.arbol;
    }

    public boolean isLeftTree (int num){
        BinaryTree<Integer> a = buscar(this.arbol, num);
        if (a != null){    
            int cantI = 0, cantD = 0;
            if(a.hasLeftChild()){
                cantI = cantNodos(a.getLeftChild());
            }
            else{
                cantI = -1;
            }
            if (a.hasRightChild()) {
                cantD = cantNodos(a.getRightChild());   
            }
            else{
                cantD = -1;
            }
            return cantI > cantD;
        }
        return false;
    }

    private BinaryTree<Integer> buscar(BinaryTree<Integer> a, int num){
        if (a == null){
            return a;
        }
        if (a.getData().equals(num)){
            return a;
        }

        BinaryTree<Integer> nodo = null;
        // Si no lo encontró todavía ejecuta esto
        if (a.hasLeftChild()){
            nodo = buscar(a.getLeftChild(), num);
        }
        if (a.hasRightChild() && (nodo == null)){
            nodo = buscar(a.getRightChild(), num);
        }

        return nodo;
    }

    private int cantNodos(BinaryTree<Integer> a){
        int cant = 0;
        if (a.hasLeftChild()){
            if (!a.hasRightChild()){
                cant += 1;
            }
            cant += (cantNodos(a.getLeftChild()));
        }
        if (a.hasRightChild()){
            if (!a.hasLeftChild()){
                cant += 1;
            }
            cant += (cantNodos(a.getRightChild()));
        }
        return cant;
    }
}