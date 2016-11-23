package br.furb.grafos.caminhamento_grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grafo implements Cloneable {

	private static final String[] TIPO_ROTULOS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private int[][] matrizAdjacencia;
	private List<Vertice> vertices = new ArrayList<>();
	private List<Aresta> arestas = new ArrayList<>();

	public Grafo(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			Vertice v = new Vertice(TIPO_ROTULOS[i], i);
			vertices.add(v);
		}
		int i = 0;
		for (Vertice v : vertices) {
			ArrayList<Vertice> adjacentes = new ArrayList<>();
			for (int j = 0; j < matrizAdjacencia[i].length; j++) {
				if (matrizAdjacencia[i][j] > 0) {
					Vertice verticeAdjacente;
					try {
						verticeAdjacente = this.getVertice(TIPO_ROTULOS[j]);
						adjacentes.add(verticeAdjacente);
						if (!temAresta(v, verticeAdjacente)) 
							arestas.add(new Aresta("e_" + arestas.size() + 1, v, verticeAdjacente, matrizAdjacencia[i][j]));
					} catch (VerticeNaoAchado e) {
						e.printStackTrace();
					}
				}
			}
			v.setAdjacentes(adjacentes);
			i++;
		}
	}

	public Grafo(Grafo grafo) {
		this.matrizAdjacencia = grafo.matrizAdjacencia;
		this.vertices = grafo.vertices;
		this.arestas = grafo.arestas;
	}

	public Grafo eulerizar() {
		Grafo eulerizado = null;
		try {
			eulerizado = new Eulerizar(this).aplicar();
		} catch (GrafoNulo e) {
			e.printStackTrace();
		}
		return eulerizado;
	}

	public int[][] getMatrizAdjacencia() {
		return this.matrizAdjacencia;
	}

	public Vertice getVertice(String rotulo) throws VerticeNaoAchado {
		for (Vertice v : this.vertices) {
			if (v.getRotulo().equalsIgnoreCase(rotulo)) {
				return v;
			}
		}
		throw new VerticeNaoAchado();
	}

	private boolean temAresta(Vertice v1, Vertice v2) {
		for (Aresta a : arestas) {
			if ((a.getPonta1().getRotulo().equals(v1.getRotulo()) && a.getPonta2().getRotulo().equals(v2.getRotulo()))
					|| (a.getPonta1().getRotulo().equals(v2.getRotulo())
							&& a.getPonta2().getRotulo().equals(v1.getRotulo()))) {
				return true;
			}
		}
		return false;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public Grafo clone() {
		return new Grafo(this);
	}

}
