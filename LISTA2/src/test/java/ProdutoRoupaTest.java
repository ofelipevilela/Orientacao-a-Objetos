package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoRoupaTest {

    @Test
    void deveCalcularPrecoComDesconto() {
        ProdutoRoupa roupa = new ProdutoRoupa("Camiseta", 200);
        assertEquals(160, roupa.calcularPreco());
    }

    @Test
    void deveLancarExcecaoParaPrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoRoupa("Camiseta", 0));
    }
}
