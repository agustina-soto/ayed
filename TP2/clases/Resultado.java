package clases;

public class Resultado {
	private int suma;
	private int dif;
	
	public Resultado(int s, int d) {
		this.suma = s;
		this.dif = d;
	}
	
	public void setSuma(int s) {
		this.suma = s;
	}
	
	public void setDif(int d) {
		this.dif = d;
	}
	
	public int getSuma() {
		return suma;
	}

	public int getDiferencia() {
		return dif;
	}
}
