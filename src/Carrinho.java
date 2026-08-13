import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens = new ArrayList<>();

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemCarrinho item : itens) {
            total = total + item.calcularSubtotal();
        }

        return total;
    }
}
