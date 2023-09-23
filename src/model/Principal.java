package model;

import java.util.HashMap;

public class Principal {
	HashMap<String, int[]> personas;
	
	public Principal() {
		personas = new HashMap<>();
	}
	
	public void registrarPersona(String nombre, int[] preferencias) {
//		if(personaRegistrada(nombre))
		personas.put(nombre, preferencias);	
		System.out.println(personas.toString());
	}
}