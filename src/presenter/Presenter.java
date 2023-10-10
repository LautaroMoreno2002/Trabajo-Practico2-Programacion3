package presenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import model.ClusteringHumano;
import model.Grafo;
import model.Persona;

public class Presenter {
	private ClusteringHumano _clustering;
	public Presenter() {
		this._clustering = new ClusteringHumano();
	}
	public void registrarPersona(String nombre, int iDeportes, int iMusica, int iEspectaculo, int iCiencia) {
		_clustering.registrarPersona(nombre, iDeportes, iMusica, iEspectaculo, iCiencia);
		if (_clustering.getPersonas().size() > 2) iniciarAgrupamiento();
	}
	public void iniciarAgrupamiento() {
		_clustering.construirGrafoCompleto();
		_clustering.construirAGMConPrim();
		_clustering.sacarAristaDeMayorPeso();
	}
	public List<Persona> obtenerPersonas() { 
		return _clustering.getPersonas();
	}
	public List<String> getNombresPersonas(){
		return _clustering.getNombresPersonas();
	}
	public Grafo getGrafo() {
		return _clustering.getGrafo();
	}
	public boolean sonVecinos(int verticeA, int verticeB) {
	    return _clustering.getGrafo().sonVecinos(verticeA, verticeB);
	}
	public ArrayList<HashSet<Integer>> getArrayVecinos(){
		return _clustering.getGrafo().get_vecinos();
	}
	public Double getPromedioDeporte() {
		return _clustering.calcularSimilaridadPromedioDeporte();
	}
	public Double getPromedioMusica() {
		return _clustering.calcularSimilaridadPromedioMusica();
	}
	public Double getPromedioEspectaculo() {
		return _clustering.calcularSimilaridadPromedioEspectaculo();
	}
	public Double getPromedioCiencia() {
		return _clustering.calcularSimilaridadPromedioCiencia();
	}	
}