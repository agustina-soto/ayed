package TP3;

import clases.Queue;

/*
	Me pide indicar y justificar el recorrido elegido:
	Se utiliza un recorrido por niveles porque el objetivo es calcular el promedio de los valores en cada nivel del árbol.
	Este tipo de recorrido permite visitar todos los nodos de un mismo nivel antes de pasar al siguiente, lo cual es exactamente
	lo que se necesita para agrupar los nodos por nivel y calcular sus promedios de manera eficiente. Además, garantiza que los
	nodos sean procesados en el orden jerárquico requerido por el problema, manteniendo la estructura de la comunicación.
 */

public class ej4_AnalizadorArbol {

	// Devolver el mayor promedio entre todos los valores promedios de los niveles.
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double max = -1;
		if(arbol != null && !arbol.isEmpty()) { // esto es necesario? :(( yo creo que si porque me parece necesaria la validacion pero no sé
			int cant = 0, suma = 0;
			Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				GeneralTree<AreaEmpresa> nodo = cola.dequeue();
				if(nodo != null) {
					cant++;
					suma += nodo.getData().getTardanza();
					
					for(GeneralTree<AreaEmpresa> hijo : nodo.getChildren()) {
						cola.enqueue(hijo);
					}
				}
				else {
					double prom = suma/cant;
					if(prom > max) {
						max = prom;
					}
					cant = 0;
					suma = 0;
				}
			}
		}
		return max; // Si el arbol es null o empty devuelve -1
	}
}
