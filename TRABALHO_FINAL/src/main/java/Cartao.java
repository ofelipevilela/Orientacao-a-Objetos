public class Cartao {
    private Conta conta;
    private String tipo;
    private double limiteCredito;
    private double saldoCreditoUsado;

    public double getSaldoCreditoUsado() {
        return saldoCreditoUsado;
    }

    public Cartao(Conta conta, String tipo, double limiteCredito) {
        if (!tipo.equalsIgnoreCase("credito") && !tipo.equalsIgnoreCase("debito")) {
            throw new IllegalArgumentException("Tipo de cartão inválido");
        }
        this.conta = conta;
        this.tipo = tipo;
        this.limiteCredito = tipo.equalsIgnoreCase("credito") ? limiteCredito : 0;
        this.saldoCreditoUsado = 0;
    }

    public void realizarCompra(double valor) {
        if (tipo.equalsIgnoreCase("debito")) {
            if (conta instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) conta;
                double saldoDisponivel = conta.getSaldo() + cc.getLimiteChequeEspecial();

                if (saldoDisponivel >= valor) {
                    conta.sacar(valor);
                } else {
                    throw new IllegalArgumentException("Saldo insuficiente");
                }
            } else {
                if (conta.getSaldo() >= valor) {
                    conta.sacar(valor);
                } else {
                    throw new IllegalArgumentException("Saldo insuficiente");
                }
            }
        }
        else if (tipo.equalsIgnoreCase("credito")) {
            if (saldoCreditoUsado + valor <= limiteCredito) {
                saldoCreditoUsado += valor;
            } else {
                throw new IllegalArgumentException("Limite de crédito excedido");
            }
        }
    }

    public void pagarFatura(double valor) {
        if (valor <= 0 || valor > saldoCreditoUsado) {
            throw new IllegalArgumentException("Valor inválido para pagamento");
        }
        saldoCreditoUsado -= valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
