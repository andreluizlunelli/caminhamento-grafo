package br.furb.grafos.caminhamento_grafo;

import java.util.Arrays;

public class Fleury {

	private int[][] matrizAdjacencia;

	public String geraCicloEuleriano(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = Arrays.copyOf(matrizAdjacencia, matrizAdjacencia.length);
		int verticeAtual = 0;
		StringBuilder sb = new StringBuilder();
		
		int verticesImpares = getVerticesImpares();
		// Se tem dois vértices impares então é semi euleriano e precisa começar de um ímpar
		if (verticesImpares == 2) {
			verticeAtual = getVerticeImpar();
			sb.append("Ciclo semi-euleriano: ");
		} else if (verticesImpares == 0) {
			sb.append("Ciclo euleriano: ");
		} else {
			throw new RuntimeException("O grafo possui " + verticesImpares + " vértice(s) ímpar(es), não sendo euleriano");
		}
		
		sb.append(getFormatedString(verticeAtual));
		
		int verticeDestino;
		while ((verticeDestino = getProximaAdjacenciaValida(verticeAtual)) != -1) {
			removeAresta(verticeAtual, verticeDestino);
			verticeAtual = verticeDestino;
			sb.append(getFormatedString(verticeAtual));
		}

		if (temVerticePendente()) {
			throw new RuntimeException("Não foram processados todos os vertices, provavelmente o grafo é desconexo");
		}

		return sb.toString().substring(0, sb.length() - 4);
	}

	private int getVerticeImpar() {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			int arestasVertice = 0;
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] > 0) {
					arestasVertice += matrizAdjacencia[i][j];
				}
			}
			if (arestasVertice % 2 == 1) {
				return i;
			}
		}
		return -1;
	}

	private int getVerticesImpares() {
		int verticesImpares = 0;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			int arestasVertice = 0;
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] > 0) {
					arestasVertice += matrizAdjacencia[i][j];
				}
			}
			if (arestasVertice % 2 == 1) {
				verticesImpares++;
			}
		}
		return verticesImpares;
	}

	private String getFormatedString(int vertice) {
		return String.format("%s -> ", getVerticeAsString(vertice));
	}

	private String getVerticeAsString(int vertice) {
		return Character.toString((char) ('A' + vertice));
	}

	private boolean temVerticePendente() {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			if (getProximaAdjacenciaValida(i) != -1) {
				return true;
			}
		}
		return false;
	}

	private boolean isPonte(int verticeOrigem, int verticeDestino) {
		if (getQuantidadeArestas(verticeOrigem) <= 1) {
			return false;
		}

		boolean[] visitado = new boolean[matrizAdjacencia.length];
		removeAresta(verticeOrigem, verticeDestino);
		DFS(visitado, verticeDestino); // Verifica se ficou desconexo
		criaAresta(verticeOrigem, verticeDestino);
		return !visitado[verticeOrigem];
	}

	private void criaAresta(int verticeOrigem, int verticeDestino) {
		matrizAdjacencia[verticeOrigem][verticeDestino]++;
		matrizAdjacencia[verticeDestino][verticeOrigem]++;
	}

	private void removeAresta(int verticeOrigem, int verticeDestino) {
		matrizAdjacencia[verticeOrigem][verticeDestino]--;
		matrizAdjacencia[verticeDestino][verticeOrigem]--;
	}

	private int getProximaAdjacenciaValida(int vertice) {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			if (matrizAdjacencia[vertice][i] > 0 && !isPonte(vertice, i)) {
				return i;
			}
		}
		return -1;
	}

	private int getQuantidadeArestas(int vertice) {
		int quantidadeArestas = 0;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			if (matrizAdjacencia[vertice][i] > 0) {
				quantidadeArestas++;
			}
		}
		return quantidadeArestas;
	}

	private void DFS(boolean[] visitados, int vertice) {
		visitados[vertice] = true;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			if (matrizAdjacencia[vertice][i] > 0 && !visitados[i]) {
				DFS(visitados, i);
			}
		}
	}
}
