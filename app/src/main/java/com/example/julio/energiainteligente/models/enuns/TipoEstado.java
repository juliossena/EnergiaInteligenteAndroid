package com.example.julio.energiainteligente.models.enuns;

public enum TipoEstado {

	DESLIGADO(0, "Desligado"), 
	LIGADO(1, "Ligado"),
	LIGADO_DESLIGADO(2, "Ligado e desligado");

	private int cod;
	private String descricao;

	private TipoEstado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoEstado toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoEstado x : TipoEstado.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	public static TipoEstado toEnum(String mensagem) {
		if (mensagem == null || mensagem == "") {
			return null;
		}

		for (TipoEstado x : TipoEstado.values()) {
			if (mensagem.equals(x.name())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + mensagem);
	}
}
