package com.example.julio.energiainteligente.modelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CircuitoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("ligado")
    @Expose
    private boolean ligado;

    @SerializedName("medicoes")
    @Expose
    private ArrayList<MedicaoResponse> medicoes;

    @SerializedName("historicoResponse")
    @Expose
    private HistoricoResponse historicoResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ArrayList<MedicaoResponse> getMedicoes() {
        return medicoes;
    }

    public void setMedicoes(ArrayList<MedicaoResponse> medicoes) {
        this.medicoes = medicoes;
    }

    public HistoricoResponse getHistoricoResponse() {
        return historicoResponse;
    }

    public void setHistoricoResponse(HistoricoResponse historicoResponse) {
        this.historicoResponse = historicoResponse;
    }
}
