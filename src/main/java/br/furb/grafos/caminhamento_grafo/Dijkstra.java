package br.furb.grafos.caminhamento_grafo;

import java.util.List;

public final class Dijkstra implements Aplicar {
	
	public static long INFINITO = Long.MAX_VALUE;
	private Grafo grafoOriginal;
	private Grafo g;
	
	private Vertice S;
	private Vertice v;
	private Vertice u;
	

	public Dijkstra(Grafo grafo) throws GrafoNulo {
		if (grafo == null) {
			throw new GrafoNulo();
		}
		this.grafoOriginal = grafo;
		this.g = grafo.clone();
	}

	@Override
	public Grafo aplicar() {	
		for (Vertice v : g.getVertices()) {
			List<Vertice> vlist = v.getAdjacentes();
			for (Vertice vaux : vlist) {
				
			}
			
		}
		
		return null;
	}
	
	private Aresta getAresta(Vertice ponto1, Vertice ponto2) {
		for (Aresta a : g.getArestas()) {
//			if (a.getPonta1() == ) {
//				
//			}
		}
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
