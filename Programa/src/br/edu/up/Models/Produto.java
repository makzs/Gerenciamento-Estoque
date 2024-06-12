package br.edu.up.Models;

public class Produto extends BaseEntity {
    
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected Fornecedor fornecedor;
    
    public Produto(int id, String nome, double preco, int quantidade, Fornecedor Fornecedor) {
        super.Id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = Fornecedor;
    }

    public String toCSV(){
        return super.Id + ";" + nome + ";" + preco + ";" + quantidade + ";" + fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
