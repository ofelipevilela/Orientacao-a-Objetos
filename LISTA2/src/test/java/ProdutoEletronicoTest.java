package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoEletronicoTest {

    @Test
    void deveCalcularPrecoComDesconto() {
        ProdutoEletronico eletronico = new ProdutoEletronico("Smartphone", 1000);
        assertEquals(900, eletronico.calcularPreco());
    }

    @Test
    void deveLancarExcecaoParaPrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new ProdutoEletronico("Smartphone", -1000));
    }
}
