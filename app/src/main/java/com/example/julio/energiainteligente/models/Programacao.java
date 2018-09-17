package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.models.enuns.TipoEstado;
import com.example.julio.energiainteligente.models.enuns.TipoProgramacao;
import com.example.julio.energiainteligente.models.enuns.TipoType;
import com.example.julio.energiainteligente.models.modelResponse.ProgramacaoResponse;

import java.io.Serializable;
import java.util.Date;

public class Programacao implements Serializable{

    private Integer id;
    private Integer type;
    private Integer tipoProgramacao;
    private String nome;
    private boolean ligado;
    private Date ultimaRequisicao;
    private boolean repetir;
    private Integer tipoEstado;
    private Date horario;
    private Integer raio;

    public Programacao() {

    }

    public Programacao(ProgramacaoResponse programacaoResponse) {
        this.id = programacaoResponse.getId();
        this.type = TipoType.toEnum(programacaoResponse.getType()).getCod();
        this.tipoProgramacao = TipoProgramacao.toEnum(programacaoResponse.getTipoProgramacao()).getCod();
        this.nome = programacaoResponse.getNome();
        this.ligado = programacaoResponse.isLigado();
        this.ultimaRequisicao = programacaoResponse.getUltimaRequisicao() != null ?
                new Date(programacaoResponse.getUltimaRequisicao()) : null;
        this.repetir = programacaoResponse.isRepetir();
        this.tipoEstado = programacaoResponse.getTipoEstado() != null ? TipoEstado.toEnum(programacaoResponse.getTipoEstado()).getCod() :
                null;
        this.horario = programacaoResponse.getHorario() != null ? new Date(programacaoResponse.getHorario()) : null;
        this.raio = programacaoResponse.getRaio();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoType getType() {
        return TipoType.toEnum(type);
    }

    public void setType(TipoType type) {
        this.type = type.getCod();
    }

    public Integer getTipoProgramacao() {
        return tipoProgramacao;
    }

    public void setTipoProgramacao(Integer tipoProgramacao) {
        this.tipoProgramacao = tipoProgramacao;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public Date getUltimaRequisicao() {
        return ultimaRequisicao;
    }

    public void setUltimaRequisicao(Date ultimaRequisicao) {
        this.ultimaRequisicao = ultimaRequisicao;
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

    public void setTipoEstado(Integer tipoEstado) {
        this.tipoEstado = tipoEstado;
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
}
