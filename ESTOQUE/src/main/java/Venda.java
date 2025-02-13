class Venda extends Transacao {
    private Cliente cliente;

    public Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
        this.cliente = cliente;
    }

    public boolean vender() {
        if (produto.verificarEstoquelnsuficiente(qtde)) {
            throw new IllegalArgumentException("Erro: Estoque insuficiente!");
        }
        produto.debitarEstoque(qtde);
        double valor = produto.calcularValorVenda(qtde);
        if (produto.verificarEstoqueBaixo()) {
            throw new IllegalArgumentException("Alerta: Estoque abaixo do mínimo!");
        }
        produto.registrarHistorico("Venda: " + qtde + " unidades para " + cliente.getNome() + " em " + dataTransacao);
        return true;
    }
}