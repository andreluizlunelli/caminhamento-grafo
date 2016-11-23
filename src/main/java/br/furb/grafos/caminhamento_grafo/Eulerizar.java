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
		List<Vertice> verticesImpares = obterVerticesImpares();
		List<DijkstraMatriz> dijkstraMatrizs = new ArrayList<>();
		for (Vertice v : verticesImpares) {
			dijkstraMatrizs.add(new DijkstraMatriz(this.grafo.getMatrizAdjacencia(), v.getIndiceMatriz()));
		}
		combinacaoVertices(dijkstraMatrizs);
		return null;
	}

	private List<Vertice> obterVerticesImpares() {
		List<Vertice> impares = new ArrayList<>();
		for (Vertice v : this.grafo.getVertices())
			if (v.grau() % 2 != 0)
				impares.add(v);
		return impares;
	}
	
	
	class ParDeVertices {
		public int v1;
		public int v2;
		public int custo;
	}
	
	class ParDeVerticesEscolhido {
		public ParDeVertices pv1;
		public ParDeVertices pv2;
	}
	
	
	private ParDeVertices[] combinacaoVertices(List<DijkstraMatriz> dijkstraMatrizs) {
		int size = dijkstraMatrizs.size();
		ParDeVertices[] combinacoes = new ParDeVertices[size-1];
		for (int i = 0; i < size-1; i++) {
			int auxCusto = Integer.MAX_VALUE;
			int vAux= 0;
			int aux = 0;
			DijkstraMatriz dAux = dijkstraMatrizs.get(i);
			for (int j = i + 1; j < size; j++) {
				aux = dijkstraMatrizs.get(j).getVerticeOrigem();
				if (auxCusto > dAux.getCustoMenorCaminho(aux)) {
					auxCusto = dAux.getCustoMenorCaminho(aux);
					vAux = aux;
				}
			}
			ParDeVertices parVertices = new ParDeVertices();
			parVertices.custo = auxCusto;
			parVertices.v1 = dAux.getVerticeOrigem();
			parVertices.v2 = vAux;
			combinacoes[i] = parVertices;
		}
		ParDeVertices[] parVerticeCustoAux = new ParDeVertices[2];
		int custoAux = Integer.MAX_VALUE;
		for (int i = 0; i < combinacoes.length-1; i++) {
			ParDeVertices auxParDeVertices1 = combinacoes[i];
			for (int j = i + 1; j < combinacoes.length; j++) {
				ParDeVertices auxParDeVertices2 = combinacoes[j];
				if (auxParDeVertices1.v1 == auxParDeVertices2.v1 
						|| auxParDeVertices1.v2 == auxParDeVertices2.v2 
						|| auxParDeVertices1.v1 == auxParDeVertices2.v2
						|| auxParDeVertices1.v2 == auxParDeVertices2.v1)
					continue;
				if (custoAux > (auxParDeVertices1.custo + auxParDeVertices2.custo)) {
					custoAux = (auxParDeVertices1.custo + auxParDeVertices2.custo);
					parVerticeCustoAux[0] = auxParDeVertices1; 
					parVerticeCustoAux[1] = auxParDeVertices2; 
				}
			}
		}
		return parVerticeCustoAux;
	}

	
}
