package com.example.julio.energiainteligente.models.modelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoricoResponse {

    @SerializedName("consumoTotal")
    @Expose
    private float consumoTotal;

    @SerializedName("mediaConsumo")
    @Expose
    private float mediaConsumo;

    @SerializedName("horarioPico")
    @Expose
    private Long horarioPico;

    @SerializedName("consumoPico")
    @Expose
    private float consumoPico;

    @SerializedName("consumoReais")
    @Expose
    private float consumoReais;

    public float getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(float consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public float getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(float mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    public Long getHorarioPico() {
        return horarioPico;
    }

    public void setHorarioPico(Long horarioPico) {
        this.horarioPico = horarioPico;
    }

    public float getConsumoPico() {
        return consumoPico;
    }

    public void setConsumoPico(float consumoPico) {
        this.consumoPico = consumoPico;
    }

    public float getConsumoReais() {
        return consumoReais;
    }

    public void setConsumoReais(float consumoReais) {
        this.consumoReais = consumoReais;
    }
}
