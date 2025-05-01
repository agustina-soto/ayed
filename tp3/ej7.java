package tp3;

import java.util.List;

public class ej7 {
		public List<Integer> caminoAHojaMasLejana() {
			List<Integer> listaAux = new ArrayList<Integer>();
			List<Integer> listaMax = new ArrayList<Integer>();
			
				for(GeneralTree<T> arbol : this.getChildren()) {
					listaAux.addAll(arbol.caminoHojaMasLejana());
				}
			
		}
}
