package com.example.julio.energiainteligente.modelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CircuitoDispositivoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("ligado")
    @Expose
    private boolean ligado;

    @SerializedName("configuracaoCircuito")
    @Expose
    private ConfiguracaoCircuitoResponse configuracaoCircuito;

    @SerializedName("programacoes")
    @Expose
    private List<ProgramacaoResponse> programacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public ConfiguracaoCircuitoResponse getConfiguracaoCircuito() {
        return configuracaoCircuito;
    }

    public void setConfiguracaoCircuito(ConfiguracaoCircuitoResponse configuracaoCircuito) {
        this.configuracaoCircuito = configuracaoCircuito;
    }

    public List<ProgramacaoResponse> getProgramacoes() {
        return programacoes;
    }

    public void setProgramacoes(List<ProgramacaoResponse> programacoes) {
        this.programacoes = programacoes;
    }
}
