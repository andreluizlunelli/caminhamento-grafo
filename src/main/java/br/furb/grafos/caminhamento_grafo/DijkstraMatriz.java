package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraMatriz {

	private static final int INFINITO = Integer.MAX_VALUE;
	private static final int NIL = -1;
	private int[] pai;
	private int[] distancia;
	private List<Integer> fila = new ArrayList<>();
	private int[][] matrizCusto;
	private int verticeOrigem;
	
	public DijkstraMatriz(int[][] matrizCusto, int verticeOrigem) {
		this.matrizCusto = matrizCusto;
		this.verticeOrigem = verticeOrigem;
		this.distancia = new int[matrizCusto.length];
		this.pai = new int[matrizCusto.length];
		inicializaVariaveis();
		processar();
	}

	public int getCustoMenorCaminho(int vertice) {
		return distancia[vertice];
	}
	
	public String getMenorCaminho(int vertice) {
		StringBuilder sb = new StringBuilder();
		sb.append((char) (vertice + 'A'));
		int paiAtual;
		while ((paiAtual = pai[vertice]) != NIL) {
			sb.insert(0, " -> ");
			sb.insert(0, (char) (paiAtual + 'A'));
			vertice = paiAtual;
		}
		return sb.toString();
	}
	
	private void processar() {
		while(!fila.isEmpty()) {
			int verticeAtual = getVerticeMenorCusto();
			for (int i = 0; i < matrizCusto.length; i++) {
				if (matrizCusto[verticeAtual][i] > 0) {
					relaxamento(verticeAtual, i);
				}
			}
		}
	}

	private void relaxamento(int verticeOrigem, int verticeDestino) {
		if (distancia[verticeDestino] > (distancia[verticeOrigem] + matrizCusto[verticeOrigem][verticeDestino])) {
			distancia[verticeDestino] = distancia[verticeOrigem] + matrizCusto[verticeOrigem][verticeDestino];
			pai[verticeDestino] = verticeOrigem;
		}
	}

	private void inicializaVariaveis() {
		Arrays.fill(distancia, INFINITO);
		Arrays.fill(pai, NIL);
		for (int i = 0; i < distancia.length; i++) {
			fila.add(i);
		}
		distancia[verticeOrigem] = 0;
	}
	
	private int getVerticeMenorCusto() {
		int verticeMenorCusto = -1;
		int indexMenorCusto = -1;
		for (int i = 0; i < fila.size(); i++) {
			if (verticeMenorCusto == -1 || distancia[fila.get(i)] < distancia[verticeMenorCusto]) {
				verticeMenorCusto = fila.get(i);
				indexMenorCusto = i;
			}
		}
		return fila.remove(indexMenorCusto);
	}

	public int getVerticeOrigem() {
		return verticeOrigem;
	}
		
}
