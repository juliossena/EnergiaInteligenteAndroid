package com.example.julio.energiainteligente.modelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfiguracaoCircuitoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("ssid")
    @Expose
    private String ssid;

    @SerializedName("senhaSsid")
    @Expose
    private String senhaSsid;

    @SerializedName("tempoAtualizacao")
    @Expose
    private Integer tempoAtualizacao;

    @SerializedName("custoPorW")
    @Expose
    private Float custoPorW;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSenhaSsid() {
        return senhaSsid;
    }

    public void setSenhaSsid(String senhaSsid) {
        this.senhaSsid = senhaSsid;
    }

    public Integer getTempoAtualizacao() {
        return tempoAtualizacao;
    }

    public void setTempoAtualizacao(Integer tempoAtualizacao) {
        this.tempoAtualizacao = tempoAtualizacao;
    }

    public Float getCustoPorW() {
        return custoPorW;
    }

    public void setCustoPorW(Float custoPorW) {
        this.custoPorW = custoPorW;
    }
}
