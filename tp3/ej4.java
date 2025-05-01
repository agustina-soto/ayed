package tp3;

import java.util.List;

public class ej4 {
	private double DevolverMaximoPromedio(GeneralTree<AreaEmpresa> a) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> aux;
		cola.enqueue(a);
		cola.enqueue(null);
		double max = -1;
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null ) {
				List<Integer> listaAux = new ArrayList<Integer>();
				//suma = 0;
				//cant = 0;
				
				for(GeneralTree<AreaEmpresa> elemento : aux.getChildren) {
					cola.enqueue(elemento);
					listaAux.add(elemento.getData());
					//sum += elemento.getData();
					// cant += 1;
				}
				if(getPromedio(listaAux) > max) { // sum/cant > max // HACE CASTING????
					max = getPromedio(listaAux); // max = sum/cant;
					
				}
		}
			else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
			
			return max;
	}}
}
