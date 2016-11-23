package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;

public class Vertice {
	private int indiceMatriz;
	private String rotulo;
	private ArrayList<Vertice> adjacentes = new ArrayList<>();
	
	public Vertice(String rotulo, int indiceMatriz) {
		this.rotulo = rotulo;
		this.setIndiceMatriz(indiceMatriz);
	}
	
	public Vertice(String rotulo, int indiceMatriz, ArrayList<Vertice> adjacentes) {
		this.rotulo = rotulo;
		this.setIndiceMatriz(indiceMatriz);
		this.adjacentes = adjacentes;
	}
	
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public ArrayList<Vertice> getAdjacentes() {
		return adjacentes;
	}
	public void setAdjacentes(ArrayList<Vertice> adjacentes) {
		this.adjacentes = adjacentes;
	}
	public int grau() {
		return adjacentes.size();
	}
	public int getIndiceMatriz() {
		return indiceMatriz;
	}
	public void setIndiceMatriz(int indiceMatriz) {
		this.indiceMatriz = indiceMatriz;
	}
	
}
