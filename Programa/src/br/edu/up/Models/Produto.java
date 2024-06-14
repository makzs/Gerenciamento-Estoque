package br.edu.up.Models;

public class Produto extends BaseEntity {

    protected int id;
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected Fornecedor fornecedor;
    protected int fornecedorId;

    public Produto(int id, String nome, double preco, int quantidade, int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedorId = fornecedorId;
    }

    public Produto(int id, String nome, double preco, int quantidade, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public String toCSV() {
        return id + ";" + nome + ";" + preco + ";" + quantidade + ";" + fornecedorId + ";";
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
