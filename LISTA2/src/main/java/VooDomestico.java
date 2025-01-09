package org.example;

public class VooDomestico extends Voo {
    private static final double FATOR_PRECO = 0.5; // Fator de preço para voos domésticos

    public VooDomestico(String origem, String destino, double distancia, LocalDate dataVoo) {
        super(origem, destino, distancia, dataVoo);
    }

    @Override
    public double calcularPreco() {
        return distancia * FATOR_PRECO; // Preço com base na distância e fator específico
    }
}
