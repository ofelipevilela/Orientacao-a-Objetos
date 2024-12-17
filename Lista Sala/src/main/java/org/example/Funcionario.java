package org.example;

public class Funcionario {
    private String nome;
    private double salarioAtual;
    private double percentualAumento;
    private double valorAumento;


    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(double salarioAtual) {
        if (salarioAtual <= 0) {
            throw new IllegalArgumentException("salario deve ser maior que zero");
        }
        this.salarioAtual = salarioAtual;
    }

    public double getPercentualAumento() {
        return percentualAumento;
    }

    public void setPercentualAumento(double percentualAumento) {
        if (percentualAumento < 0) {
            throw new IllegalArgumentException("aumento não pode ser negativo");
        }
        this.percentualAumento = percentualAumento;
    }

    public double getValorAumento() {
        return valorAumento;
    }

    public double calcularAumento() {
        this.valorAumento = (this.salarioAtual * this.percentualAumento) / 100;
        return this.salarioAtual + this.valorAumento;
    }
}

