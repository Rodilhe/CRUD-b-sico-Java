package classes;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void atualizar(Produto produto) {
        deletar(produto.getId());
        salvar(produto);
    }

    @Override
    public void deletar(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }
}
