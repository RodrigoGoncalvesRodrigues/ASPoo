package br.com.ulbra.apirest.dto.produtos.request;

public class ProdutoRequest {
    private Long categoriaId;
    private String nomeProduto;
    private int precoProduto;

    public ProdutoRequest(){}

    public ProdutoRequest(Long categoriaId, String nomeProduto, int precoProduto) {
        this.categoriaId = categoriaId;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(int precoProduto) {
        this.precoProduto = precoProduto;
    }
}
