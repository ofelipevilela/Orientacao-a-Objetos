package org.example;

public class VooInternacional extends Voo {
    private static final double FATOR_PRECO = 1.0; // Fator de preço para voos internacionais
    private static final double TAXA_CONVERSAO = 1.2; // Taxa de conversão de moeda

    public VooInternacional(String origem, String destino, double distancia, LocalDate dataVoo) {
        super(origem, destino, distancia, dataVoo);
    }

    @Override
    public double calcularPreco() {
        return (distancia * FATOR_PRECO) * TAXA_CONVERSAO; // Preço base com fator e taxa de conversão
    }
}
