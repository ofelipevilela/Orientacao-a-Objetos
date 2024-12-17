package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombustivelTest {
    @Test
    void mediaValida() {
        Combustivel combustivel = new Combustivel();
        combustivel.setQuilometrosRodados(500);
        combustivel.setCombustivelConsumido(25);
        double resultado = combustivel.calcularMediaCombustivel();
        double esperado = 500 / 25;  // Média: 20 km/l
        assertEquals(esperado, resultado);
    }


    @Test
    void quilometrosRodadosZero() {
        Combustivel combustivel = new Combustivel();
        try {
            combustivel.setQuilometrosRodados(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de quilometros rodados deve ser positiva", e.getMessage());
        }
    }


    @Test
    void combustivelZero() {
        Combustivel combustivel = new Combustivel();
        try {
            combustivel.setCombustivelConsumido(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de combustivel deve ser positiva", e.getMessage());
        }
    }


    @Test
    void quilometrosRodadosNegativo() {
        Combustivel combustivel = new Combustivel();
        try {
            combustivel.setQuilometrosRodados(-100);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de quilometros rodados deve ser positiva", e.getMessage());
        }
    }

    @Test
    void combustivelNegativo() {
        Combustivel combustivel = new Combustivel();
        try {
            combustivel.setCombustivelConsumido(-10);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de combustivel deve ser positiva", e.getMessage());
        }
    }
}