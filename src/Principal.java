import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        Produto teclado = new Produto("Teclado", new BigDecimal("150.00"), 10);
        Produto mouse = new Produto("Mouse", new BigDecimal("50.00"), 5);
        Produto monitor = new Produto("Monitor", new BigDecimal("300.00"), 10);

        produtos.add(teclado);
        produtos.add(mouse);
        produtos.add(monitor);

        Carrinho carrinho = new Carrinho();

        Scanner scanner = new Scanner(System.in);
        boolean continuarComprando = true;

        while (continuarComprando) {

            exibirProdutos(produtos);

            int escolha = escolherProduto(scanner, produtos.size());

            int quantidade = lerInteiro(scanner, "Quantidade desejada: ");

            Produto produtoEscolhido = produtos.get(escolha - 1);

            processarCompra(produtoEscolhido, quantidade, carrinho);

            continuarComprando = desejaContinuarComprando(scanner);
        }

        System.out.println("Total da compra: " + carrinho.calcularTotal());
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);

            if (!scanner.hasNextInt()) {
                System.out.println("Digite um número inteiro.");
                scanner.next();
                continue;
            }

            return scanner.nextInt();
        }
    }

    private static void exibirProdutos(List<Produto> produtos) {
        System.out.println("=== Produtos disponíveis ===");

        for (int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);
            System.out.println((i + 1) + " - " + produtoAtual.getNome() + " - R$" + produtoAtual.getPreco());
        }
    }

    private static int escolherProduto(Scanner scanner, int quantidadeProdutos) {
        while (true) {
            int escolha = lerInteiro(scanner, "Escolha o número do produto: ");

            if (escolha >= 1 && escolha <= quantidadeProdutos) {
                return escolha;
            }

            System.out.println("Produto inválido. Escolha uma opção entre 1 e " + quantidadeProdutos + ".");
        }
    }

    private static void processarCompra(Produto produto, int quantidade, Carrinho carrinho) {
        try {
            if (produto.possuiEstoque(quantidade)) {
                produto.reduzirEstoque(quantidade);

                ItemCarrinho itemCarrinho = new ItemCarrinho(produto, quantidade);

                carrinho.adicionarItem(itemCarrinho);
            } else {
                System.out.println("Quantidade solicitada não disponível em estoque.");
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("Não foi possível realizar a compra.");
            System.out.println(erro.getMessage());
        }
    }

    private static boolean desejaContinuarComprando(Scanner scanner) {
        while (true) {
            int resposta = lerInteiro(scanner, "Deseja continuar comprando? (1 - Sim / 0 - Não)");

            if (resposta == 1) {
                return true;
            }

            if (resposta == 0) {
                return false;
            }

            System.out.println("Opção inválida. Digite 1 para continuar ou 0 para finalizar.");
        }
    }
}