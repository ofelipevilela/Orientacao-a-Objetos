import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class BancoTest {

    @Test
    void deveCriarContaCorrenteParaCliente() {
        Cliente cliente = new Cliente("Felipe");
        ContaCorrente conta = new ContaCorrente(cliente, 500.0);
        assertEquals(0, conta.getSaldo());
    }

    @Test
    void deveCriarContaPoupancaParaCliente() {
        Cliente cliente = new Cliente("Felipe");
        ContaPoupanca conta = new ContaPoupanca(cliente, 0.01);
        assertEquals(cliente, conta.getCliente());
    }

    @Test
    void deveTestarRendimentoMensal() {
        Cliente cliente = new Cliente("Felipe");
        ContaPoupanca conta = new ContaPoupanca(cliente, 0.01);
        conta.depositar(1000);
        conta.aplicarRendimento();
        assertEquals(1010, conta.getSaldo());
    }

    @Test
    void deveRealizarDepositoEmContaCorrente() {
        Cliente cliente = new Cliente("Felipe");
        ContaCorrente conta = new ContaCorrente(cliente, 200.0);
        conta.depositar(300);
        assertEquals(300.0, conta.getSaldo());
    }

    @Test
    void deveRealizarSaqueEmContaCorrente() {
        Cliente cliente = new Cliente("Felipe");
        ContaCorrente conta = new ContaCorrente(cliente, 400.0);
        conta.depositar(100);
        conta.sacar(500);
        assertEquals(-400.0, conta.getSaldo());
    }

    @Test
    void deveGerarExcecaoAoSacarValorNaoPositivo() {
        try {
            Cliente cliente = new Cliente("Felipe");
            ContaCorrente conta = new ContaCorrente(cliente, 300.0);
            conta.depositar(100.0);
            conta.sacar(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O valor do saque deve ser positivo", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoAoSacarValorMaiorQueOLimite() {
        try {
            Cliente cliente = new Cliente("Felipe");
            ContaCorrente conta = new ContaCorrente(cliente, 300.0); // Cheque especial = 300
            conta.depositar(100.0); // Saldo inicial = 100
            conta.sacar(401); // Tentativa de saque maior que saldo + cheque especial (400)
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }


    @Test
    void deveTransferirEntreContas() {
        Cliente cliente1 = new Cliente("Felipe");
        ContaCorrente conta1 = new ContaCorrente(cliente1, 500.0);
        conta1.depositar(500.0);
        ContaCorrente conta2 = new ContaCorrente(cliente1, 100.0); // contas para mesmo cliente

        Transacao transacao = new Transacao(conta1, conta2, 1000.0); // Usa todo o cheque especial

        assertEquals(-500.0, conta1.getSaldo());
        assertEquals(1000, conta2.getSaldo());
    }

    @Test
    void deveGerarExcecaoTransferenciaNegativa() {
        try {
            Cliente cliente1 = new Cliente("Felipe");
            ContaCorrente conta1 = new ContaCorrente(cliente1, 500.0);
            conta1.depositar(500.0);

            Cliente cliente2 = new Cliente("Paula");
            ContaCorrente conta2 = new ContaCorrente(cliente2, 100);
            conta2.depositar(300.0);

            // Criando a transação de transferência
            Transacao transacao = new Transacao(conta1, conta2, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor deve ser positivo", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoTransferenciaMaiorQueSaldoChequeEspecial() {
        try {
            Cliente cliente1 = new Cliente("Felipe");
            ContaCorrente conta1 = new ContaCorrente(cliente1, 500.0);
            conta1.depositar(500.0);

            Cliente cliente2 = new Cliente("Paula");
            ContaCorrente conta2 = new ContaCorrente(cliente2, 100);
            conta2.depositar(300.0);

            Transacao transacao = new Transacao(conta1, conta2, 1001);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente, incluindo limite do cheque especial", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoTransferenciaMaiorQueSaldo() {
        try {
            Cliente cliente1 = new Cliente("Felipe");
            ContaPoupanca conta1 = new ContaPoupanca(cliente1, 0.01);
            conta1.depositar(500.0);
            ContaCorrente conta2 = new ContaCorrente(cliente1, 100);
            conta2.depositar(300.0);

            Transacao transacao = new Transacao(conta1, conta2, 501);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }

    @Test
    void deveSolicitarEmprestimo() {
        Cliente cliente = new Cliente("Felipe");
        Emprestimo emprestimo = new Emprestimo(cliente, 1000.0, 0.05, 12);
        assertEquals(cliente, emprestimo.getCliente());
        assertEquals(1795.85, emprestimo.calcularTotal(), 0.01);
    }

    @Test
    void devePagarParcelaDeEmprestimo() {
        Cliente cliente = new Cliente("Felipe");
        Emprestimo emprestimo = new Emprestimo(cliente, 1000.0, 0.05, 12);
        emprestimo.pagarParcela(500);
        assertEquals(1295.85, emprestimo.getSaldoDevedor(), 0.01);
    }

    @Test
    void deveGerarExcecaoTaxaJurosNegativa() {
        try {
            Cliente cliente = new Cliente("Felipe");
            Emprestimo emprestimo = new Emprestimo(cliente, 1000.0, -0.05, 12);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valores invalidos para emprestimo", e.getMessage());
        }
    }

    @Test
    void deveCriarCartaoDebitoComLimiteZero() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "debito", 1000);
        assertEquals("debito", cartao.getTipo());
        assertEquals(0, cartao.getLimiteCredito());
    }

    @Test
    void deveCriarCartaoCreditoComLimiteCorreto() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 2000);
        assertEquals("credito", cartao.getTipo());
        assertEquals(2000, cartao.getLimiteCredito());
    }

    @Test
    void deveGerarExcecaoParaTipoDeCartaoInvalido() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            new Cartao(conta, "pre-pago", 1000);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de cartão inválido", e.getMessage());
        }
    }

    @Test
    void deveRealizarCompraNoDebitoComSaldoSuficiente() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "debito", 0);
        cartao.realizarCompra(500);
        assertEquals(-500, conta.getSaldo());
    }

    @Test
    void deveGerarExcecaoParaCompraNoDebitoComSaldoInsuficiente() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 100);
            Cartao cartao = new Cartao(conta, "debito", 0);
            cartao.realizarCompra(101);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }

    @Test
    void deveRealizarCompraNoCreditoDentroDoLimite() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 1000);
        cartao.realizarCompra(1000);
        assertEquals(1000, cartao.getSaldoCreditoUsado());
    }

    @Test
    void deveGerarExcecaoParaCompraNoCreditoAcimaDoLimite() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 1000);
            cartao.realizarCompra(1001);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Limite de crédito excedido", e.getMessage());
        }
    }

    @Test
    void devePagarFaturaParcialmente() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 1000);
        cartao.realizarCompra(700);
        cartao.pagarFatura(300);
        assertEquals(400, cartao.getSaldoCreditoUsado());
    }

    @Test
    void devePagarFaturaTotalmente() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 1000);
        cartao.realizarCompra(500);
        cartao.pagarFatura(500);
        assertEquals(0, cartao.getSaldoCreditoUsado());
    }

    @Test
    void deveGerarExcecaoParaPagamentoMaiorQueSaldoDevedor() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 1000);
            cartao.realizarCompra(500);
            cartao.pagarFatura(600);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido para pagamento", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoParaPagamentoNegativo() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 1000);
            cartao.realizarCompra(500);
            cartao.pagarFatura(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido para pagamento", e.getMessage());
        }
    }

    @Test
    void deveCriarFaturaParaCartaoCredito() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 2000);
        Fatura fatura = new Fatura(cartao);

        assertEquals(0, fatura.getTotalFatura());
        assertTrue(fatura.getCompras().isEmpty());
    }

    @Test
    void deveGerarExcecaoParaFaturaDeCartaoDebito() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "debito", 0);
            new Fatura(cartao);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Faturas apenas para cartões de crédito", e.getMessage());
        }
    }

    @Test
    void deveAdicionarComprasNaFatura() {
        Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
        Cartao cartao = new Cartao(conta, "credito", 1700);
        Fatura fatura = new Fatura(cartao);

        fatura.adicionarCompra("Notebook", 1500);
        fatura.adicionarCompra("Mouse", 200);

        assertEquals(1700, fatura.getTotalFatura());
        assertEquals(2, fatura.getCompras().size());
    }

    @Test
    void deveGerarExcecaoParaCompraQueExcedeLimiteDoCartao() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 1000);
            Fatura fatura = new Fatura(cartao);

            fatura.adicionarCompra("TV", 1200);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Limite de crédito excedido", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoParaPagamentoMaiorQueTotalDaFatura() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 2000);
            Fatura fatura = new Fatura(cartao);

            fatura.adicionarCompra("Monitor", 800);
            fatura.pagarFatura(801);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido para pagamento", e.getMessage());
        }
    }

    @Test
    void deveGerarExcecaoParaPagamentoNegativoDaFatura() {
        try {
            Conta conta = new ContaCorrente(new Cliente("Felipe"), 500);
            Cartao cartao = new Cartao(conta, "credito", 2000);
            Fatura fatura = new Fatura(cartao);

            fatura.adicionarCompra("Impressora", 400);
            fatura.pagarFatura(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido para pagamento", e.getMessage());
        }
    }
    @Test
    void deveCriarFuncionarioComDadosValidos() {
        Funcionario funcionario = new Funcionario("Felipe", "Gerente", 5000);
        assertEquals("Felipe", funcionario.getNome());
        assertEquals("Gerente", funcionario.getCargo());
        assertEquals(5000, funcionario.getSalario());
    }

    @Test
    void deveGerarExcecaoParaSalarioZero() {
        try {
            new Funcionario("Felipe", "Analista", 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Salário deve ser positivo.", e.getMessage());
        }
    }
}

