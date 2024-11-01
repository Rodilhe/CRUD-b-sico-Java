package classes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;

    @Before
    public void setUp() {
        produtoRepository = mock(ProdutoRepository.class);  // Mock do ProdutoRepository
        ProdutoService.setRepository(produtoRepository);     // Configura o repositório mockado no singleton
        produtoService = ProdutoService.getInstance();       // Obtém a instância singleton
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto(1, "Produto A", 10.0);

        produtoService.adicionarProduto(produto);

        // Verifica se o método salvar foi chamado uma vez com o produto correto
        verify(produtoRepository, times(1)).salvar(produto);
    }

    @Test
    public void testBuscarProdutoPorId() {
        Produto produto = new Produto(2, "Produto B", 20.0);
        when(produtoRepository.buscarPorId(2)).thenReturn(produto);

        Produto encontrado = produtoService.buscarProdutoPorId(2);

        assertNotNull("O produto com ID 2 deve ser encontrado", encontrado);
        assertEquals("Produto B", encontrado.getNome());
        // Verifica se o método buscarPorId foi chamado uma vez com o ID correto
        verify(produtoRepository, times(1)).buscarPorId(2);
    }

    @Test
    public void testAtualizarProduto() {
        Produto produto = new Produto(3, "Produto C", 30.0);
        when(produtoRepository.buscarPorId(3)).thenReturn(produto);

        produtoService.atualizarProduto(3, "Produto C Atualizado", 35.0);

        assertEquals("Produto C Atualizado", produto.getNome());
        assertEquals(35.0, produto.getPreco(), 0.01);
        // Verifica se o método buscarPorId foi chamado uma vez e atualizar uma vez
        verify(produtoRepository, times(1)).buscarPorId(3);
        verify(produtoRepository, times(1)).atualizar(produto);
    }

    @Test
    public void testAtualizarProdutoInexistente() {
        when(produtoRepository.buscarPorId(999)).thenReturn(null);

        produtoService.atualizarProduto(999, "Produto X", 50.0);

        // Verifica se buscarPorId foi chamado, mas atualizar não foi chamado para um produto inexistente
        verify(produtoRepository, times(1)).buscarPorId(999);
        verify(produtoRepository, never()).atualizar(any(Produto.class));
    }

    @Test
    public void testDeletarProduto() {
        produtoService.deletarProduto(4);

        // Verifica se o método deletar foi chamado uma vez com o ID correto
        verify(produtoRepository, times(1)).deletar(4);
    }

    @Test
    public void testListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(5, "Produto E", 50.0));
        produtos.add(new Produto(6, "Produto F", 60.0));

        when(produtoRepository.listarTodos()).thenReturn(produtos);

        List<Produto> resultado = produtoService.listarProdutos();

        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(produtos));
        // Verifica se o método listarTodos foi chamado uma vez
        verify(produtoRepository, times(1)).listarTodos();
    }
}
