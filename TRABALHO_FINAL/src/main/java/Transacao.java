import java.time.LocalDateTime;

public class Transacao {
    private Conta origem;
    private Conta destino;
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(Conta origem, Conta destino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }

        // Verificando se o valor a ser sacado está dentro do limite disponível (saldo + cheque especial)
        if (origem instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) origem;
            if (valor > contaCorrente.getSaldo() + contaCorrente.getLimiteChequeEspecial()) {
                throw new IllegalArgumentException("Saldo insuficiente, incluindo limite do cheque especial");
            }
        } else {
            if (origem.getSaldo() < valor) {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        }

        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();

        origem.sacar(valor);
        destino.depositar(valor);
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
