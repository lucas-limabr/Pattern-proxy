package com.designPattern.proxy.core;

import java.util.List;

public interface ILivro {
    List<Livro> listarLivros();
    String resumoLivro(Long id);
    String carregarLivro(Long id, Usuario usuario);
}
