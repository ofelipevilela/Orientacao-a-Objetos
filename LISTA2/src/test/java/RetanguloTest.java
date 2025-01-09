package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {

    @Test
    void deveCalcularAreaCorretamente() {
        Retangulo retangulo = new Retangulo(5, 10);
        assertEquals(50, retangulo.calcularArea());
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Retangulo retangulo = new Retangulo(5, 10);
        assertEquals(30, retangulo.calcularPerimetro());
    }

    @Test
    void deveLancarExcecaoQuandoLarguraOuAlturaForInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Retangulo(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> new Retangulo(5, -10));
    }
}
