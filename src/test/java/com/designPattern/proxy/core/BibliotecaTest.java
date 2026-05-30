package com.designPattern.proxy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

class BibliotecaTest {

    Biblioteca biblioteca;
    LivroRepository livroRepository;
    ILivro livroProxy;

    @BeforeEach
    void setUp() {
        livroRepository = Mockito.spy(LivroRepository.class);
        livroProxy = new LivroProxy(livroRepository);
        biblioteca = new Biblioteca("Juiz de Fora", livroProxy);
    }

    @Test
    void listarLivrosSemCache() {
        biblioteca.listarLivros();
        Mockito.verify(livroRepository, Mockito.times(1)).listarLivros();
    }

    @Test
    void listarLivrosUtilizandoCache() {
        //somente na primeira chamada o acesso ao repository é feito
        biblioteca.listarLivros();

        //estas chamadas utilizaram de cache
        biblioteca.listarLivros();
        biblioteca.listarLivros();
        biblioteca.listarLivros();

        Mockito.verify(livroRepository, Mockito.times(1)).listarLivros();
    }

    @Test
    void resumoLivroSemCache() {
        biblioteca.resumoLivro(1L);
        Mockito.verify(livroRepository, Mockito.times(1)).resumoLivro(anyLong());
    }

    @Test
    void resumoLivroUtilizandoCache() {
        biblioteca.resumoLivro(1L);

        biblioteca.resumoLivro(1L);
        biblioteca.resumoLivro(1L);

        Mockito.verify(livroRepository, Mockito.times(1)).resumoLivro(anyLong());
    }

    @Test
    void carregarLivroSemCache() {
        biblioteca.carregarLivro(1L);
        Mockito.verify(livroRepository, Mockito.times(1)).carregarLivro(anyLong());
    }

    @Test
    void carregarLivroUtilizandoCache() {
        biblioteca.carregarLivro(1L);

        biblioteca.carregarLivro(1L);
        biblioteca.carregarLivro(1L);
        Mockito.verify(livroRepository, Mockito.times(1)).carregarLivro(anyLong());
    }

    @Test
    void deveRetornarResumoDeUmLivro() {
        assertEquals("Livro{titulo='O Senhor dos Anéis', resumo='Resumo do livro de ID 1'}", biblioteca.resumoLivro(1L));
    }

    @Test
    void deveRetornarPDFDeUmLivro() {
        assertEquals("Livro{pdfLivro='Harry Potter e a Pedra Filosofal.pdf'}", biblioteca.carregarLivro(1L));
    }
}