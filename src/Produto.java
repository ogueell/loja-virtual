public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade do produto não pode ser negativa.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public boolean possuiEstoque(int quantidadeSolicitada) {
        if (quantidadeSolicitada <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade solicitada deve ser maior que zero."
            );
        }

        return quantidadeSolicitada <= quantidade;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade a ser reduzida deve ser maior que zero."
            );
        }
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException(
                    "Não é possível reduzir o estoque em uma quantidade maior do que a disponível."
            );

        }
        this.quantidade = this.quantidade - quantidade;
    }
}
