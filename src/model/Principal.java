package model;

import java.util.ArrayList;
import java.util.List;


public class Principal {
	private List<Persona> personas;
	private Grafo grafo;
	
	public Principal() {
		personas = new ArrayList<Persona>();
		grafo = new Grafo(0);
	}
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		Persona persona = new Persona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
		personas.add(persona);
		grafo.agregarVertice();
//		System.out.println(personas.get(0).toString());
	}
	
	public void grafoCompleto() {
		for (int i = 0; i < personas.size(); i++) {
			for (int j = 0; j < personas.size(); j++) {
				grafo.agregarArista(i, j, personas.get(i).calcularSimilitud(personas.get(j)));
			}
		}
		grafo.imprimirMatriz();
		grafo.imprimirVecinos();
	}
	
	
}