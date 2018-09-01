package com.example.julio.energiainteligente.models.enuns;

public enum TipoType {

	PROGRAMACAO_EXCEDENTE(0, "programacaoExcedente"),
	PROGRAMACAO_ESTADO(1, "programacaoEstado"),
	PROGRAMACAO_MUDANCA(2, "programacaoMudanca");

	private int cod;
	private String descricao;

	private TipoType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoType x : TipoType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	public static TipoType toEnum(String mensagem) {
		if (mensagem == null || mensagem == "") {
			return null;
		}

		for (TipoType x : TipoType.values()) {
			if (mensagem.equals(x.getDescricao())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + mensagem);
	}
}
