package classes;

import java.util.List;

import java.util.List;

public class ProdutoService {
    private static ProdutoService instance;
    private ProdutoRepository produtoRepository;

    ProdutoService() {
        this.produtoRepository = new ProdutoRepositoryImpl(); // Inicializa com a implementação padrão
    }

    public static ProdutoService getInstance() {
        if (instance == null) {
            instance = new ProdutoService();
        }
        return instance;
    }

    // Método para configurar o repositório em testes
    public static void setRepository(ProdutoRepository repository) {
        getInstance().produtoRepository = repository;
    }

    public void adicionarProduto(Produto produto) {
        if (produtoRepository == null) {
            throw new IllegalStateException("Repositório não inicializado.");
        }
        produtoRepository.salvar(produto);
    }

    public Produto buscarProdutoPorId(int id) {
        return produtoRepository.buscarPorId(id);
    }

    public void atualizarProduto(int id, String novoNome, double novoPreco) {
        Produto produto = produtoRepository.buscarPorId(id);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            produtoRepository.atualizar(produto);
        }
    }

    public void deletarProduto(int id) {
        produtoRepository.deletar(id);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.listarTodos();
    }
}
