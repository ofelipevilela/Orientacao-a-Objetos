package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoLivroTest {

    @Test
    void deveCalcularPrecoComDesconto() {
        ProdutoLivro livro = new ProdutoLivro("Livro de Programação", 150);
        assertEquals(142.5, livro.calcularPreco());
    }

    @Test
    void deveLancarExcecaoParaPrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoLivro("Livro de Programação", -150));
    }
}
