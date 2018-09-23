package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.models.modelResponse.HistoricoResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Historico {

    private float consumoTotal;
    private float mediaConsumo;
    private Date horarioPico;
    private float consumoPico;
    private float consumoReais;

    public Historico() {

    }

    public Historico(float consumoTotal, float mediaConsumo, Date horarioPico, float consumoPico, float consumoReais) {
        this.consumoTotal = consumoTotal;
        this.mediaConsumo = mediaConsumo;
        this.horarioPico = horarioPico;
        this.consumoPico = consumoPico;
        this.consumoReais = consumoReais;
    }

    public Historico(HistoricoResponse historicoResponse) {
        this.consumoTotal = historicoResponse.getConsumoTotal();
        this.mediaConsumo = historicoResponse.getMediaConsumo();
        this.horarioPico = historicoResponse.getHorarioPico() != null ? new Date(historicoResponse.getHorarioPico()) : null;
        this.consumoPico = historicoResponse.getConsumoPico();
        this.consumoReais = historicoResponse.getConsumoReais();
    }

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

    public Date getHorarioPico() {
        return horarioPico;
    }

    public void setHorarioPico(Date horarioPico) {
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
