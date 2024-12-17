package org.example;

public class Energia {
    private double quilowattsConsumidos;
    private double valorQuilowatt = 0.12;
    private double icms = 0.18;

    public Energia() {
    }

    public double calcularValorTotal() {
        double valorBase = quilowattsConsumidos * valorQuilowatt;
        double valorICMS = valorBase * icms;
        return valorBase + valorICMS;
    }

    public double getQuilowattsConsumidos() {
        return quilowattsConsumidos;
    }

    public void setQuilowattsConsumidos(double quilowattsConsumidos) {
        if (quilowattsConsumidos < 0) {
            throw new IllegalArgumentException("Quantidade de energia não pode ser negativa");
        }
        this.quilowattsConsumidos = quilowattsConsumidos;
    }

    public double getValorQuilowatt() {
        return valorQuilowatt;
    }

    public double getIcms() {
        return icms;
    }
}