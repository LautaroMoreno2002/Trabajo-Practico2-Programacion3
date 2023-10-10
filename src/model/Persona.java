package model;

public class Persona {
	private String nombre;
	private int iDeportes, iMusica, iEspectaculo, iCiencia;
	
	public Persona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		this.nombre = nombre;
		this.iDeportes = iDeportes;
		this.iMusica = iMusica;
		this.iEspectaculo = iEspectaculo;
		this.iCiencia = iCiencia;
	}
	public String getNombre() {
		return nombre;
	}
	public int getiDeportes() {
		return iDeportes;
	}
	public int getiMusica() {
		return iMusica;
	}
	public int getiEspectaculo() {
		return iEspectaculo;
	}
	public int getiCiencia() {
		return iCiencia;
	}
	public int calcularSimilitud(Persona persona) {
		return  Math.abs(iDeportes - persona.iDeportes) + Math.abs(iMusica - persona.iMusica) +
				Math.abs(iEspectaculo - persona.iEspectaculo) + Math.abs(iCiencia - persona.iCiencia);
	}
}