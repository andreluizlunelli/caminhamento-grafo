package br.furb.grafos.caminhamento_grafo;

import java.util.ArrayList;

public class Vertice {
	private String rotulo;
	private ArrayList<Vertice> adjacentes = new ArrayList<>();
	
	public Vertice(String rotulo) {
		this.rotulo = rotulo;
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
	
}
