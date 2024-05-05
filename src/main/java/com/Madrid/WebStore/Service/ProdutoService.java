package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepositorio produtoRepositorio;

    ClienteRepositorio clienteRepositorio;

    public ProdutoService(ProdutoRepositorio produtoRepositorio, ClienteRepositorio clienteRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    // Cadastrar Produto ou Atualizar
    public void cadastrarProduto(Produto produto) {
        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<Produto> listarProdutos() {
        return produtoRepositorio.findAll();
    }

    // Listar Produtos pela Categoria
    public List<Produto> procurarProdutoPorCategoria(String categoria) {
        return produtoRepositorio.findByCategoria(categoria);
    }

    // Procurar Produto pelo Nome
    public List<Produto> procurarProdutoPorNome(String nome) {
        return produtoRepositorio.findByNomeProduto(nome);
    }

    // Deletar Produto Pelo Id
    public void deletarProduto(Integer id) {
        produtoRepositorio.deleteById(id);
    }

    // Ativar Produto
    public void ativarProduto(Integer id) {
        Produto produto = produtoRepositorio.findById(id).orElseThrow();
        produto.ativar(); // Chama o método ativar da classe Produto
        produtoRepositorio.save(produto);
    }

    // Inativar Produto e Remover de Todos os Carrinhos quando estiver Inativo
    public void inativarProduto(Integer produtoId) {
        Produto produto = produtoRepositorio.findById(produtoId).orElseThrow();

        // Chama o método desativar da classe Produto
        produto.desativar();
        produtoRepositorio.save(produto);

        // Remover o produto do carrinho de todos os clientes que o possuem
        List<Cliente> clientes = clienteRepositorio.findByProdutoId(produtoId);

        // Itera sobre a lista de clientes para encontrar o cliente atual
        for (Cliente cliente : clientes) {

            // Obtém o carrinho de compras do cliente atual
            List<Produto> carrinho = cliente.getProduto();

            // Cria um iterador para percorrer o carrinho de compras
            Iterator<Produto> iterator = carrinho.iterator();

            // Itera sobre os produtos no carrinho
            while (iterator.hasNext()) {

                // Obtém o próximo produto no carrinho
                Produto produtoNoCarrinho = iterator.next();

                // Verifica se o ID do produto no carrinho corresponde ao ID do produto que
                // estamos procurando
                if (produtoNoCarrinho.getId().equals(produtoId)) {
                    iterator.remove(); // Remove o produto do carrinho
                }
            }
        }

        clienteRepositorio.save(cliente); // Salva as alterações no cliente

    }

}
