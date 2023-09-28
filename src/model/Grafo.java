package model;

import java.util.ArrayList;
import java.util.HashSet;


public class Grafo {
	
	private int _vertices;													//Sirve para saber cuantos vertices tenemos
	private int[][] _MA; 													// matriz de adyacencia
	private ArrayList<HashSet<Integer>> _vecinos; 							// <vertice, vecinosDelVertice>
	
	
	
	public Grafo(int cantVertices) {
		_vertices = cantVertices;
		_MA = new int[cantVertices][cantVertices];
		_vecinos = new ArrayList<HashSet<Integer>>();
		 
		inicializarVecinos();
	}
	
	// Debe depender de la similitud de las personas.
	public void agregarArista(int i, int j, int peso)
	{
		_MA[i][j] = _MA[j][i] = peso;
		
		if (i != j) 
	        _vecinos.get(i).add(j);
	    if (j != i) 
	        _vecinos.get(j).add(i);	
	}

	public void eliminarArista(int i, int j)
	{
		_MA[i][j] = _MA[j][i] = 0;
	}

	public boolean existeArista(int i, int j)
	{
		return _MA[i][j]!=0;
	}
	
	private void inicializarVecinos() 
	{
		for (int i = 0; i < _vertices; i++) {
			_vecinos.add(new HashSet<Integer>());
		}
	}

	public void agregarVertice() 
	{
		_vertices++;
		redimensionarMatriz();
		_vecinos.add(new HashSet<Integer>());
		System.out.println(_MA.length);
	}
	
	// Test
	public void imprimirMatriz() {
		for (int i = 0; i < _MA.length; i++) {
		    for (int j = 0; j < _MA[i].length; j++) {
		        System.out.print(_MA[i][j] + " "); 
		    }
		    System.out.println(""); 
		}
	}
	
	private void redimensionarMatriz() {
		int[][] mAuxiliar = new int[_MA.length + 1][_MA.length + 1];
		for (int i = 0; i < _MA.length; i++) {
		    for (int j = 0; j < _MA[i].length; j++) {
		        mAuxiliar[i][j] = _MA[i][j];
		    }
		}
		_MA = mAuxiliar;
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

