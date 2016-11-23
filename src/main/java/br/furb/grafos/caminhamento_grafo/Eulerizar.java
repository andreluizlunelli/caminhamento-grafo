package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;
import java.util.List;

import br.furb.grafos.caminhamento_grafo.Eulerizar.ParDeVertices;

public final class Eulerizar implements Aplicar {

	private Grafo grafo;

	public Eulerizar(Grafo grafo) throws GrafoNulo {
		if (grafo == null) {
			throw new GrafoNulo();
		}
		this.grafo = grafo.clone();
	}

	public Grafo getGrafo() {
		return grafo;
	}

	@Override
	public Grafo aplicar() {		
		List<Vertice> verticesImpares = obterVerticesImpares();
		List<DijkstraMatriz> dijkstraMatrizs = new ArrayList<>();
		for (Vertice v : verticesImpares) 
			dijkstraMatrizs.add(new DijkstraMatriz(this.grafo.getMatrizAdjacencia(), v.getIndiceMatriz()));		
		ParDeVertices[] combinacaoVertices = combinacaoVertices(dijkstraMatrizs);
		for (int i = 0; i < combinacaoVertices.length; i++) {
			ParDeVertices parDeVertices = combinacaoVertices[i];
			Aresta aresta = getArestaPDuplicar(parDeVertices);
			grafo.addAresta(aresta);
		}		
		return grafo;
	}
	
	private Aresta getArestaPDuplicar(ParDeVertices vertices) {
		Vertice ponta1 = grafo.getVerticeByIndex(vertices.v1);
		Vertice ponta2 = grafo.getVerticeByIndex(vertices.v2);
		Aresta aresta = new Aresta(String.format("e_%sd%s", vertices.v1, vertices.v2), ponta1, ponta2);
		return aresta;
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
