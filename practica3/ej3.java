package practica3;

public class ej3 {
	private void recorrerNiveles(GeneralTree<Integer> a) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		cola.enqueue(a);
		cola.enqueue(null);
		Integer altura = 0;
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null ) {
				List<GeneralTree<Integer>> lista = aux.getChildren();
				for(GeneralTree<Integer> elemento : lista) {
					cola.enqueue(elemento);
				}
		}
			else {
				if(!cola.isEmpty()) {
					altura += 1;
					cola.enqueue(null);
				}
			}
	}
		
		
		private Integer recorrerNivelesB(GeneralTree<Integer> a, Integer datoABuscar) { // la raiz no es null!!! :D:D:D:D:D:D segun yo
			if(a.getData().equals(datoAbuscar)) {
				return 0;
			}
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			GeneralTree<Integer> aux;
			cola.enqueue(a);
			cola.enqueue(null);
			Integer nivel = 0;
			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				if(aux != null ) {
					for(GeneralTree<Integer> elemento : aux.getChildren()) {
						if(elemento.dato.equals(datoABuscar)) {
							return nivel;
						}
						cola.enqueue(elemento);
					}
				}
				else {
					if(!cola.isEmpty()) {
						nivel += 1;
						cola.enqueue(null);
					}
				}
		}
			
			private Integer recorrerNivelesC(GeneralTree<Integer> a) {
				Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
				GeneralTree<Integer> aux;
				cola.enqueue(a);
				cola.enqueue(null);
				Integer max = -1;
				while(!cola.isEmpty()) {
					aux = cola.dequeue();
					if(aux != null ) {
						int auxInteger = 0;
						List<GeneralTree<Integer>> lista = aux.getChildren();
						for(GeneralTree<Integer> elemento : lista) {
							cola.enqueue(elemento);
							auxInteger+= 1;
						}
						if(auxInteger > max) {
							max = auxInteger;
						}
				}
					else {
						if(!cola.isEmpty()) {
							cola.enqueue(null);
						}
					}
					
					return max;
			}
}}
		
		
