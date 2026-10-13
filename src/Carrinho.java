import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens = new ArrayList<>();

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void adicionarItem(ItemCarrinho item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }

        itens.add(item);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCarrinho item : itens) {
            total = total.add(item.calcularSubtotal());
        }

        return total;
    }
}