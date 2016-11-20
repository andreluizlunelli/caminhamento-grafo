package br.furb.grafos.caminhamento_grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Grafo {

	private static final String[] TIPO_ROTULOS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private int[][] matrizAdjacencia;
	private List<Vertice> vertices = new ArrayList<>();
	private List<Aresta> arestas = new ArrayList<>();

	public Grafo(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			Vertice v = new Vertice(TIPO_ROTULOS[i]);
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

	// ====================================== main
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
	// ======================================

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

}
