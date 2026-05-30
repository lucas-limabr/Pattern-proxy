package com.designPattern.proxy.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class BDLivros {

    private Map<Long, Livro> livros;
    private final LocalDate data = LocalDate.of(2026, 5, 30);

    public BDLivros() {
        livros = Map.of(
                1L, new Livro(1L, "O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", data, "Resumo do livro de ID 1", "Harry Potter e a Pedra Filosofal.pdf"),
                3L, new Livro(3L, "O Código Da Vinci", "Dan Brown", "Sextante", data, "Resumo do livro de ID 2", "O Código Da Vinci.pdf"),
                4L, new Livro(4L, "A Menina que Roubava Livros", "Markus Zusak", "Intrínseca", data, "Resumo do livro de ID 3", "A Menina que Roubava Livros.pdf"),
                5L, new Livro(5L, "O Alquimista", "Paulo Coelho", "Rocco", data, "Resumo do livro de ID 4", "O Alquimista.pdf")
        );
    }

    public List<Livro> getLivros() {
        return livros.values().stream().toList();
    }

    public String getResumoLivro(Long id) {
        return livros.get(id).resumo();
    }

    public String carregarLivro(Long id) {
        return livros.get(id).pdfLivro();
    }
}
