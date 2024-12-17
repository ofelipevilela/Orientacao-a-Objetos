package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void aumentoValido() {
        Funcionario funcionario = new Funcionario();
        funcionario.setSalarioAtual(10000.0);
        funcionario.setPercentualAumento(10.0);
        double novoSalario = funcionario.calcularAumento();
        assertEquals(11000.0, novoSalario);
        assertEquals(1000.0, funcionario.getValorAumento());
    }

    @Test
    void AumentoZero() {
        Funcionario funcionario = new Funcionario();
        funcionario.setSalarioAtual(10000.0);
        funcionario.setPercentualAumento(0.0);
        double novoSalario = funcionario.calcularAumento();
        assertEquals(10000.0, novoSalario);
        assertEquals(0.0, funcionario.getValorAumento());
    }


    @Test
    void aumentoNegativo() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setPercentualAumento(-10.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("aumento não pode ser negativo", e.getMessage());
        }
    }

    @Test
    void salarioMaiorZero() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setSalarioAtual(0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("salario deve ser maior que zero", e.getMessage());
        }
    }

    @Test
    void salarioNegativo() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setSalarioAtual(-10000.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("salario deve ser maior que zero", e.getMessage());
        }
    }

}
