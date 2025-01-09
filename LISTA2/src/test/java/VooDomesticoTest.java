package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VooDomesticoTest {

    @Test
    void deveCalcularPrecoParaVooDomestico() {
        VooDomestico vooDomestico = new VooDomestico("São Paulo", "Rio de Janeiro", 400, LocalDate.now());
        assertEquals(200, vooDomestico.calcularPreco());
    }

    @Test
    void deveLancarExcecaoParaDistanciaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new VooDomestico("São Paulo", "Rio de Janeiro", -100, LocalDate.now()));
    }
}
