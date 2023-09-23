package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Grafo {
	
	private int _vertices;
	private boolean[][] _MA; // matriz de adyacencia
	private ArrayList<HashSet<Integer>> _vecinos; // <vertice, vecinosDelVertice>
	
	public Grafo(int cantVertices) {
		_vertices = cantVertices;
		_MA = new boolean[cantVertices][cantVertices];
		grafoCompleto();
		_vecinos = new ArrayList<HashSet<Integer>>();
		inicializarVecinos();
	}
	
	private void grafoCompleto() {
		for (int i = 0; i < _MA.length; i++) {
			for (int j = 0; j < _MA.length; j++) {
				if (i!=j) {
					_MA[i][j] = true;
				}
			}	
		}
	}
	
	private void inicializarVecinos() {
		for (int i = 0; i < _vertices; i++) {
			_vecinos.add(new HashSet<Integer>());
		}
	}
	
	public void agregarArista(int i, int j){
		_MA[i][j] = _MA[j][i] = true;
	}

	public void eliminarArista(int i, int j){
		_MA[i][j] = _MA[j][i] = false;
	}

	public boolean existeArista(int i, int j){
		return _MA[i][j];
	}

	
}
