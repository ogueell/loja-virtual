import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {

    @Test
    void deveRejeitarPrecoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Teclado", new BigDecimal("-10.00"), 10)
        );
    }

    @Test
    void deveRejeitarNomeVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("", new BigDecimal("150.00"), 10)
        );
    }
}