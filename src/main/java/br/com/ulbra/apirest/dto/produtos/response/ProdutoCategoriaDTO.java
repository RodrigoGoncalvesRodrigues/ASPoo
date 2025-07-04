package br.com.ulbra.apirest.dto.produtos.response;

public class ProdutoCategoriaDTO {
    private String nomeCategoria;

    public ProdutoCategoriaDTO(){}

    public ProdutoCategoriaDTO(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
