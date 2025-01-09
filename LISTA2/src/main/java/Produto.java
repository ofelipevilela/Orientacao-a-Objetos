package org.example;

public abstract class Produto {
    protected String nome;
    protected double precoBase;

    public Produto(String nome, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("O preço base deve ser maior que zero.");
        }
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract double calcularPreco();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("O preço base deve ser maior que zero.");
        }
        this.precoBase = precoBase;
    }
}
