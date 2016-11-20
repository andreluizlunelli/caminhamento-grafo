package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;
import java.util.List;

public final class Eulerizar implements Aplicar {

	private Grafo grafo;

	public Eulerizar(Grafo grafo) throws GrafoNulo {
		if (grafo == null) {
			throw new GrafoNulo();
		}
		this.grafo = grafo;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	@Override
	public Grafo aplicar() {
		List<Vertice> obterVerticesImpares = obterVerticesImpares();
		

		return null;
	}

	public List<Vertice> obterVerticesImpares() {
		List<Vertice> impares = new ArrayList<>();
		for (Vertice v : this.grafo.getVertices())
			if (v.grau() % 2 != 0)
				impares.add(v);
		return impares;
	}

}
