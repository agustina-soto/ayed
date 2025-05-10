package TP3;

public class AreaEmpresa {
	private String area;
	private int tardanza;
	
	public AreaEmpresa(String a, int t ) {
		this.area = a;
		this.tardanza = t;
	}

	public String getArea() {
		return this.area;
	}
	
	public int getTardanza() {
		return this.tardanza;
	}
}
