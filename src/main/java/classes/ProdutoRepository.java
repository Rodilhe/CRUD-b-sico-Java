package classes;

import java.util.List;

public interface ProdutoRepository {
    void salvar(Produto produto);
    Produto buscarPorId(int id);
    void atualizar(Produto produto);
    void deletar(int id);
    List<Produto> listarTodos();
}
