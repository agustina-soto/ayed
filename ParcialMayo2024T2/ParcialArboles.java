package ParcialMayo2024T2;

//15/6/2024 Tema2

import java.util.ArrayList;
import java.util.List;

import TP3.GeneralTree;
import clases.*;

public class ParcialArboles {
	private GeneralTree<Integer> arbol;

	public ParcialArboles() {
		this.arbol = new GeneralTree<>(10);

		GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
		GeneralTree<Integer> nodoNeg5 = new GeneralTree<>(-5);

		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo22 = new GeneralTree<>(22);
		GeneralTree<Integer> nodo19 = new GeneralTree<>(19);

		GeneralTree<Integer> nodoNeg6 = new GeneralTree<>(-6);
		GeneralTree<Integer> nodo2_izq = new GeneralTree<>(2);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);

		GeneralTree<Integer> nodo28 = new GeneralTree<>(28);
		GeneralTree<Integer> nodo55 = new GeneralTree<>(55);
		GeneralTree<Integer> nodo18 = new GeneralTree<>(18);
		GeneralTree<Integer> nodo4_derecha = new GeneralTree<>(4);

		GeneralTree<Integer> nodo2_der = new GeneralTree<>(2);
		GeneralTree<Integer> nodo8_der = new GeneralTree<>(8);
		GeneralTree<Integer> nodo4_izquierda = new GeneralTree<>(4);

		// Asignación de hijos
		nodo5.setChildren(List.of(nodoNeg6, nodo2_izq, nodo6));
		nodo22.setChildren(List.of(nodo28, nodo55, nodo18, nodo4_derecha));
		nodo19.setChildren(List.of(nodo2_der, nodo8_der, nodo4_izquierda));

		nodo8.setChildren(List.of(nodo5, nodo22));
		nodoNeg5.setChildren(List.of(nodo19));

		this.arbol.setChildren(List.of(nodo8, nodoNeg5));
	}

	public List<Integer> nivel (int num) {
		List<Integer> lista = new ArrayList<>();
		if(this.arbol != null && !this.arbol.isEmpty()) {
			lista = nivel(num, this.arbol);
		}
		return lista;
	}

	private List<Integer> nivel(int num, GeneralTree<Integer> arbol) {
		int cant = 0;
		boolean ok = true;
		List<Integer> listaAux = new ArrayList<Integer>();
		Queue<GeneralTree<Integer>> kiu = new Queue<GeneralTree<Integer>>();
		kiu.enqueue(arbol);
		kiu.enqueue(null);
		while(!kiu.isEmpty() && ok) {
			GeneralTree<Integer> aux = kiu.dequeue();
			if(aux != null) {
				if(aux.getChildren().size() >= num) {
					listaAux.add(aux.getData());
				}
				for(GeneralTree<Integer> hijo : aux.getChildren()) {
					kiu.enqueue(hijo);
					cant++;
				}
			}
			else {
				if(listaAux.size() == cant) {
					ok = false;
				} else {
					listaAux.clear();
					cant = 0;
				}
				if(!kiu.isEmpty()) {
					kiu.enqueue(null);
				}
			}
		}
		return listaAux;
	}
}