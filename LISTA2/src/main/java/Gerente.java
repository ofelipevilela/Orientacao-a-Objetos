package org.example;

public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(double salarioMensal, double bonus) {
        super(salarioMensal);
        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }
        this.bonus = bonus;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }
        this.bonus = bonus;
    }
}
