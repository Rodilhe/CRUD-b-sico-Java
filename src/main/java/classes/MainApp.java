package classes;

import java.util.Scanner;

public class MainApp {
    private static final ProdutoService produtoService = new ProdutoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Deletar Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProdutoPorId();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    deletarProduto();
                    break;
                case 6:
                    running = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(id, nome, preco);
        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("Lista de Produtos:");
        for (Produto produto : produtoService.listarProdutos()) {
            System.out.println(produto);
        }
    }

    private static void buscarProdutoPorId() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();

        Produto produto = produtoService.buscarProdutoPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void atualizarProduto() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Novo Nome do Produto: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo Preço do Produto: ");
        double novoPreco = scanner.nextDouble();

        produtoService.atualizarProduto(id, novoNome, novoPreco);
        System.out.println("Produto atualizado com sucesso!");
    }

    private static void deletarProduto() {
        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();

        produtoService.deletarProduto(id);
        System.out.println("Produto deletado com sucesso!");
    }
}