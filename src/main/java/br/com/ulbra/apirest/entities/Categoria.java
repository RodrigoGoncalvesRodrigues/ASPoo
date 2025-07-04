package br.com.ulbra.apirest.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCategoria;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {}

    public Categoria(Long id, List<Produto> produtos, String nomeCategoria) {
        this.id = id;
        this.produtos = produtos;
        this.nomeCategoria = nomeCategoria;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


}
