package presenter;

import java.util.List;
import model.Persona;
import model.Principal;

public class Presenter {
	
	private Principal principal;
	
	public Presenter() {
		this.principal = new Principal();
	}
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		principal.registrarPersona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
	}
	
	// Test
	public void grafoCompleto() {
		principal.grafoCompleto();
	}
	
	public List<Persona> obtenerPersonas() { //!!
		System.out.println(principal.getPersonas());
		return principal.getPersonas();
	}
	
	public List<String> getNombresPersonas(){
		return principal.getNombresPersonas();
	}
	
}