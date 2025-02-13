class Transacao {
    protected String dataTransacao;
    protected int qtde;
    protected Produto produto;

    public Transacao(String dataTransacao, Produto produto, int qtde) {
        this.dataTransacao = dataTransacao;
        this.produto = produto;
        this.qtde = qtde;
    }
}
