package com.designPattern.proxy.core;

import java.util.List;

public class Biblioteca {

    private ILivro livro;
    private String campus;

    public Biblioteca(String campus, ILivro livro) {
        this.campus = campus;
        this.livro = livro;
    }

    public List<Livro> listarLivros() {
        return livro.listarLivros();
    }

    public String resumoLivro(Long id) {
        return livro.resumoLivro(id);
    }

    public String carregarLivro(Long id) {
        return livro.carregarLivro(id);
    }
}
