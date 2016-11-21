package br.furb.grafos.caminhamento_grafo;

import org.junit.Test;

public class FleuryTest {

	int matrizAdjacencia[][] = new int[][] { 	{ 0, 1, 0, 0, 0, 0, 0, 0, 1 }, 
												{ 1, 0, 2, 0, 0, 0, 0, 1, 0 },
												{ 0, 2, 0, 2, 0, 0, 0, 0, 0 }, 
												{ 0, 0, 2, 0, 1, 0, 1, 0, 0 }, 
												{ 0, 0, 0, 1, 0, 1, 0, 0, 0 },
												{ 0, 0, 0, 0, 1, 0, 1, 0, 0 }, 
												{ 0, 0, 0, 1, 0, 1, 0, 2, 0 }, 
												{ 0, 1, 0, 0, 0, 0, 2, 0, 1 },
												{ 1, 0, 0, 0, 0, 0, 0, 1, 0 } 	};

	@Test
	public void testName() throws Exception {
		System.out.println(new Fleury().geraCicloEuleriano(matrizAdjacencia));
	}
}
