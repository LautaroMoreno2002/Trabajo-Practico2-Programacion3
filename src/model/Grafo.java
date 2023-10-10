package model;

import java.util.ArrayList;
import java.util.HashSet;
import algoritmoAGM.Arista;

public class Grafo {
	
	private int _vertices;													
	private int[][] _matrizPesos; 													
	private ArrayList<HashSet<Integer>> _vecinos; 							
	
	public Grafo(int cantVertices) {
		if (cantVertices < 0) throw new IllegalArgumentException("La cantidad de vertices para el grafo debe ser de 0 en adelante.");
		_vertices = cantVertices;
		_matrizPesos = new int[cantVertices][cantVertices];
		_vecinos = new ArrayList<HashSet<Integer>>();
		inicializarMatrizPesos();
		inicializarVecinos();
	}
	private void inicializarMatrizPesos() {
		if (_matrizPesos.length > 0) {
			for (int fila = 0; fila < _matrizPesos.length; fila++) {
				for (int columna = 0; columna < _matrizPesos[fila].length; columna++) {
					_matrizPesos[fila][columna] = -1;
				}
			}
		}
		
	}
	public boolean sonVecinos(int verticeA, int verticeB) {
		validarIndices(verticeA, verticeB);
		return _matrizPesos[verticeA][verticeB] != -1;
	}
	public void agregarArista(int verticeOrigen, int verticeDestino, int peso) {
		validarIndices(verticeOrigen,verticeDestino);
		validarPeso(peso);
		if (verticeOrigen != verticeDestino) {
			_vecinos.get(verticeOrigen).add(verticeDestino);
			_vecinos.get(verticeDestino).add(verticeOrigen);			
		}
		_matrizPesos[verticeOrigen][verticeDestino] = _matrizPesos[verticeDestino][verticeOrigen] = peso;
	}
	private void validarIndices(int verticeOrigen, int verticeDestino) {
		if (verticeOrigen < 0 || verticeOrigen >= _matrizPesos.length) 
			throw new IllegalArgumentException("El vértice origen no puede ser negativo y tiene que estar previamente registrado.");
		if (verticeDestino < 0 || verticeDestino >= _matrizPesos.length) 
			throw new IllegalArgumentException("El vértice destino no puede ser negativo y tiene que estar previamente registrado.");
	}
	private void validarPeso(int peso) {
		if (peso < -1) 
			throw new IllegalArgumentException("El peso no puede ser negativo.");
	}
	public void eliminarArista(int verticeOrigen, int verticeDestino) {
		validarIndices(verticeOrigen, verticeDestino);
		if (existeArista(verticeOrigen, verticeDestino)) {
			_matrizPesos[verticeOrigen][verticeDestino] = _matrizPesos[verticeDestino][verticeOrigen] = -1;
			_vecinos.get(verticeOrigen).remove(verticeDestino);
			_vecinos.get(verticeDestino).remove(verticeOrigen);			
		}
	}
	public boolean existeArista(int verticeOrigen, int verticeDestino) {
		validarIndices(verticeOrigen, verticeDestino);
		return _matrizPesos[verticeOrigen][verticeDestino] != -1;
	}
	public int pesoEntreDosVecinos(int verticeOrigen, int verticeDestino) {
		validarIndices(verticeOrigen, verticeDestino);
		if (verticeOrigen!=verticeDestino && existeArista(verticeOrigen,verticeDestino)) 
			return _matrizPesos[verticeOrigen][verticeDestino];
		return -1;
	}
	public HashSet<Integer> vecinosDelVertice(int vertice) {
		if (vertice < 0 || vertice >= _matrizPesos.length) throw new IllegalArgumentException("Vertice inválido.");
		return this._vecinos.get(vertice);
	}
	private void inicializarVecinos() {
		for (int indice = 0; indice < _vertices; indice++) {
			_vecinos.add(new HashSet<Integer>());
		}
	}
	public void agregarVertice() {
		_vertices++;
		redimensionarMatriz();
		_vecinos.add(new HashSet<Integer>());
	}
	public void imprimirMatriz() {
		for (int fila = 0; fila < _matrizPesos.length; fila++) {
			for (int columna = 0; columna < _matrizPesos[fila].length; columna++) {
				System.out.print(_matrizPesos[fila][columna] + " "); 
			}
			System.out.println(); 
		}
	}
	private void redimensionarMatriz() {
		int[][] mAuxiliar = new int[_matrizPesos.length + 1][_matrizPesos.length + 1];
		for (int fila = 0; fila < _matrizPesos.length; fila++) {
			for (int columna = 0; columna < _matrizPesos[fila].length; columna++) {
				mAuxiliar[fila][columna] = _matrizPesos[fila][columna];
			}
		}
		_matrizPesos = mAuxiliar;
	}
	public void imprimirVecinos() {
		for (int vertice = 0; vertice < _vecinos.size(); vertice++) {
			System.out.print("Vecinos de " + vertice + ": ");
			HashSet<Integer> vecinosDeI = _vecinos.get(vertice);
			for (int vecino : vecinosDeI) {
				System.out.print(vecino + " ");
			}
			System.out.println(); // Salto de línea después de imprimir los vecinos de un elemento
		}
	}
	public void sacarAristaMasGrande() {
		Arista candidatoArista = new Arista (0,0,-1);
		for (int fila = 0; fila < _matrizPesos.length; fila++) {
			for (int columna = 0; columna < _matrizPesos.length; columna++) {
				if (candidatoArista.getPesoEntreAmbos() < _matrizPesos[fila][columna]) {
					candidatoArista.setDesde(fila);
					candidatoArista.setHasta(columna);
					candidatoArista.setPesoEntreAmbos(_matrizPesos[fila][columna]);
				}
			}
		}
		eliminarArista(candidatoArista.getDesde(), candidatoArista.getHasta());
	}
	public int cantidadVertices() {
		return _matrizPesos.length;
	}
	public int[][] getMatrizDePesos(){
		return _matrizPesos;
	}
	public ArrayList<HashSet<Integer>> get_vecinos() {
		return _vecinos;
	}
}