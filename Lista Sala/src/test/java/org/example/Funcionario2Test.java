package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Funcionario2Test {

    @Test
    void salarioLiquidoValido() {
        Funcionario2 funcionario = new Funcionario2();
        funcionario.setSalarioBruto(10000.0);
        funcionario.setValorHoraExtra(50.0);
        funcionario.setNumeroHorasExtras(10);
        double salarioLiquido = funcionario.calcularSalarioLiquido();
        assertEquals(9660.0, salarioLiquido);
    }

    @Test
    void salarioLiquidoSemHorasExtras() {
        Funcionario2 funcionario = new Funcionario2();
        funcionario.setSalarioBruto(10000.0);
        funcionario.setValorHoraExtra(0.0);
        funcionario.setNumeroHorasExtras(0);

        double salarioLiquido = funcionario.calcularSalarioLiquido();
        assertEquals(9200.0, salarioLiquido);
    }

    @Test
    void salarioLiquidoComHorasExtrasZero() {
        Funcionario2 funcionario = new Funcionario2();
        funcionario.setSalarioBruto(10000.0);
        funcionario.setValorHoraExtra(0.0);
        funcionario.setNumeroHorasExtras(0);

        double salarioLiquido = funcionario.calcularSalarioLiquido();
        assertEquals(9200, salarioLiquido);
    }


    @Test
    void salarioMaiorZero() {
        try {
            Funcionario2 funcionario = new Funcionario2();
            funcionario.setSalarioBruto(0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("salario deve ser maior que zero", e.getMessage());
        }
    }

    @Test
    void horaExtraNegativa() {
        try {
            Funcionario2 funcionario = new Funcionario2();
            funcionario.setValorHoraExtra(-20.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("valor da hora extra nao pode ser negativo", e.getMessage());
        }
    }

    @Test
    void quantidadeHorasExtrasNegativo() {
        try {
            Funcionario2 funcionario = new Funcionario2();
            funcionario.setNumeroHorasExtras(-5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("horas extras nao podem ser negativas", e.getMessage());
        }
    }

}