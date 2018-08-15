package com.example.julio.energiainteligente.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Dispositivo implements Serializable{
    private Integer id;
    private String nome;
    private Boolean ligado;
    private ArrayList<Programacao> programacoes = new ArrayList<>();

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

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public ArrayList<Programacao> getProgramacoes() {
        return programacoes;
    }

    public void setProgramacoes(ArrayList<Programacao> programacoes) {
        this.programacoes = programacoes;
    }

    public void addProgramacao(Programacao programacao) {
        programacoes.add(programacao);
    }
}
