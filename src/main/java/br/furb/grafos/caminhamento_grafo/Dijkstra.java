package br.furb.grafos.caminhamento_grafo;

import java.util.List;

public final class Dijkstra implements Aplicar {
	
	public static long INFINITO = Long.MAX_VALUE;
	private Grafo grafo;
	
	private Vertice S;
	private Vertice v;
	private Vertice u;
	

	public Dijkstra(Grafo grafo) throws GrafoNulo {
		if (grafo == null) {
			throw new GrafoNulo();
		}
		this.grafo = grafo;
	}

	@Override
	public Grafo aplicar() {
		return null;
	}
	
	private int D(Vertice v) {
		return 0;
	}
	
	private int W(Vertice u, Vertice v) {
		return 0;
	}
	
	private Vertice predecessor(Vertice v) {
		
		return null;
	}
	
	/**
	 * Retorna o proximo vertice a ser processado
	 * @return Vertice
	 */
	private Vertice Q() {
		
		return null;
	}
	
	private List<Vertice> S() {
		
		return null;
	}
	
}
