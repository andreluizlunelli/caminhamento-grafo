package br.furb.grafos.caminhamento_grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Grafo {		
	
	private int[][] matrizAdjacencia;

	public Grafo(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
	}

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
			grafo.eulerizar();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void eulerizar() {
		// TODO Auto-generated method stub
		
	}
}
