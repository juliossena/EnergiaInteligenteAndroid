package com.example.julio.energiainteligente.models.modelRequest;

import com.example.julio.energiainteligente.models.enuns.TipoEstado;
import com.example.julio.energiainteligente.models.enuns.TipoProgramacao;

import java.util.Date;
import java.util.List;

public class ProgramacaoMudancaRequest {

    private Integer tipoProgramacao;
    private String nome;
    private String type;
    private boolean repetir;
    private Integer tipoEstado;
    private Date horario;
    private Integer raio;
    private List<ProgramacaoMudancaRepetirRequest> repeticoes;
    private boolean ligado;

    public ProgramacaoMudancaRequest() {

    }

    public ProgramacaoMudancaRequest(TipoProgramacao tipoProgramacao, String nome, String type,
                                     boolean repetir, TipoEstado tipoEstado, Date horario,
                                     Integer raio, List<ProgramacaoMudancaRepetirRequest> repeticoes,
                                     boolean ligado) {
        this.tipoProgramacao = tipoProgramacao.getCod();
        this.nome = nome;
        this.type = type;
        this.repetir = repetir;
        this.tipoEstado = tipoEstado.getCod();
        this.horario = horario;
        this.raio = raio;
        this.repeticoes = repeticoes;
        this.ligado = ligado;
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

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    public Integer getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado.getCod();
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
    }

    public List<ProgramacaoMudancaRepetirRequest> getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(List<ProgramacaoMudancaRepetirRequest> repeticoes) {
        this.repeticoes = repeticoes;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
}
