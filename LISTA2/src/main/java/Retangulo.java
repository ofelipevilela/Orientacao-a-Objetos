package org.example;

public class Retangulo extends FormaGeometrica {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        if (largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("A largura e a altura devem ser maiores que zero.");
        }
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura <= 0) {
            throw new IllegalArgumentException("A largura deve ser maior que zero.");
        }
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que zero.");
        }
        this.altura = altura;
    }
}
