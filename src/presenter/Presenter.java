package presenter;

import java.util.List;

import modelo.ClusteringHumano;
import modelo.Persona;

public class Presenter {
	
	private ClusteringHumano clustering;
	
	public Presenter() {
		this.clustering = new ClusteringHumano();
	}
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		clustering.registrarPersona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
	}
	
	// Test
	public void iniciarAgrupamiento() {
		clustering.construirGrafoCompleto();
		clustering.construirAGMConPrim();
		clustering.sacarAristaDeMayorPeso();
	}
	
	public List<Persona> obtenerPersonas() { //!!
		System.out.println(clustering.getPersonas());
		return clustering.getPersonas();
	}
	
	public List<String> getNombresPersonas(){
		return clustering.getNombresPersonas();
	}
	
}