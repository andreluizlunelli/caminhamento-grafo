package br.furb.grafos.caminhamento_grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("grafo.txt"))) {
			int nVertices = 0;
			int matrizAdjacencia[][] = null;
			String line;
			int nRotulo = 0;
			while ((line = br.readLine()) != null) {
				if (nVertices == 0) {
					nVertices = Integer.parseInt(line);
					matrizAdjacencia = new int[nVertices][nVertices];
				} else {
					String[] split = line.split(",");
					int j = 0;
					for (String string : split) {
						int valAresta = Integer.parseInt(string);
						matrizAdjacencia[nRotulo][j] = valAresta;
						j++;
					}
					nRotulo++;
				}
			}
			Grafo grafo = new Grafo(matrizAdjacencia);
			Grafo eulerizado = grafo.eulerizar();
			int[][] retornaMatrizPFleury = eulerizado.retornaMatrizPFleury();
			System.out.println(new Fleury().geraCicloEuleriano(retornaMatrizPFleury));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
