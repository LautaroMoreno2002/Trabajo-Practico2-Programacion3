package model;

import java.util.ArrayList;
import java.util.List;
import algoritmoAGM.AGM;

public class ClusteringHumano {
	private List<Persona> _personas;
	private Grafo _grafo;
	
	public ClusteringHumano() {
        _personas = new ArrayList<Persona>();
        _grafo = new Grafo(0);
    }
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		Persona persona = new Persona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
		_personas.add(persona);
		_grafo.agregarVertice();
	}
	public void construirGrafoCompleto() {
		for (int fila = 0; fila < _personas.size(); fila++) {
			for (int columna = 0; columna < _personas.size(); columna++) {
				if (fila != columna)
					_grafo.agregarArista(fila, columna, _personas.get(fila).calcularSimilitud(_personas.get(columna)));
				else
					_grafo.agregarArista(fila, columna, -1);
			}
		}
	}
	public void construirAGMConPrim() {
		Grafo grafoAGM = AGM.prim(_grafo);
		_grafo = grafoAGM;
	}
	public void sacarAristaDeMayorPeso() {
		_grafo.sacarAristaMasGrande();
	}
	public Double calcularSimilaridadPromedioDeporte(){
		Double contador = 0.0;
		for(Persona persona: _personas) {
			contador+=persona.getiDeportes();
		}
		return contador/ _personas.size();
	}
	public Double calcularSimilaridadPromedioMusica(){
		Double contador = 0.0;
		for(Persona persona: _personas) {
			contador+=persona.getiMusica();
		}
		return contador/ _personas.size();
	}
	public Double calcularSimilaridadPromedioEspectaculo(){
		Double contador = 0.0;
		for(Persona persona: _personas) {
			contador+=persona.getiEspectaculo();
		}
		return contador/ _personas.size();
	}
	public Double calcularSimilaridadPromedioCiencia(){
		Double contador = 0.0;
		for(Persona persona: _personas) {
			contador+=persona.getiCiencia();
		}
		return contador/ _personas.size();
	}
	public List<Persona> getPersonas() {
		return _personas;
	}
	public List<String> getNombresPersonas(){
		List<String> nombresPersonas = new ArrayList<String>();
		for(int fila = 0; fila < _personas.size(); fila++) {
			nombresPersonas.add(_personas.get(fila).getNombre());
		}
		return nombresPersonas;
	}
	public Grafo getGrafo() {
		return _grafo;
	}
	public void mostrarEstadoMatriz() {
		_grafo.imprimirMatriz();
	}
	public void mostrarVerticesDelGrafo() {
		_grafo.imprimirVecinos();
	}
}