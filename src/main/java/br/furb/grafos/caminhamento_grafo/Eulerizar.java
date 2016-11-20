package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;
import java.util.List;

public class Eulerizar {

	private Grafo grafo;
	
	public Eulerizar(Grafo grafo) {
		this.grafo = grafo;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public Grafo aplicar() {
		int[][] verticesImpares = obterVerticesImpares();
		
		return null;
	}

	private int[][] obterVerticesImpares() {
		int[][] matrizAdjacencia, matrizImpares = null;
		List matrizImparesTmp = new ArrayList(); 
		matrizAdjacencia = this.grafo.getMatrizAdjacencia();
		int numVertices = 0;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] > 0) {
					numVertices = matrizAdjacencia[i][j];
				}				
			}
			if (numVertices % 2 != 0) {
				matrizImparesTmp.add(new int[numVertices]);
			}
		}
		matrizImpares = new int[matrizImparesTmp.size()][matrizImparesTmp.size()];
		for (int i = 0; i < matrizImparesTmp.size(); i++) {
			for (int j = 0; j < ((int[]) matrizImparesTmp.get(i)).length; j++) {
				matrizImpares[i][j] = ((int[]) matrizImparesTmp.get(i))[j];
			}
		}
		return matrizImpares;
	}
	
	
}
