package com.designPattern.proxy.core;

import java.util.List;

public class LivroRepository implements ILivro {
    private final BDLivros bdLivros;

    public LivroRepository() {
        this.bdLivros = new BDLivros();
    }

    @Override
    public List<Livro> listarLivros() {
        return bdLivros.getLivros();
    }

    @Override
    public String resumoLivro(Long id) {
        return bdLivros.getResumoLivro(id);
    }

    @Override
    public String carregarLivro(Long id) {
        return bdLivros.carregarLivro(id);
    }


}
