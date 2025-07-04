package br.com.ulbra.apirest.dto.users;

import java.util.ArrayList;
import java.util.List;

public class CategoriaResponseDTO {
    private String nomeCategoria;
    private List<CategoriaProdutoDTO> produtos = new ArrayList<>();

    public CategoriaResponseDTO(String nomeCategoria,List<CategoriaProdutoDTO> produtos) {
        this.nomeCategoria = nomeCategoria;
        this.produtos = produtos;

    }

    public List<CategoriaProdutoDTO> getProdutos() {return produtos;}

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


    public void setProdutos(List<CategoriaProdutoDTO> produtos) {
        this.produtos = produtos;
    }


}
