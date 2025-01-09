package org.example;

public abstract class Funcionario {
    protected double salarioMensal;

    public Funcionario(double salarioMensal) {
        if (salarioMensal <= 0) {
            throw new IllegalArgumentException("O salário mensal deve ser maior que zero.");
        }
        this.salarioMensal = salarioMensal;
    }

    public abstract double calcularPagamento();

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        if (salarioMensal <= 0) {
            throw new IllegalArgumentException("O salário mensal deve ser maior que zero.");
        }
        this.salarioMensal = salarioMensal;
    }
}
