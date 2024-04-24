
package projeto.model;


public class Produtos {
    //atrebutos
    
    private int id;
    private String descricao;
    private double preco;
    private Integer qtd_estoque;
    private Fornecedores Fornecedor;

    
    // getters e setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Fornecedores getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(Fornecedores Fornecedor) {
        this.Fornecedor = Fornecedor;
    }
       
    
    
}
