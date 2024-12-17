package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergiaTest {
    @Test
    void consumoZero() {
        Energia energia = new Energia();
        energia.setQuilowattsConsumidos(0);
        double resultado = energia.calcularValorTotal();
        assertEquals(0.0, resultado);
    }

    @Test
    void consumoMinimoPositivo() {
        Energia energia = new Energia();
        energia.setQuilowattsConsumidos(1);
        double resultado = energia.calcularValorTotal();
        double esperado = 0.12 + (0.12 * 0.18);
        assertEquals(esperado, resultado);
    }
    @Test
    void consumoNegativo() {
        try {
            Energia energia = new Energia();
            energia.setQuilowattsConsumidos(-1);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Quantidade de energia não pode ser negativa", e.getMessage());
        }
    }

}