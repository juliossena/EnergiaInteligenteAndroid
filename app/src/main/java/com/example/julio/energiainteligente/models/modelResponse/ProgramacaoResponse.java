package com.example.julio.energiainteligente.models.modelResponse;


public class ProgramacaoResponse {

    private Integer id;
    private String type;
    private String tipoProgramacao;
    private String nome;
    private boolean ligado;
    private Long ultimaRequisicao;
    private boolean repetir;
    private String tipoEstado;
    private Long horario;
    private Integer raio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTipoProgramacao() {
        return tipoProgramacao;
    }

    public void setTipoProgramacao(String tipoProgramacao) {
        this.tipoProgramacao = tipoProgramacao;
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

    public Long getUltimaRequisicao() {
        return ultimaRequisicao;
    }

    public void setUltimaRequisicao(Long ultimaRequisicao) {
        this.ultimaRequisicao = ultimaRequisicao;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public Long getHorario() {
        return horario;
    }

    public void setHorario(Long horario) {
        this.horario = horario;
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
    }
}
