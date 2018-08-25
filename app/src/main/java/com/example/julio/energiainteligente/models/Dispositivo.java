package com.example.julio.energiainteligente.models;

import com.example.julio.energiainteligente.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.modelResponse.CircuitoResponse;
import com.example.julio.energiainteligente.modelResponse.MedicaoResponse;
import com.example.julio.energiainteligente.modelResponse.ProgramacaoResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dispositivo implements Serializable {

    private Integer id;
    private String nome;
    private Boolean ligado;
    private List<Programacao> programacoes = new ArrayList<>();
    private List<Medicao> medicoes = new ArrayList<>();
    private ConfiguracaoDispositivo configuracaoDispositivo;

    public Dispositivo() {

    }

    public Dispositivo(CircuitoResponse circuitoResponse) {
        this.id = circuitoResponse.getId();
        this.nome = circuitoResponse.getNome();
        this.ligado = circuitoResponse.isLigado();
        this.programacoes = null;
        this.configuracaoDispositivo = new ConfiguracaoDispositivo(circuitoResponse.getConfiguracaoCircuito());

        List<Medicao> medicoes = new ArrayList<>();
        for (MedicaoResponse medicaoResponse : circuitoResponse.getMedicoes()) {
            medicoes.add(new Medicao(medicaoResponse));
        }
        this.medicoes = medicoes;
    }

    public Dispositivo(CircuitoDispositivoResponse circuitoResponse) {
        this.id = circuitoResponse.getId();
        this.nome = circuitoResponse.getNome();
        this.ligado = circuitoResponse.isLigado();
        this.medicoes = null;
        this.configuracaoDispositivo = new ConfiguracaoDispositivo(circuitoResponse.getConfiguracaoCircuito());

        List<Programacao> programacoes = new ArrayList<>();
        for (ProgramacaoResponse programacaoResponse : circuitoResponse.getProgramacoes()) {
            programacoes.add(new Programacao(programacaoResponse));
        }
        this.programacoes = programacoes;
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

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public List<Programacao> getProgramacoes() {
        return programacoes;
    }

    public void setProgramacoes(List<Programacao> programacoes) {
        this.programacoes = programacoes;
    }

    public void addProgramacao(Programacao programacao) {
        programacoes.add(programacao);
    }

    public List<Medicao> getMedicoes() {
        return medicoes;
    }

    public void setMedicoes(List<Medicao> medicoes) {
        this.medicoes = medicoes;
    }

    public ConfiguracaoDispositivo getConfiguracaoDispositivo() {
        return configuracaoDispositivo;
    }

    public void setConfiguracaoDispositivo(ConfiguracaoDispositivo configuracaoDispositivo) {
        this.configuracaoDispositivo = configuracaoDispositivo;
    }
}
