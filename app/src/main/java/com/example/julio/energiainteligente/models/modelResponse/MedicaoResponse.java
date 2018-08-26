package com.example.julio.energiainteligente.models.modelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicaoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("tensao")
    @Expose
    private Float tensao;

    @SerializedName("corrente")
    @Expose
    private Float corrente;

    @SerializedName("potencia")
    @Expose
    private Float potencia;

    @SerializedName("horario")
    @Expose
    private Long horario;

    @SerializedName("consumido")
    @Expose
    private Double consumido;

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

    public Long getHorario() {
        return horario;
    }

    public void setHorario(Long horario) {
        this.horario = horario;
    }

    public Double getConsumido() {
        return consumido;
    }

    public void setConsumido(Double consumido) {
        this.consumido = consumido;
    }
}
