package org.example;

public class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio deve ser maior que zero.");
        }
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio deve ser maior que zero.");
        }
        this.raio = raio;
    }
}
