package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

    @Test
    void deveCalcularPagamentoComBonus() {
        Gerente gerente = new Gerente(5000, 1000);
        assertEquals(6000, gerente.calcularPagamento());
    }

    @Test
    void deveLancarExcecaoParaBonusInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Gerente(5000, -1000));
    }
}
