package com.designPattern.proxy;

import com.designPattern.proxy.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);

        ILivro livro = new LivroProxy(new LivroRepository());
        Biblioteca biblioteca = new Biblioteca("Juiz de Fora",
                livro);

        List<Livro> livros = biblioteca.listarLivros();

        for(Livro item : livros)
        {
            System.out.println(item.infoLivro());
        }
	}
}
