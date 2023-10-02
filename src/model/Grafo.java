package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Grafo {
	
	private int _vertices;													//Sirve para saber cuantos vertices tenemos
	private int[][] _matrizPesos; 													// matriz de pesos
	private ArrayList<HashSet<Integer>> _vecinos; 							// <vertice, vecinosDelVertice>
	
	
	
	public Grafo(int cantVertices) {
		_vertices = cantVertices;
		_matrizPesos = new int[cantVertices][cantVertices];
		_vecinos = new ArrayList<HashSet<Integer>>();

		inicializarVecinos();
	}

	// Debe depender de la similitud de las personas.
	public void agregarArista(int i, int j, int peso) {
		_matrizPesos[i][j] = _matrizPesos[j][i] = peso;

		if (i != j) 
			_vecinos.get(i).add(j);
		if (j != i) 
			_vecinos.get(j).add(i);	
	}

	public void eliminarArista(int i, int j) {
		_matrizPesos[i][j] = _matrizPesos[j][i] = 0;
	}

	public boolean existeArista(int i, int j) {
		return _matrizPesos[i][j]!=0;
	}

	public int pesoEntreDosVecinos(int i, int j) {
		if (i!=j && existeArista(i,j)) 
			return _matrizPesos[i][j];
		return 0;
	}
	
	public HashSet<Integer> vecinosDe(int i) {
		if (_vecinos.size() > i)
			return this._vecinos.get(i);
		return null;
	}
	
	public int[] aristaConPesoMinimo(int i) { 	// pregunta por la arista (i,V) y devuelve un array con el V (vecino de i) y el peso mínimo
		int[] ret = {i,16}; // [vertice, pesoMinimo] -> 16 es un valor arbitrario
		HashSet<Integer> conjuntoVecinos = new HashSet<Integer>(_vecinos.get(i));
		for (int vecino : conjuntoVecinos) {
			if (ret[1] > this.pesoEntreDosVecinos(i, vecino))
				ret[1] = this.pesoEntreDosVecinos(i, vecino);
				ret[0] = vecino;
		}
		return ret;
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

}

