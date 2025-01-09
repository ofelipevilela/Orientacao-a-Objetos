package org.example;

public class ProdutoEletronico extends Produto {

    public ProdutoEletronico(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public double calcularPreco() {
        return precoBase * 0.90; // Desconto de 10%
    }
}
