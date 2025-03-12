import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private Cartao cartao;
    private double totalFatura;
    private List<String> compras;

    public Fatura(Cartao cartao) {
        if (!cartao.getTipo().equalsIgnoreCase("credito")) {
            throw new IllegalArgumentException("Faturas apenas para cartões de crédito");
        }
        this.cartao = cartao;
        this.totalFatura = 0;
        this.compras = new ArrayList<>();
    }

    public void adicionarCompra(String descricao, double valor) {
        cartao.realizarCompra(valor);
        compras.add(descricao + " - R$ " + valor);
        totalFatura += valor;
    }

    public void pagarFatura(double valor) {
        cartao.pagarFatura(valor);
        totalFatura -= valor;
    }

    public double getTotalFatura() {
        return totalFatura;
    }

    public List<String> getCompras() {
        return compras;
    }
}
