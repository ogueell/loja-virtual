import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        Produto teclado = new Produto();
        teclado.setNome("Teclado");
        teclado.setPreco(150.00);
        teclado.setQuantidade(10);

        Produto mouse = new Produto();
        mouse.setNome("Mouse");
        mouse.setPreco(50.00);
        mouse.setQuantidade(5);

        Produto monitor = new Produto();
        monitor.setNome("Monitor");
        monitor.setPreco(300.00);
        monitor.setQuantidade(10);

        produtos.add(teclado);
        produtos.add(mouse);
        produtos.add(monitor);

        Carrinho carrinho = new Carrinho();
        
        Scanner scanner = new Scanner(System.in);
        boolean continuarComprando = true;

        while (continuarComprando) {

            System.out.println("=== Produtos disponíveis ===");
            for (int i = 0; i < produtos.size(); i++) {
                Produto produtoAtual = produtos.get(i);
                System.out.println((i + 1) + " - " + produtoAtual.getNome() + " - R$" + produtoAtual.getPreco());
            }

            System.out.println("Escolha o número do produto: ");
            int escolha = scanner.nextInt();

            System.out.println("Quantidade desejada: ");
            int quantidade = scanner.nextInt();

            Produto produtoEscolhido = produtos.get(escolha - 1);

            ItemCarrinho itemCarrinho = new ItemCarrinho();
            itemCarrinho.setProduto(produtoEscolhido);
            itemCarrinho.setQuantidade(quantidade);

            carrinho.adicionarItem(itemCarrinho);

            System.out.println("Deseja continuar comprando? (1 - Sim / 0 - Não)");
            int resposta = scanner.nextInt();

            if (resposta == 0) {
                continuarComprando = false;
            }
        }

        System.out.println("Total da compra: " + carrinho.calcularTotal());
    }
}