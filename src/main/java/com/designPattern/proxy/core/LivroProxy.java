package com.designPattern.proxy.core;

import java.util.ArrayList;
import java.util.List;

public class LivroProxy implements ILivro {

    //cache de diferentes dados sobre Livro
    private List<Livro> listaLivros = new ArrayList<>();
    private String resumoLivro;
    private String pdfLivro;
    private LivroRepository livroRepository;

    public LivroProxy(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public List<Livro> listarLivros() {
        if (this.listaLivros.isEmpty()) {
            listaLivros = this.livroRepository.listarLivros();
        }

        return listaLivros;
    }

    @Override
    public String resumoLivro(Long id) {
        if (this.resumoLivro == null) {
            this.resumoLivro = this.livroRepository.resumoLivro(id);
        }
        return resumoLivro;
    }

    @Override
    public String carregarLivro(Long id) {
        if (this.pdfLivro == null) {
            this.pdfLivro = this.livroRepository.carregarLivro(id);
        }
        return pdfLivro;
    }
}
