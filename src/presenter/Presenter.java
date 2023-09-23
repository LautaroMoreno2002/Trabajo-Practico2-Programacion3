package presenter;

import model.Principal;

public class Presenter {
	
	private Principal principal;
	
	public Presenter() {
		this.principal = new Principal();
	}
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		int[] similaridad = {iDeportes, iMusica, iEspectaculo, iCiencia};
		principal.registrarPersona(nombre, similaridad);
	}
}