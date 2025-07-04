package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.dto.users.CategoriaResponseDTO;
import br.com.ulbra.apirest.entities.Categoria;
import br.com.ulbra.apirest.services.CategoriaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<Page<CategoriaResponseDTO>> getCategorias(Pageable pageable) {
        return ResponseEntity.ok(this.categoriaService.getCategorias(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoriaService.getCategoria(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).body(this.categoriaService.createCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        this.categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
