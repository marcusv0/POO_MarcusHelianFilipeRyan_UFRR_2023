import java.util.List;
import java.util.ArrayList;

public class Faturas {
    private Reserva reserva;
    private double valorTotal;
    private List<itemFatura> itens;

    // Construtor omitido para brevidade

    /**
     * Obtém o valor total da fatura.
     * @return O valor total da fatura.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total da fatura.
     * @param valorTotal O novo valor total da fatura.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Adiciona um item à fatura.
     * @param itemFatura O item da fatura a ser adicionado.
     */
    public void adicionarItemFatura(itemFatura itemFatura) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(itemFatura);
    }

    /**
     * Obtém a lista de itens da fatura.
     * @return A lista de itens da fatura.
     */
    public List<itemFatura> getItens() {
        return itens;
    }
}
