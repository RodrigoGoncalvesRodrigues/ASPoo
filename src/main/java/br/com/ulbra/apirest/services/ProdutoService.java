package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.dto.produtos.request.ProdutoRequest;
import br.com.ulbra.apirest.dto.produtos.response.ProdutoResponseDTO;
import br.com.ulbra.apirest.dto.produtos.response.ProdutoCategoriaDTO;
import br.com.ulbra.apirest.entities.Categoria;
import br.com.ulbra.apirest.entities.Produto;
import br.com.ulbra.apirest.repositories.ProdutoRepository;
import br.com.ulbra.apirest.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoResponseDTO> getAllProdutos() {
        return this.produtoRepository.findAll()
                .stream()
                .map(item ->
                        new ProdutoResponseDTO(
                                item.getId(),
                                item.getNomeProduto(),
                                item.getPrecoProduto(),
                                new ProdutoCategoriaDTO(item.getCategoria().getNomeCategoria())
                        )).toList();
    }

    public Produto createProduto(ProdutoRequest produtoRequest) {
        Categoria categoria = categoriaRepository.findById(produtoRequest.getCategoriaId()).orElseThrow();

        Produto produto = new Produto();
        produto.setNomeProduto(produtoRequest.getNomeProduto());
        produto.setPrecoProduto(produtoRequest.getPrecoProduto());
        produto.setCategoria(categoria);


        return produtoRepository.save(produto);
    }
    public Produto updateProduto(Long id, ProdutoRequest request) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow();

        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow();

        boolean pertence = categoria.getProdutos().stream()
                .anyMatch(p -> p.getId().equals(id));

        if (pertence) {
            produto.setNomeProduto(request.getNomeProduto());
            produto.setPrecoProduto(request.getPrecoProduto());
            produto.setCategoria(categoria);
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não pertence à categoria informada.");
        }
    }
    public void deleteProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow();

        Categoria categoria = produto.getCategoria();


        boolean pertence = categoria.getProdutos().stream()
                .anyMatch(p -> p.getId().equals(id));

        if (pertence) {
            produtoRepository.delete(produto);
        } else {
            throw new RuntimeException("Produto não pertence à categoria associada.");
        }
    }


}
