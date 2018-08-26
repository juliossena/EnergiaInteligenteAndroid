package com.example.julio.energiainteligente.models.modelRequest;

public class LoginRequest {

    private String email;
    private String senha;
    private String idCelular;

    public LoginRequest() {

    }

    public LoginRequest(String email, String senha, String idCelular) {
        this.email = email;
        this.senha = senha;
        this.idCelular = idCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(String idCelular) {
        this.idCelular = idCelular;
    }
}
