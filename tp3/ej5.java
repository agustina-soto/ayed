package tp3;

public class ej5 { //clase general tree
		public boolean esAncestro(T a , T b ) {
			GeneralTree<T> arbolitoAuxiliar = buscarA(a);
			if(a != null) {
				return arbolitoAuxiliar.contiene(b); // se puede usar contain??? redefino el equals???
			}
			else return false;
		}
		
		
		public GeneralTree<T> buscarA(T a) {
			if(this.getData() == a) {
				return this;
			}
			else {
				for(GeneralTree<T> arbol : this.getChildren() ) {
					GeneralTree<T> aux = buscarA(a);
					if(aux != null) {
						return aux;
					}
				}
				return null;
			}
		}
		
		public boolean contiene(T b) {
			for(GeneralTRee dato : this.getChildren()) {
				if(dato.getData().equals(b)) {
					return true;
				}
			}
			return false;
		}
		}
