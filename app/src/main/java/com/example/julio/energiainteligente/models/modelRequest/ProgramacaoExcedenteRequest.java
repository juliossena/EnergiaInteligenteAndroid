package com.example.julio.energiainteligente.models.modelRequest;

import com.example.julio.energiainteligente.models.enuns.TipoEstado;
import com.example.julio.energiainteligente.models.enuns.TipoExcedente;
import com.example.julio.energiainteligente.models.enuns.TipoProgramacao;

import java.util.Date;
import java.util.List;

public class ProgramacaoExcedenteRequest {

    private Integer tipoProgramacao;
    private String nome;
    private String type;
    private Integer tipoExcedente;
    private float potencia;

    public ProgramacaoExcedenteRequest() {

    }

    public ProgramacaoExcedenteRequest(TipoProgramacao tipoProgramacao, String nome, String type, Integer tipoExcedente, float potencia) {
        this.tipoProgramacao = tipoProgramacao.getCod();
        this.nome = nome;
        this.type = type;
        this.tipoExcedente = tipoExcedente;
        this.potencia = potencia;
    }

    public Integer getTipoProgramacao() {
        return tipoProgramacao;
    }

    public void setTipoProgramacao(TipoProgramacao tipoProgramacao) {
        this.tipoProgramacao = tipoProgramacao.getCod();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTipoExcedente() {
        return tipoExcedente;
    }

    public void setTipoExcedente(TipoExcedente tipoExcedente) {
        this.tipoExcedente = tipoExcedente.getCod();
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
}
