package presenter;

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
	
}