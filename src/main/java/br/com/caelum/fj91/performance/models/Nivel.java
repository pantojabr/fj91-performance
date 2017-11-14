package br.com.caelum.fj91.performance.models;

public enum Nivel {
	
	BASICO("Básico"),
	INTERMEDIARIO("Intermediário"),
	AVANCADO("Avançado");
	
	private final String descricao;

	private Nivel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
