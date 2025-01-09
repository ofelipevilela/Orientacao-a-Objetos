package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VooInternacionalTest {

    @Test
    void deveCalcularPrecoParaVooInternacional() {
        VooInternacional vooInternacional = new VooInternacional("São Paulo", "Nova York", 8000, LocalDate.now());
        assertEquals(9600, vooInternacional.calcularPreco()); // (8000 * 1.0) * 1.2
    }

    @Test
    void deveLancarExcecaoParaDistanciaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new VooInternacional("São Paulo", "Nova York", 0, LocalDate.now()));
    }
}
