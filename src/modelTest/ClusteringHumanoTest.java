package modelTest;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;
import model.ClusteringHumano;

public class ClusteringHumanoTest {
	@Test
	public void estadoDeGrafoAlRegistrarPersonas() {
		ClusteringHumano ch = new ClusteringHumano();
		int[][] chMatrizPreRegistro = ch.getGrafo().getMatrizDePesos();
		ch.registrarPersona("Lautaro", 1, 4, 3, 5);
		int[][] chMatrizPostRegistro = ch.getGrafo().getMatrizDePesos();
		assertFalse(sonIguales(chMatrizPreRegistro,chMatrizPostRegistro));
	}
	@Test
	public void hacerGrafoCompleto() {
		ClusteringHumano ch = inicializarYConstruirGrafoCompleto();
		int[][] esperado = {{-1,10,8},{10,-1,4},{8,4,-1}};
		assertTrue(sonIguales(esperado, ch.getGrafo().getMatrizDePesos()));
	}
	@Test
	public void todosSonVecinosEnGrafoCompleto() {
		ClusteringHumano ch = inicializarYConstruirGrafoCompleto();
		Set<Integer> vecinosV0 = ch.getGrafo().vecinosDelVertice(0);
		Set<Integer> vecinosV1 = ch.getGrafo().vecinosDelVertice(1);
		Set<Integer> vecinosV2 = ch.getGrafo().vecinosDelVertice(2);
		assertTrue(todosEstanContenidos(vecinosV0, 1, 2) && todosEstanContenidos(vecinosV1, 0, 2) &&
					todosEstanContenidos(vecinosV2, 0, 1));
	}
	@Test
	public void construirAGM() {
		ClusteringHumano ch = inicializarYConstruirGrafoCompleto();
		ch.construirAGMConPrim();
		int[][] matrizAGM = ch.getGrafo().getMatrizDePesos();
		int[][] matrizEsperada = {{-1,-1,8},{-1,-1,4},{8,4,-1}};
		assertTrue(sonIguales(matrizAGM, matrizEsperada));
	}
	@Test
	public void sacarAristaDeMayorPesoEnUnAGM() {
		ClusteringHumano ch = inicializarYConstruirGrafoCompleto();
		ch.construirAGMConPrim();
		ch.sacarAristaDeMayorPeso();
		int[][] matrizAGM = ch.getGrafo().getMatrizDePesos();
		int[][] matrizEsperada = {{-1,-1,-1},{-1,-1,4},{-1,4,-1}};
		assertTrue(sonIguales(matrizAGM, matrizEsperada));
	}
	private ClusteringHumano inicializarYConstruirGrafoCompleto() {
		ClusteringHumano ch = new ClusteringHumano();
		ch.registrarPersona("Lautaro", 2, 1, 5, 3);
		ch.registrarPersona("Karin", 5, 3, 1, 2);
		ch.registrarPersona("Abel", 3, 3, 1, 4);
		ch.construirGrafoCompleto();
		return ch;
	}
	private boolean sonIguales(int[][] matriz1, int[][] matriz2) {
		boolean ret = false;
		if (matriz1.length != matriz2.length) return ret;
		for (int i = 0; i < matriz1.length; i++) 
			for (int j = 0; j < matriz1.length; j++) 
				ret = ret || (matriz1[i][j] == matriz2[i][j]);
		return ret;
	}
	private boolean todosEstanContenidos(Set<Integer> g, int p, int q) {
		return 	g.contains(p) && g.contains(q);	
	}
}