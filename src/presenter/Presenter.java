package presenter;

import java.util.List;
import model.Persona;
import model.ClusteringHumano;

public class Presenter {
	
	private ClusteringHumano principal;
	
	public Presenter() {
		this.principal = new ClusteringHumano();
	}
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		principal.registrarPersona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
	}
	
	// Test
	public void iniciarAgrupamiento() {
		principal.construirGrafoCompleto();
		principal.construirAGMConPrim();
		principal.sacarAristaDeMayorPeso();
	}
	
	public List<Persona> obtenerPersonas() { //!!
		System.out.println(principal.getPersonas());
		return principal.getPersonas();
	}
	
	public List<String> getNombresPersonas(){
		return principal.getNombresPersonas();
	}
	
}