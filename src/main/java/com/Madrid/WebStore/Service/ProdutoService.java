package com.Madrid.WebStore.Service;

import com.Madrid.WebStore.Classes.Categoria;
import com.Madrid.WebStore.Classes.Cliente;
import com.Madrid.WebStore.Classes.Produto;
import com.Madrid.WebStore.DTO.ProdutoDTO;
import com.Madrid.WebStore.Repositorios.CategoriaRepositorio;
import com.Madrid.WebStore.Repositorios.ClienteRepositorio;
import com.Madrid.WebStore.Repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    ProdutoRepositorio produtoRepositorio;

    ClienteRepositorio clienteRepositorio;

    CategoriaRepositorio categoriaRepositorio;

    public ProdutoService(ProdutoRepositorio produtoRepositorio, ClienteRepositorio clienteRepositorio, CategoriaRepositorio categoriaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    // Cadastrar Produto ou Atualizar
    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        // Busca a categoria correspondente ao ID
        Categoria categoria = categoriaRepositorio.findById(produtoDTO.getIdCategoria()).orElseThrow();

        // Converte o DTO em uma instância de Produto
        Produto produto = Produto.fromDTO(produtoDTO);

        // Associa a categoria ao produto
        produto.setCategoria(categoria);

        // Salva o produto no banco de dados
        produtoRepositorio.save(produto);
    }

    // Listar Todos os Produtos
    public List<ProdutoDTO> listarProdutos() {
        return produtoRepositorio.findAll().stream()
                .map(ProdutoDTO::converterDeProduto)
                .collect(Collectors.toList());
    }

    // Procurar Produto pelo Nome
    public List<ProdutoDTO> procurarProdutoPorNome(String nome) {
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

            // Salva as alterações no cliente após remover o produto do carrinho
            clienteRepositorio.save(cliente);

        }
    }

}
