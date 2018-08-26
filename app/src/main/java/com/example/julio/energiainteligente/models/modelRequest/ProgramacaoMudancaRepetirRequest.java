package com.example.julio.energiainteligente.models.modelRequest;

import com.example.julio.energiainteligente.models.enuns.DiaSemana;

public class ProgramacaoMudancaRepetirRequest {

    private Integer diaRepetir;

    public ProgramacaoMudancaRepetirRequest() {

    }

    public ProgramacaoMudancaRepetirRequest(DiaSemana diaRepetir) {
        this.diaRepetir = diaRepetir.getCod();
    }

    public Integer getDiaRepetir() {
        return diaRepetir;
    }

    public void setDiaRepetir(DiaSemana diaRepetir) {
        this.diaRepetir = diaRepetir.getCod();
    }
}
