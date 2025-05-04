package TP3;

import java.util.ArrayList;
import java.util.List;

public class RecorridosAG {
	// Retorna una lista con los elementos impares del árbol “a”
	// que sean mayores al valor “n” pasados como parámetros
	
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
			ej2InOrden(hijos.get(0), n, lista); // De todos los children me quedo con el que esta en la pos 0
		}
		// Cuando llega hasta aca es porque un nodo no tenia hijos, entonces se corta la recursion del subarbol: ahora proceso el dato, despues la raiz y despues los otros hijos
		if( (a.getData() > n) && (a.getData() % 2 != 0) ) {
			lista.add(a.getData());
		}
		
		// Procesa al resto de los hijos (exceptuando al primero)
		for (int i = 1; i < hijos.size(); i++) {
			ej2InOrden(hijos.get(i), n, lista);
		}
		
	}
	 
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

	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<>();
		
		return lista;
	}
}