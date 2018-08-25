package com.example.julio.energiainteligente.util;


public class Constants {


    public static class Cache {
        public static String passarDispositivo = "passar_dispositivo";
        public static String passarProgramacao = "passar_programacao";
        public static String nomeSalvarAplicativo = "energiaIngeligente";
        public static String salvarAplicativoEmail = "salvarAplicativoEmail";
        public static String salvarAplicativoSenha = "salvarAplicativoSenha";
    }

    public static class Alert {
        public static String atencao = "ATENÇÃO!";
        public static String preencherCampos = "Preencha todos os campos";
        public static String novaProgramacao = "Nova Programação";
        public static String usuarioSenhaInvalido = "Usuário ou senha inválidos";
        public static String falhaInternet = "Não foi possível fazer a conexão, confira seu acesso à internet e tente novamente mais tarde";
    }

    public static class Session {
        public static String tokenAcesso = "";
        public static String senhaAcesso = "";
        public static String emailAcesso = "";
        public static String tokenFirebase = "";
    }

    public static class Build {
        public static String endPoint = "https://energia-inteligente.herokuapp.com/";
    }
}
