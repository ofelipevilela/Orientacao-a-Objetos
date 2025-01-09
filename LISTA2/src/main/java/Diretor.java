package org.example;

public class Diretor extends Funcionario {
    private double participacaoLucros;

    public Diretor(double salarioMensal, double participacaoLucros) {
        super(salarioMensal);
        if (participacaoLucros < 0) {
            throw new IllegalArgumentException("A participação nos lucros não pode ser negativa.");
        }
        this.participacaoLucros = participacaoLucros;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal + participacaoLucros;
    }

    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    public void setParticipacaoLucros(double participacaoLucros) {
        if (participacaoLucros < 0) {
            throw new IllegalArgumentException("A participação nos lucros não pode ser negativa.");
        }
        this.participacaoLucros = participacaoLucros;
    }
}
