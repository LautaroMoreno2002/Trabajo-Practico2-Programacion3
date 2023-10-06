package model;

import java.util.ArrayList;
import java.util.HashSet;

import agm.Arista;

public class Grafo {
	
	private int _vertices;													//Sirve para saber cuantos vertices tenemos
	private int[][] _matrizPesos; 													// matriz de pesos
	private ArrayList<HashSet<Integer>> _vecinos; 							// <vertice, vecinosDelVertice>
	
	
	
	public Grafo(int cantVertices) {
		_vertices = cantVertices;
		_matrizPesos = new int[cantVertices][cantVertices];
		_vecinos = new ArrayList<HashSet<Integer>>();
		inicializarMatrizPesos();
		inicializarVecinos();
	}

	private void inicializarMatrizPesos() {
		for (int fila = 0; fila < _matrizPesos.length; fila++) {
			for (int columna = 0; columna < _matrizPesos[fila].length; columna++) {
				_matrizPesos[fila][columna] = -1;
			}
		}
		
	}

	// Debe depender de la similitud de las personas.
	public void agregarArista(int i, int j, int peso) {
		if (i != j && j != i) {
			_vecinos.get(i).add(j);
			_vecinos.get(j).add(i);			
		}
		if (i == j) {
			_matrizPesos[i][j] = _matrizPesos[j][i] = -1;
		}
		_matrizPesos[i][j] = _matrizPesos[j][i] = peso;
	}

	public void eliminarArista(int i, int j) {
		_matrizPesos[i][j] = _matrizPesos[j][i] = -1;
		_vecinos.get(i).remove(j);
		_vecinos.get(j).remove(i);
	}

	public boolean existeArista(int i, int j) {
		return _matrizPesos[i][j] != -1;
	}

	public int pesoEntreDosVecinos(int i, int j) {
		if (i!=j && existeArista(i,j)) 
			return _matrizPesos[i][j];
		return -1;
	}
	
	public HashSet<Integer> vecinosDe(int i) {
		if (_vecinos.size() > i)
			return this._vecinos.get(i);
		return null;
	}
	
	private void inicializarVecinos() {
		for (int i = 0; i < _vertices; i++) {
			_vecinos.add(new HashSet<Integer>());
		}
	}

	public void agregarVertice() {
		_vertices++;
		redimensionarMatriz();
		_vecinos.add(new HashSet<Integer>());
		System.out.println(_matrizPesos.length);
	}

	// Test
	public void imprimirMatriz() {
		for (int i = 0; i < _matrizPesos.length; i++) {
			for (int j = 0; j < _matrizPesos[i].length; j++) {
				System.out.print(_matrizPesos[i][j] + " "); 
			}
			System.out.println(""); 
		}
	}

	private void redimensionarMatriz() {
		int[][] mAuxiliar = new int[_matrizPesos.length + 1][_matrizPesos.length + 1];
		for (int i = 0; i < _matrizPesos.length; i++) {
			for (int j = 0; j < _matrizPesos[i].length; j++) {
				mAuxiliar[i][j] = _matrizPesos[i][j];
			}
		}
		_matrizPesos = mAuxiliar;
	}

	public void imprimirVecinos() {
		for (int i = 0; i < _vecinos.size(); i++) {
			System.out.print("Vecinos de " + i + ": ");

			HashSet<Integer> vecinosDeI = _vecinos.get(i);

			for (int vecino : vecinosDeI) {
				System.out.print(vecino + " ");
			}

			System.out.println(); // Salto de línea después de imprimir los vecinos de un elemento
		}
	}
	
	public int cantidadVertices() {
		return _matrizPesos.length;
	}

	public void sacarAristaMasGrande() {
		Arista candidatoArista = new Arista (0,0,0);
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
	
}

