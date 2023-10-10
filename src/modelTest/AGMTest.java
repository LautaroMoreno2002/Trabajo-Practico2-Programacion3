package modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import algoritmoAGM.AGM;
import model.Grafo;

public class AGMTest {
	@Test
	public void matrizAGMConGrafoDeTresVertices() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 3);
		g.agregarArista(0, 2, 4);
		g.agregarArista(2, 1, 5);
		int[][] esperado = {{-1,3,4},{3,-1,-1},{4,-1,-1}};
		Grafo gPrim = AGM.prim(g);
		assertTrue(sonIguales(esperado,gPrim.getMatrizDePesos()));
	}
	@Test
	public void matrizAGMConGrafoDeCuatroVertices() {
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1, 9);
		g.agregarArista(0, 2, 5);
		g.agregarArista(0, 3, 2);
		g.agregarArista(1, 2, 1);
		g.agregarArista(1, 3, 8);
		g.agregarArista(2, 3, 3);
		int[][] esperado = {{-1,-1,-1,2},{-1,-1,1,-1},{-1,1,-1,3},{2,-1,3,-1}};
		Grafo gPrim = AGM.prim(g);
		assertTrue(sonIguales(esperado,gPrim.getMatrizDePesos()));
	}
	@Test
	public void matrizAGMConGrafoDeCincoVertices() {
		Grafo g = new Grafo(5);
		g.agregarArista(0,1,6);
		g.agregarArista(0,2,11);
		g.agregarArista(0,3,5);
		g.agregarArista(0,4,14);
		g.agregarArista(1,2,11);
		g.agregarArista(1,3,5);
		g.agregarArista(1,4,8);
		g.agregarArista(2,3,10);
		g.agregarArista(2,4,5);
		g.agregarArista(3,4,9);
		int[][] esperado = {{-1,-1,-1,5,-1},{-1,-1,-1,5,8},{-1,-1,-1,-1,5},{5,5,-1,-1,-1},{-1,8,5,-1,-1}};
		Grafo gPrim = AGM.prim(g);
		assertTrue(sonIguales(esperado,gPrim.getMatrizDePesos()));
	}
	@Test
	public void compararMatrizGrafoAGMConGrafoOriginal() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 3);
		g.agregarArista(0, 2, 4);
		g.agregarArista(2, 1, 5);
		Grafo gPrim = AGM.prim(g);
		assertFalse(sonIguales(g.getMatrizDePesos(),gPrim.getMatrizDePesos()));
	}
	private static boolean sonIguales(int[][] matriz1, int[][] matriz2) {
		boolean ret = true;
		if (matriz1.length != matriz2.length) return ret;
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1.length; j++) {
				ret = ret && (matriz1[i][j] == matriz2[i][j]);
			}
		}
		return ret;
	}
}