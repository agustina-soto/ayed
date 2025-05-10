package TP3;

public class ej6_RedDeAguaPotable {
	GeneralTree<Character> redAguaPotable;
	
	public ej6_RedDeAguaPotable(GeneralTree<Character> red) {
		this.redAguaPotable = red;
	}

	public double minimoCaudal(double caudal) {
		double min = Integer.MAX_VALUE;
		if(this.redAguaPotable != null && !this.redAguaPotable.isEmpty()) {
			min = minimoCaudal(caudal, this.redAguaPotable, min);
		}
		return min;
	}

	private double minimoCaudal(double caudal, GeneralTree<Character> nodo, double min) {
		if(nodo.isLeaf()) {
			if(caudal < min) {
				min = caudal;
			}
		}
		else {
			caudal = caudal/nodo.getChildren().size();
			for(GeneralTree<Character> hijo : nodo.getChildren()) {
				min = minimoCaudal(caudal, hijo, min);
			}
		}
		return min;
	}
}