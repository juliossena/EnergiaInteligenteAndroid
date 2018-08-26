package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.models.modelResponse.MedicaoResponse;

import java.util.Date;

public class Medicao {

    private Integer id;
    private Float tensao;
    private Float corrente;
    private Float potencia;
    private Date horario;
    private Double consumido;

    public Medicao() {

    }

    public Medicao(MedicaoResponse medicaoResponse) {
        this.id = medicaoResponse.getId();
        this.tensao = medicaoResponse.getTensao();
        this.corrente = medicaoResponse.getCorrente();
        this.potencia = medicaoResponse.getPotencia();
        this.horario = new Date(medicaoResponse.getHorario());
        this.consumido = medicaoResponse.getConsumido();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTensao() {
        return tensao;
    }

    public void setTensao(Float tensao) {
        this.tensao = tensao;
    }

    public Float getCorrente() {
        return corrente;
    }

    public void setCorrente(Float corrente) {
        this.corrente = corrente;
    }

    public Float getPotencia() {
        return potencia;
    }

    public void setPotencia(Float potencia) {
        this.potencia = potencia;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Long Date) {
        this.horario = horario;
    }

    public Double getConsumido() {
        return consumido;
    }

    public void setConsumido(Double consumido) {
        this.consumido = consumido;
    }
}
