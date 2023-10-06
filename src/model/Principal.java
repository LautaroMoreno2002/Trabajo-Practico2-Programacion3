package model;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	private List<Persona> personas;
	private Grafo grafo;
	
	public Principal() {
        personas = new ArrayList<Persona>();
        grafo = new Grafo(0);
        //test
        Persona abel = new Persona("Abel", 4,5,1,5);
        Persona lautaro = new Persona("Lautaro", 1,4,3,5);
        Persona karin = new Persona("Karin", 5,2,4,1);
        Persona lautaro2 = new Persona("Lautaro2", 3,5,5,5);
        Persona karin2 = new Persona("Karin2", 1,2,5,1);
        personas.add(abel);
        grafo.agregarVertice();
        personas.add(lautaro);
        grafo.agregarVertice();
        personas.add(karin);
        grafo.agregarVertice();
        personas.add(lautaro2);
        grafo.agregarVertice();
        personas.add(karin2);
        grafo.agregarVertice();

    }
	
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		Persona persona = new Persona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
		personas.add(persona);
		grafo.agregarVertice();
	}
	
	public void grafoCompleto() {
		for (int i = 0; i < personas.size(); i++) {
			for (int j = 0; j < personas.size(); j++) {
				if (i != j)
					grafo.agregarArista(i, j, personas.get(i).calcularSimilitud(personas.get(j)));
				else
					grafo.agregarArista(i, j, -1);
			}
		}
		grafo.imprimirMatriz();
		grafo.imprimirVecinos();
		System.out.println("AGM: \n");

        Grafo grafoA = AGM.prim(grafo);
        grafoA.imprimirMatriz();
        grafoA.imprimirVecinos();
        
        grafoA.sacarAristaMasGrande();
        
        grafoA.imprimirMatriz();
        grafoA.imprimirVecinos();
		
	}

	public List<Persona> getPersonas() {
		return personas;
	}
	
	public List<String> getNombresPersonas(){
		List<String> nombresPersonas = new ArrayList<String>();
		for(int i=0; i<personas.size();i++) {
			nombresPersonas.add(personas.get(i).getNombre());
		}
		return nombresPersonas;
	}
	
	
	
	
}