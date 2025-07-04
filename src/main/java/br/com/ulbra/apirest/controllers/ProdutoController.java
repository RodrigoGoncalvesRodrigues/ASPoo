package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.dto.produtos.request.ProdutoRequest;
import br.com.ulbra.apirest.dto.produtos.response.ProdutoResponseDTO;
import br.com.ulbra.apirest.entities.Produto;
import br.com.ulbra.apirest.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoResponseDTO> getAllProdutos() {
        return this.produtoService.getAllProdutos();
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoRequest produtoRequest) {
        Produto produto = this.produtoService.createProduto(produtoRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = this.produtoService.updateProduto(id, produtoRequest);
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        this.produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
