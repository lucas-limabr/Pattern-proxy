package com.designPattern.proxy.core;

import java.time.LocalDate;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private LocalDate dataPublicacao;
    private String resumo;
    private String pdfLivro;

    public Livro(Long id, String titulo, String autor, String editora, LocalDate dataPublicacao, String resumo, String pdfLivro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.resumo = resumo;
        this.pdfLivro = pdfLivro;
    }

    public String infoLivro() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    public String resumo() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                '}';
    }

    public String pdfLivro() {
        return "Livro{" +
                "pdfLivro='" + pdfLivro + '\'' +
                '}';
    }
}
