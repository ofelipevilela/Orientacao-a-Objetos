package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiretorTest {

    @Test
    void deveCalcularPagamentoComParticipacaoNosLucros() {
        Diretor diretor = new Diretor(7000, 3000);
        assertEquals(10000, diretor.calcularPagamento());
    }

    @Test
    void deveLancarExcecaoParaParticipacaoLucrosInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Diretor(7000, -3000));
    }
}
