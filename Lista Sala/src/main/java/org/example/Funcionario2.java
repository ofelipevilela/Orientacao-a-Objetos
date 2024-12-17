package org.example;

public class Funcionario2 {

    private double salarioBruto;
    private double valorHoraExtra;
    private int numeroHorasExtras;

    public Funcionario2() {
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        if (salarioBruto <= 0) {
            throw new IllegalArgumentException("salario deve ser maior que zero");
        }
        this.salarioBruto = salarioBruto;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(double valorHoraExtra) {
        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("valor da hora extra nao pode ser negativo");
        }
        this.valorHoraExtra = valorHoraExtra;
    }

    public int getNumeroHorasExtras() {
        return numeroHorasExtras;
    }

    public void setNumeroHorasExtras(int numeroHorasExtras) {
        if (numeroHorasExtras < 0) {
            throw new IllegalArgumentException("horas extras nao podem ser negativas");
        }
        this.numeroHorasExtras = numeroHorasExtras;
    }


    public double calcularSalarioLiquido() {
        double totalHorasExtras = valorHoraExtra * numeroHorasExtras;
        double salarioTotal = salarioBruto + totalHorasExtras;
        double salarioLiquido = salarioTotal - (salarioTotal * 0.08);
        return salarioLiquido;
    }

}

