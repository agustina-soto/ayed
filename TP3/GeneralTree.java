package TP3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import clases.Queue;

public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {

	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	// Devuelve la altura del árbol: la longitud del camino más largo desde el nodo
	// raíz hasta una hoja.
	public int altura() {
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		int suma = 0, cant = 0, altura = 0;
		while (!cola.isEmpty()) {
			GeneralTree<T> nodo = cola.dequeue();

			if (nodo != null) { // Si es un nodo del arbol
				cant++;
				suma = suma + (int) nodo.getData(); // Le hice el casting para que me deje de tirar error porque Data es
													// de tipo T :P no darle bola

				for (GeneralTree<T> hijo : nodo.getChildren()) {
					cola.enqueue(hijo);
				}
			} else if (!cola.isEmpty()) {
				altura++;
				cola.enqueue(null);
			}
		}
		return altura;
	}

	// Devuelve la profundidad o nivel del dato en el árbol.
	public int nivel(T dato) {
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel = 0;
		boolean found = false;
		while (!cola.isEmpty() && !found) {
			GeneralTree<T> nodo = cola.dequeue();

			if (nodo != null) { // Si es un nodo del arbol
				if (nodo.getData().equals(dato)) {
					found = true; // Cuando sale del while por esta condición, la variable nivel está seteada en
									// la cantidad de niveles ya procesados, asique devuelve bien
				} else {
					for (GeneralTree<T> hijo : nodo.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			} else if (!cola.isEmpty()) {
				nivel++;
				cola.enqueue(null);
			}
		}
		return nivel;
	}

	// El ancho de un árbol se define como la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.
	public int ancho() {
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		int max = -1, cant = 0;
		while (!cola.isEmpty()) {
			GeneralTree<T> nodo = cola.dequeue();
			if (nodo != null) { // Si es un nodo del arbol
				cant++;
				for (GeneralTree<T> hijo : nodo.getChildren()) {
					cola.enqueue(hijo);
				}
			} else if (!cola.isEmpty()) {
				cola.enqueue(null);
				if(cant > max) {
					max = cant;
				}
				cant = 0;
			}
		}
		return max;
	}

	// Devuelve true si el valor “a” es ancestro del valor “b”.
	// Asumo que "a" no es igual a "b"...
	public boolean esAncestro(T a, T b) {
		boolean ok = false;
		if(a != null && b != null && !this.isEmpty()) {
			GeneralTree<T> nodoA = buscarNodoConValorIterativo(a);
			if(nodoA != null) { // Si encontré un nodo con el valor A
				GeneralTree<T> nodoB = nodoA.buscarNodoConValorIterativo(b); 	// Reutilizo el mismo método para buscar "b" en nodoA
																				// Podría meter la búsqueda en la asignación del ok pero así me es más claro ;)
				ok = (nodoB != null); // Si encontré un nodo hijo con valor "b" o no
			}
		}
		return ok;
	}

	private GeneralTree<T> buscarNodoConValorIterativo(T valor) {
		boolean found = false;
		GeneralTree<T> nodo = new GeneralTree<>();
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty() && !found) {
			nodo = cola.dequeue();
			if(nodo != null) {
				if(nodo.getData().equals(valor)) {
					found = true;
					// en nodo me quedó el nodo que busco
				}
				else {
					for(GeneralTree<T> hijo : nodo.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}
			else if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		return nodo;
	}

	private GeneralTree<T> buscarNodoConValorRecursivo(T valor) {
		if(this.getData().equals(valor)) {
			return this;
		}
		GeneralTree<T> nodo = null;
		Iterator<GeneralTree<T>> iterator = this.getChildren().iterator();
		while(iterator.hasNext() && nodo == null) { // Mientras haya hijos por iterar y mientras no haya encontrado un resultado válido (uno distinto de null): sigo buscando
			nodo = buscarNodoConValorRecursivo(valor);
		}
		return nodo;
	}
}