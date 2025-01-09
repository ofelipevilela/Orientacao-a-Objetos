package org.example;

import java.time.LocalDate;

public abstract class Voo {
    protected String origem;
    protected String destino;
    protected double distancia; // em quilômetros
    protected LocalDate dataVoo;

    public Voo(String origem, String destino, double distancia, LocalDate dataVoo) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.dataVoo = dataVoo;
    }

    public abstract double calcularPreco();

    // Getters e setters
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }
        this.distancia = distancia;
    }

    public LocalDate getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(LocalDate dataVoo) {
        this.dataVoo = dataVoo;
    }
}
