class Produto {
    private String nome;
    private int qtdeEstoque;
    private double precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private ArrayList<String> historico;

    public Produto(String nome, int qtdeEstoque, double precoUnit, int estoqueMinimo, int estoqueMaximo) {
        this.nome = nome;
        this.qtdeEstoque = qtdeEstoque;
        this.precoUnit = precoUnit;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.historico = new ArrayList<>();
    }

    public void debitarEstoque(int quantidade) {
        this.qtdeEstoque -= quantidade;
    }

    public void creditarEstoque(int quantidade) {
        this.qtdeEstoque += quantidade;
    }

    public boolean verificarEstoqueBaixo() {
        return this.qtdeEstoque < this.estoqueMinimo;
    }

    public boolean verificarEstoquelnsuficiente(int quantidade) {
        return quantidade > this.qtdeEstoque;
    }

    public boolean verificarEstoqueExcedente(int quantidade) {
        return (this.qtdeEstoque + quantidade) > this.estoqueMaximo;
    }

    public double calcularValorVenda(int quantidade) {
        return this.precoUnit * quantidade;
    }

    public void registrarHistorico(String transacao) {
        historico.add(transacao);
    }

    public void exibirHistorico() {
        for (String registro : historico) {
            System.out.println(registro);
        }
    }
}