package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    void deveCalcularAreaCorretamente() {
        Circulo circulo = new Circulo(5);
        assertEquals(78.53981633974483, circulo.calcularArea(), 0.0001);
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Circulo circulo = new Circulo(5);
        assertEquals(31.41592653589793, circulo.calcularPerimetro(), 0.0001);
    }

    @Test
    void deveLancarExcecaoQuandoRaioForInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Circulo(-1));
    }
}
