package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import model.Grafo;

public class GrafoTest {
	@Test
	public void inicializarGrafoVacio() {
		Grafo g = new Grafo(0);
		assertEquals(0,g.cantidadVertices());
	}
	@Test(expected = IllegalArgumentException.class)
	public void iniciarGrafoConCantidadVerticesNegativa() {
		Grafo g = new Grafo(-4);
		g.agregarArista(0, 0, 0);
	}
	@Test
	public void inicializarGrafoConVertices() {
		Grafo g = new Grafo(3);
		assertTrue(g.cantidadVertices()==3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void cargarAristaConIndiceExcedido() {
		Grafo g = new Grafo(2);
		g.agregarArista(3, 5, 10);
	}
	@Test(expected = IllegalArgumentException.class)
	public void cargarAristaConIndiceNegativo() {
		Grafo g = new Grafo(2);
		g.agregarArista(-3, 5, 10);
	}
	@Test(expected = IllegalArgumentException.class)
	public void cargarAristaConPesoNegativo() {
		Grafo g = new Grafo(2);
		g.agregarArista(3, 5, -10);
	}
	@Test
	public void comprobarExistenciaArista() {
		Grafo g = new Grafo(3);
		g.agregarArista(1, 2, 3);
		assertTrue(g.existeArista(1, 2));
	}
	@Test
	public void comprobarExistenciaCuandoNoHayArista() {
		Grafo g = new Grafo(2);
		g.agregarArista(0, 1, -1);
		assertFalse(g.existeArista(0, 1));
	}
	@Test
	public void agregarVerticeAlGrafo() {
		Grafo g = new Grafo(0);
		int cantidadInicial = g.cantidadVertices();
		g.agregarVertice();
		int cantidadActual = g.cantidadVertices();
		assertFalse(cantidadInicial == cantidadActual);
	}
	@Test
	public void iniciarTodaLaMatrizSinAristas() {
		Grafo g = new Grafo(3);
		int[][] esperado = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
		assertTrue(sonIguales(esperado, g.getMatrizDePesos()));
	}
	@Test
	public void matrizLuegoDeagregarAristaConPeso() {
		Grafo g = new Grafo(3);
		g.agregarArista(1, 2, 10);
		int[][] esperado = {{-1,-1,-1},{-1,-1,10},{-1,10,-1}};
		assertTrue(sonIguales(esperado,g.getMatrizDePesos()));
	}
	@Test
	public void vecinosDelVertice() {
		Grafo g = new Grafo(3);
		g.agregarArista(2, 1, 1);
		g.agregarArista(2, 0, 2);
		g.agregarArista(1, 0, 2);
		Set<Integer> esperado = new HashSet<Integer>();
		esperado.add(0);
		esperado.add(1);
		assertEquals(esperado,g.vecinosDelVertice(2));
	}
	@Test
	public void pesoIgualEntreDosVertices() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 10);
		assertEquals(g.pesoEntreDosVecinos(0, 1), g.pesoEntreDosVecinos(1, 0));
	}
	@Test
	public void eliminarArista() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 7);
		g.agregarArista(1, 2, 10);
		g.eliminarArista(0, 1);
		assertFalse(g.existeArista(0, 1));
	}
	@Test
	public void listaDeVecinosLuegoDeEliminarArista() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 5);
		g.agregarArista(0, 2, 5);
		g.agregarArista(1, 2, 4);
		String listaPreEliminacion = g.vecinosDelVertice(0).toString();
		g.eliminarArista(0,1);
		String listaPostEliminacion = g.vecinosDelVertice(0).toString();
		assertNotEquals(listaPreEliminacion, listaPostEliminacion);
	}
	private boolean sonIguales(int[][] matriz1, int[][] matriz2) {
		boolean ret = false;
		if (matriz1.length != matriz2.length) return ret;
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1.length; j++) {
				ret = ret || (matriz1[i][j] == matriz2[i][j]);
			}
		}
		return ret;
	}
}