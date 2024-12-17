package org.example;

public class Combustivel {
    private double quilometrosRodados;
    private double combustivelConsumido;

    public Combustivel() {
    }
    public double getQuilometrosRodados() {
        return quilometrosRodados;
    }

    public void setQuilometrosRodados(double quilometrosRodados) {
        if (quilometrosRodados <= 0) {
            throw new IllegalArgumentException("Quantidade de quilometros rodados deve ser positiva");
        }
        this.quilometrosRodados = quilometrosRodados;
    }

    public double getCombustivelConsumido() {
        return combustivelConsumido;
    }

    public void setCombustivelConsumido(double combustivelConsumido) {
        if (combustivelConsumido <= 0) {
            throw new IllegalArgumentException("Quantidade de combustivel deve ser positiva");
        }
        this.combustivelConsumido = combustivelConsumido;
    }
    public double calcularMediaCombustivel() {
        return quilometrosRodados / combustivelConsumido;
    }
}
