package br.com.ulbra.apirest.dto.users;

public class CategoriaProdutoDTO {
    private String nomeProduto;
    private int precoProduto;

    public CategoriaProdutoDTO(String nomeProduto, int precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
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
