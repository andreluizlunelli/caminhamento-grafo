package br.furb.grafos.caminhamento_grafo;

import org.junit.Test;

public class DijkstraMatrizTeste {

	int matrizAdjacencia[][] = new int[][] { 	{ 0, 50, 0, 0, 0, 0, 0, 0, 100 }, 
												{ 50, 0, 50, 0, 0, 0, 0, 100, 0 },
												{ 0, 50, 0, 75, 0, 0, 0, 0, 0 }, 
												{ 0, 0, 75, 0, 60, 0, 50, 0, 0 }, 
												{ 0, 0, 0, 60, 0, 50, 0, 0, 0 },
												{ 0, 0, 0, 0, 50, 0, 60, 0, 0 }, 
												{ 0, 0, 0, 50, 0, 60, 0, 50, 0 }, 
												{ 0, 100, 0, 0, 0, 0, 50, 0, 50 },
												{ 100, 0, 0, 0, 0, 0, 0, 50, 0 } };

	@Test
	public void testName() throws Exception {
		DijkstraMatriz dijkstra = new DijkstraMatriz(matrizAdjacencia, 0);
		System.out.println(dijkstra.getMenorCaminho(5));
		System.out.println(dijkstra.getCustoMenorCaminho(5));
		
	}
}
