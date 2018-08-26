package com.example.julio.energiainteligente.models.modelRequest;

import com.example.julio.energiainteligente.models.Dispositivo;

public class CircuitoRequest {

    private Integer id;
    private String nome;
    private boolean ligado;

    public CircuitoRequest() {

    }

    public CircuitoRequest(Integer id, String nome, boolean ligado) {
        this.id = id;
        this.nome = nome;
        this.ligado = ligado;
    }

    public CircuitoRequest(Dispositivo dispositivo) {
        this.id = dispositivo.getId();
        this.nome = dispositivo.getNome();
        this.ligado = dispositivo.getLigado();
    }

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
}
