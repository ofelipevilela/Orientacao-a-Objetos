package org.example;

public class Pessoa {
    private String sexo;
    private double peso;
    private double altura;

    public Pessoa() {
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (!"M".equalsIgnoreCase(sexo) && !"F".equalsIgnoreCase(sexo)) {
            throw new IllegalArgumentException("Use 'M' para masculino ou 'F' para feminino");
        }
        this.sexo = sexo.toUpperCase();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero");
        }
        this.altura = altura;
    }
    public String calculaImc() {
        double imc = peso / (altura * altura);

        if (sexo.equals("F")) {
            if (imc < 19.1) {
                return "Abaixo do peso";
            } else if (imc < 25.8) {
                return "No peso normal";
            } else if (imc < 27.3) {
                return "Marginalmente acima do peso";
            } else if (imc < 32.3) {
                return "Acima do peso ideal";
            } else {
                return "Obeso";
            }
        } else if (sexo.equals("M")) {
            if (imc < 20.7) {
                return "Abaixo do peso";
            } else if (imc < 26.4) {
                return "No peso normal";
            } else if (imc < 27.8) {
                return "Marginalmente acima do peso";
            } else if (imc < 31.1) {
                return "Acima do peso ideal";
            } else {
                return "Obeso";
            }
        }
        throw new IllegalStateException("Sexo não definido corretamente.");
    }

}
