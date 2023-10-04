package AGM;

import java.util.ArrayList;
import java.util.HashSet;

import model.Grafo;


public class SolverAGM {
	private static ArrayList<Integer> _verticesAGM;
	private static ArrayList<Integer> _aristasAGM;
//	private static ArrayList<Integer> aristasCandidatas;
//	private static ArrayList<Integer> verticesCandidatas;
//	private static Grafo g;
	/*
	 	VT := {u} (u cualquier vertice de G)
		ET := ∅
		i := 1
		mientras i ≤ n − 1 hacer
			elegir e = (u, v) ∈ E tal que l(e) sea mınima
			entre las aristas que tienen un extremo
			u ∈ VT y el otro v ∈ V \ VT
			ET := ET ∪ {e}
			VT := VT ∪ {v}
			i := i + 1
		retornar T = (VT , ET)
	 */
//	
//	public static int[] aristaConPesoMinimo(int i) { 	// pregunta por la arista (i,V) y devuelve un array con el V (vecino de i) y el peso mínimo
//		int[] ret = {i,16}; // [vertice, pesoMinimo] -> 16 es un valor arbitrario
//		HashSet<Integer> conjuntoVecinos = new HashSet<Integer>(g.vecinosDe(i));
//		for (int vecino : conjuntoVecinos) {
//			if (!verticesAGM.contains(vecino)) {
//				if (ret[1] > g.pesoEntreDosVecinos(i, vecino))
//					ret[0] = vecino;
//					ret[1] = g.pesoEntreDosVecinos(i, vecino);	
//				}
//				else {
//					aristasCandidatas.add(g.pesoEntreDosVecinos(i, vecino));
//					verticesCandidatas.add(vecino);
//				}
//			}
//		return ret;
//	}
//	
//	public static void esConexo(Grafo gr) {
//		if (gr == null) {
//			throw new IllegalArgumentException("No se puede hacer un agm de un grafo nulo");
//		}
//		if (!BFS.esConexo(gr)) {
//			throw new IllegalArgumentException("No se puede hacer un agm de un grafo no conexo");
//		}
//	}
//	public static Grafo prim(Grafo gr) {
//		esConexo(gr);
//		if (gr.cantidadVertices() <= 1) {
//			return gr;
//		}
//		
//		g = gr;
//		verticesAGM = new ArrayList<Integer>();
//		aristasAGM = new ArrayList<Integer>();
//		int i = 0;
//		verticesAGM.add(0);
//		int[] arreglo;
//		while (i < g.cantidadVertices()) {
//			arreglo = aristaConPesoMinimo(i);
//			if (!verticesAGM.contains(arreglo[0])) {
//				aristasAGM.add(arreglo[1]);
//				verticesAGM.add(arreglo[0]);	
//				aristasCandidatas.remove(arreglo[1]);
//				verticesCandidatas.remove(arreglo[0]);
//				i++;
//			}
//			//int e = g.dameAristaMinima(i); // e = (i, v != de x E Vt)
//		}
//		return null;			
//	}
//	
	
	
	public static Grafo prim(Grafo grafoCompleto) {
		esConexo(grafoCompleto);
		if (grafoCompleto.cantidadVertices()<2) return grafoCompleto;
		_verticesAGM = new ArrayList<Integer>();
		_aristasAGM = new ArrayList<Integer>();
		_verticesAGM.add(0);
		int iteraciones = 1;
		while (iteraciones <= grafoCompleto.cantidadVertices()-1) {
			/*elegir e = (u, v) ∈ E tal que l(e) sea mınima
			entre las aristas que tienen un extremo
			u ∈ VT y el otro v ∈ V \ VT*/
			int[] e = aristaConPesoMinimo(grafoCompleto,_verticesAGM);
			_aristasAGM.add(e); // le pasa la arista (x,y) con el peso entre ambas
			_verticesAGM.add(e[1]);
			iteraciones++;
		}
		return null;
	}
	private static void esConexo(Grafo gr) {
		if (gr == null) throw new IllegalArgumentException("No se puede hacer un agm de un grafo nulo");
		if (!BFS.esConexo(gr)) throw new IllegalArgumentException("No se puede hacer un agm de un grafo no conexo");
	}
	private static int[] aristaConPesoMinimo(Grafo grafoCompleto, ArrayList<Integer> verticesAGM) {
		int arista[] = new int[3];
		arista[2] = 20;
		for (int vertice : verticesAGM) {
			int[] candidatoArista = conseguirAristaMinimaEntreLosVecinosDelVertice(vertice,grafoCompleto,verticesAGM);
			if (candidatoArista[2]<arista[2]) {
				arista[0] = vertice;
				arista[1] = candidatoArista[1];
				arista[2] = candidatoArista[2];
			}
		}
		return arista;
	}
	private static int[] conseguirAristaMinimaEntreLosVecinosDelVertice(int vertice, Grafo grafoCompleto, ArrayList<Integer> verticesAGM) {
		int[] candidatoArista = {vertice,vertice,20};
		HashSet<Integer> vecinosDelVertice = grafoCompleto.vecinosDe(vertice);
		for (int vecino : vecinosDelVertice) {
			if (!verticesAGM.contains(vecino) && grafoCompleto.pesoEntreDosVecinos(vertice, vecino) < candidatoArista[2]) {
				candidatoArista[1] = vecino;
				candidatoArista[2] = grafoCompleto.pesoEntreDosVecinos(vertice, vecino);
			}
		}
		return candidatoArista;
	}
	
}
