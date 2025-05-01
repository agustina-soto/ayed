package clases;

public class RedBinariaLlena2025 {
    private BinaryTree<Integer> a;

    public RedBinariaLlena2025(BinaryTree<Integer> arbol){
        this.a = arbol;
    }

    public int retardoReenvio(){
    	int max = 0, suma = 0;
        return mayorRetardoReenvio(this.a, suma, max);
    }

    private int mayorRetardoReenvio(BinaryTree<Integer> a, int suma, int max){
        suma += a.getData(); //Sumo el dato actual
        if (a.isLeaf()) { //Si es una hoja, compruebo si hay que actualizar el máximo
        	if (suma > max) {
        		max = suma;
        	}
        }
        else { //Si no es hoja, sigo recorriendo el camion actual
	        if (a.hasLeftChild())
	        	max = mayorRetardoReenvio(a.getLeftChild(), suma, max);
	        if (a.hasRightChild())
	        	max = mayorRetardoReenvio(a.getRightChild(), suma, max);
        }
        return max;
    }

}
