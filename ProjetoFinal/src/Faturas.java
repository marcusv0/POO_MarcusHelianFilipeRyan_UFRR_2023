import java.util.List;
import java.util.ArrayList;

public class Faturas {
    private Reserva reserva;
    private double valorTotal;
    private List<itemFatura> item;

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarItemFatura(itemFatura itemFatura) {
        if (item == null) {
            item = new ArrayList<>();
        }
        item.add(itemFatura);
    }

    public List<itemFatura> getItem() {
        return item;
    }

}
