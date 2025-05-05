package TP3;

import java.util.ArrayList;
import java.util.List;

import clases.Queue;

public class RecorridosAG {
	// Retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros
	
	// PreOrden ------------------------------------------------------------------------
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<>();
		if(!a.isEmpty()) {
			ej2PreOrden(a, n, lista);
		}
		return lista;
	}
	
	private void ej2PreOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
		if( (a.getData() > n) && (a.getData() % 2 != 0) ) {
			lista.add(a.getData());
		}
		for(GeneralTree<Integer> hijo : a.getChildren()) {
			ej2PreOrden(hijo, n ,lista);
		}
	}

	// InOrden ------------------------------------------------------------------------
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<>();
		if(!a.isEmpty()) {
			ej2InOrden(a, n, lista);
		}
		return lista;
	}
	
	private void ej2InOrden(GeneralTree <Integer> a, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> hijos = a.getChildren();
		if(a.hasChildren()) {
			ej2InOrden(hijos.get(0), n, lista); // De todos los children me quedo con el que esta en la pos 0 y llamo con ese
		}
		// Cuando llega hasta aca es porque un nodo no tenia hijos, llegue a la hoja "mas izquierda"
		// Entonces se corta la recursion del subarbol: ahora proceso el dato, despues la raiz y despues los otros hijos
		if( (a.getData() > n) && (a.getData() % 2 != 0) ) {
			lista.add(a.getData());
		}
		
		// Procesa al resto de los hijos (exceptuando al primero)
		for (int i = 1; i < hijos.size(); i++) {
			ej2InOrden(hijos.get(i), n, lista);
		}
		
	}

	// PostOrden ------------------------------------------------------------------------
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<>();
		if(!a.isEmpty()) {
			ej2PostOrden(a, n, lista);
		}
		return lista;
	}
	
	private void ej2PostOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
		for(GeneralTree<Integer> hijo : a.getChildren()) {
			ej2PreOrden(hijo, n ,lista);
		}
		if( (a.getData() > n) && (a.getData() % 2 != 0) ) {
			lista.add(a.getData());
		}
		
	}

	// Por Niveles ------------------------------------------------------------------------
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<>();
		if(a.isEmpty() ) {
			return lista;
		}
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<Integer> nodoActual = cola.dequeue();
			if(nodoActual != null) {
				if((nodoActual.getData() > n) && (nodoActual.getData() % 2 != 0)) {
					lista.add(nodoActual.getData());
				}
				for(GeneralTree<Integer> hijo : nodoActual.getChildren()) {
					cola.enqueue(hijo);
				}
			}
			else {
				if(!cola.isEmpty()) {
					// Cambio de nivel
					cola.enqueue(null);
				}
			}
		}
		return lista;
	}
	
	// Eso está bien supongo pero como no me importan realmente los niveles ni los cambios de nivel, podría no usar el encolar null por fin de nivel.
	// Me ahorro validaciones innecesarias (chequeos por != null).
}


//b)Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>,
//¿qué modificaciones haría tanto en la firma como en la implementación de los mismos?
//Respuesta:
	// En la firma saco el parámetro GeneralTree porque va a ser el objeto this.
	// En la implementación de ls¿os métodos sólo modifico que en vez de invocar al objetos "a" uso el objeto "this".