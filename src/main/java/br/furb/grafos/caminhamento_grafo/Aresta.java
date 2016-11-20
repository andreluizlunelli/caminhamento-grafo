package br.furb.grafos.caminhamento_grafo;

public class Aresta {

    private String rotulo;
    private Vertice ponta1;
    private Vertice ponta2;
    private int custo;
    
    public Aresta(String rotulo, Vertice ponta1, Vertice v2, int custo) {
        this.rotulo = rotulo;
        this.ponta1 = ponta1;
        this.ponta2 = v2;
        this.custo = custo;
    }

    public Aresta(String rotulo, Vertice ponta1, Vertice v2) {
        this.rotulo = rotulo;
        this.ponta1 = ponta1;
        this.ponta2 = v2;
    }

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public Vertice getPonta1() {
		return ponta1;
	}

	public void setPonta1(Vertice ponta1) {
		this.ponta1 = ponta1;
	}

	public Vertice getPonta2() {
		return ponta2;
	}

	public void setPonta2(Vertice ponta2) {
		this.ponta2 = ponta2;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

}