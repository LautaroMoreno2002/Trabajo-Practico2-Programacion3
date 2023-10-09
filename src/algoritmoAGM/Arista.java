package algoritmoAGM;

public class Arista {
	private int desde;
	private int hasta;
	private int pesoEntreAmbos;
	
	public Arista(int x, int y, int peso) {
		desde = x;
		hasta = y;
		pesoEntreAmbos = peso;
	}

	public int getDesde() {
		return desde;
	}

	public int getHasta() {
		return hasta;
	}

	public int getPesoEntreAmbos() {
		return pesoEntreAmbos;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public void setPesoEntreAmbos(int pesoEntreAmbos) {
		this.pesoEntreAmbos = pesoEntreAmbos;
	}

}
