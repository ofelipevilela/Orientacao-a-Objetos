class Compra extends Transacao {
    private double precoUnit;

    public Compra(String dataCompra, Produto produto, int qtdeCompra, double precoUnit) {
        super(dataCompra, produto, qtdeCompra);
        this.precoUnit = precoUnit;
    }

    public boolean comprar() {
        if (produto.verificarEstoqueExcedente(qtde)) {
            throw new IllegalArgumentException("Erro: Estoque máximo excedido!");
        }
        produto.creditarEstoque(qtde);
        produto.registrarHistorico("Compra: " + qtde + " unidades em " + dataTransacao);
        return true;
    }
}