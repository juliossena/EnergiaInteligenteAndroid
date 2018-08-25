package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.modelResponse.ConfiguracaoCircuitoResponse;

import java.io.Serializable;

public class ConfiguracaoDispositivo implements Serializable {

    private Integer id;
    private String ssid;
    private String senhaSsid;
    private Integer tempoAtualizacao;
    private Float custoPorW;

    public ConfiguracaoDispositivo() {

    }

    public ConfiguracaoDispositivo(ConfiguracaoCircuitoResponse configuracaoCircuitoResponse) {
        this.id = configuracaoCircuitoResponse.getId();
        this.ssid = configuracaoCircuitoResponse.getSsid();
        this.senhaSsid = configuracaoCircuitoResponse.getSenhaSsid();
        this.tempoAtualizacao = configuracaoCircuitoResponse.getTempoAtualizacao();
        this.custoPorW = configuracaoCircuitoResponse.getCustoPorW();
    }

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
