package br.com.ulbra.apirest.dto.produtos.response;

public class ProdutoResponseDTO {
    private long id;
    private String nomeProduto;
    private int precoProduto;
    private ProdutoCategoriaDTO categoria;

    public ProdutoResponseDTO() {}

    public ProdutoResponseDTO(Long id,String nomeProduto,int precoProduto ,ProdutoCategoriaDTO categoria) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categoria = categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public ProdutoCategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(ProdutoCategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public int getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(int precoProduto) {
        this.precoProduto = precoProduto;
    }
}
