package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void calcularSalarioLiquidoValido() {
        Funcionario funcionario = new Funcionario();
        funcionario.setSalarioBruto(10000.0);
        funcionario.setTotalAcrescimos(1000.0);
        funcionario.setTotalDescontos(200.0);

        assertEquals(10800.0, funcionario.calcularSalarioLiquido());
    }
    @Test
    void naoDeveCalcularSalarioBrutoNegativo() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setSalarioBruto(-1000.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("salario bruto nao pode ser negativo", e.getMessage());
        }
    }
    @Test
    void naoDeveCalcularAcrescimosNegativos() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTotalAcrescimos(-100.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("acrescimos nao podem ser negativos", e.getMessage());
        }
    }

    @Test
    void naoDeveCalcularDescontosNegativos() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTotalDescontos(-200.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("descontos nao podem ser negativos", e.getMessage());
        }
    }

    @Test
    void naoDeveCalcularDescontosMaioresQueLimiteMaximo() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setSalarioBruto(2000.0);
            funcionario.setTotalAcrescimos(500.0);
            funcionario.setTotalDescontos(3000.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("desconto nao pode exceder o salario bruto mais os acrescimos", e.getMessage());
        }
    }
}