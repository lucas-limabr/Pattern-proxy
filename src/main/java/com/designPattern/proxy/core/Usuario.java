package com.designPattern.proxy.core;

public class Usuario {
    private String nome;
    private boolean isAssinante;

    public Usuario(String nome, boolean isAssinante) {
        this.nome = nome;
        this.isAssinante = isAssinante;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAssinante() {
        return isAssinante;
    }
}
