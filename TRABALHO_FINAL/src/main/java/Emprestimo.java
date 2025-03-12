public class Emprestimo {
    private Cliente cliente;
    private double valor;
    private double taxaJuros; // Exemplo: 0.05 para 5% ao mês
    private int parcelas;
    private double saldoDevedor;

    public Emprestimo(Cliente cliente, double valor, double taxaJuros, int parcelas) {
        if (valor <= 0 || taxaJuros < 0 || parcelas <= 0) {
            throw new IllegalArgumentException("Valores invalidos para emprestimo");
        }
        this.cliente = cliente;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.parcelas = parcelas;
        this.saldoDevedor = calcularTotal();
    }

    public double calcularTotal() {
        return valor * Math.pow(1 + taxaJuros, parcelas);
    }

    public void pagarParcela(double valorPago) {
        if (valorPago <= 0 || valorPago > saldoDevedor) {
            throw new IllegalArgumentException("Valor inválido para pagamento");
        }
        saldoDevedor -= valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }
}
