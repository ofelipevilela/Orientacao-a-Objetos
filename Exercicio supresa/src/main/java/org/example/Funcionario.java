package org.example;

public class Funcionario {
    private String nome;
    private double salarioBruto;
    private double totalAcrescimos;
    private double totalDescontos;

    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        if (salarioBruto < 0) {
            throw new IllegalArgumentException("salario bruto nao pode ser negativo");
        }
        this.salarioBruto = salarioBruto;
    }

    public double getTotalAcrescimos() {
        return totalAcrescimos;
    }

    public void setTotalAcrescimos(double totalAcrescimos) {
        if (totalAcrescimos < 0) {
            throw new IllegalArgumentException("acrescimos nao podem ser negativos");
        }
        this.totalAcrescimos = totalAcrescimos;
    }

    public double getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(double totalDescontos) {
        double limiteMaximoDesconto = salarioBruto + totalAcrescimos;
        if (totalDescontos < 0) {
            throw new IllegalArgumentException("descontos nao podem ser negativos");
        }
        if (totalDescontos > limiteMaximoDesconto) {
            throw new IllegalArgumentException("desconto nao pode exceder o salario bruto mais os acrescimos");
        }
        this.totalDescontos = totalDescontos;
    }
    public double calcularSalarioLiquido() {
        return salarioBruto + totalAcrescimos - totalDescontos;
    }
}
