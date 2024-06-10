package clases;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public void setProfundidadArbolBinario(BinaryTree<Integer> a){
        this.arbol = a;
    }

    public BinaryTree<Integer> getProfundidadArbolBinario(){
        return this.arbol;
    }

    // Devuelve la suma de todos los nodos del árbol que se encuentren a la profundidad pasada como argumento
    public int sumaElementosProfundidad (int p){
        Queue<BinaryTree<Integer>> nodos = new Queue<>();
        Queue<Integer> niveles = new Queue<>();

        nodos.enqueue(arbol);
        niveles.enqueue(0);
        int suma = 0;

        while (!nodos.isEmpty()) {
            BinaryTree<Integer> nodoActual = nodos.dequeue();
            int nivelActual = niveles.dequeue();
            if (nivelActual >= 0 && nivelActual <= p) {
                suma += nodoActual.getData();
                if (nodoActual.hasLeftChild()) {
                    nodos.enqueue(nodoActual.getLeftChild());
                    niveles.enqueue(nivelActual + 1);
                }
                if (nodoActual.hasRightChild()) {
                    nodos.enqueue(nodoActual.getRightChild());
                    niveles.enqueue(nivelActual + 1);
                }
            }
        }
        return suma;
    }
}