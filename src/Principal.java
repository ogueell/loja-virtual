import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        Produto teclado = new Produto("Teclado", 150.00, 10);

        Produto mouse = new Produto("Mouse", 50.00, 5);

        Produto monitor = new Produto("Monitor", 300.00, 10);

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

            int escolha;

            while (true) {
                System.out.println("Escolha o número do produto: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Digite um número inteiro.");
                    scanner.next();
                    continue;
                }

                escolha = scanner.nextInt();

                if (escolha >= 1 && escolha <= produtos.size()) {
                    break;
                }

                System.out.println(
                        "Produto inválido. Escolha uma opção entre 1 e "
                                + produtos.size() + "."
                );
            }

            System.out.println("Quantidade desejada: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Digite uma quantidade inteira.");
                scanner.next();
            }

            int quantidade = scanner.nextInt();

            Produto produtoEscolhido = produtos.get(escolha - 1);

            try {
                if (produtoEscolhido.possuiEstoque(quantidade)) {
                    produtoEscolhido.reduzirEstoque(quantidade);

                    ItemCarrinho itemCarrinho = new ItemCarrinho(produtoEscolhido, quantidade);

                    carrinho.adicionarItem(itemCarrinho);
                } else {
                    System.out.println(
                            "Quantidade solicitada não disponível em estoque."
                    );
                }
            } catch (IllegalArgumentException erro) {
                System.out.println("Não foi possível realizar a compra.");
                System.out.println(erro.getMessage());
            }

            System.out.println("Deseja continuar comprando? (1 - Sim / 0 - Não)");

            while (!scanner.hasNextInt()) {
                System.out.println("Digite 1 para continuar ou 0 para finalizar.");
                scanner.next();
            }

            int resposta = scanner.nextInt();

            while (resposta != 0 && resposta != 1) {
                System.out.println("Opção inválida. Digite 1 para continuar ou 0 para finalizar.");

                while (!scanner.hasNextInt()) {
                    System.out.println("Digite 1 para continuar ou 0 para finalizar.");
                    scanner.next();
                }

                resposta = scanner.nextInt();
            }

            if (resposta == 0) {
                continuarComprando = false;
            }
        }

        System.out.println("Total da compra: " + carrinho.calcularTotal());
    }
}