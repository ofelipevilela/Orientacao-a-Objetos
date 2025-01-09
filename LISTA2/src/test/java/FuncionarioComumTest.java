package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioComumTest {

    @Test
    void deveCalcularPagamentoCorretamente() {
        FuncionarioComum funcionario = new FuncionarioComum(3000);
        assertEquals(3000, funcionario.calcularPagamento());
    }

    @Test
    void deveLancarExcecaoParaSalarioInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioComum(-3000));
    }
}
