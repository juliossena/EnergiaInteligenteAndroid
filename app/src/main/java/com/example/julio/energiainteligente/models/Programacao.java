package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.models.modelResponse.ProgramacaoResponse;

import java.io.Serializable;

public class Programacao implements Serializable{

    private String nome;

    public Programacao() {

    }

    public Programacao(ProgramacaoResponse programacaoResponse) {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
