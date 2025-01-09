package org.example;

public class ProdutoRoupa extends Produto {

    public ProdutoRoupa(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public double calcularPreco() {
        return precoBase * 0.80; // Desconto de 20%
    }
}
