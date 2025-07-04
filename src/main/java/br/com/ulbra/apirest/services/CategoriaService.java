package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.dto.users.CategoriaProdutoDTO;
import br.com.ulbra.apirest.dto.users.CategoriaResponseDTO;
import br.com.ulbra.apirest.entities.Categoria;
import br.com.ulbra.apirest.repositories.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria getCategoria(Long id) {
        return this.categoriaRepository.findById(id).orElseThrow();
    }

    public Page<CategoriaResponseDTO> getCategorias(Pageable pageable) {
        return this.categoriaRepository.findAll(pageable)
                .map(item -> new CategoriaResponseDTO(
                        item.getId(),
                        item.getNomeCategoria(),
                        item.getProdutos().stream().map(
                                produtos -> new CategoriaProdutoDTO(produtos.getNomeProduto(),produtos.getPrecoProduto())
                                ).toList()
                ));
    }

    public Categoria createCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        Categoria categoria = this.categoriaRepository.findById(id).orElseThrow();
        this.categoriaRepository.delete(categoria);
    }

}
