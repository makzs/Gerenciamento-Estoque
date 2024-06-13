package br.edu.up.Models;

public class Cliente extends BaseEntity {
    private String nome;
    private String cpf;
    private int idade;
    private Endereco endereco;

    public Cliente(int id, String nome, String cpf, int idade) {
        super.Id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + super.Id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", endereco=" + (endereco != null ? endereco.toString() : "null") +
                '}';
    }


    // metodo para converter para csv
    public String toCSV(){
        return super.Id + ";" + cpf + ";" + nome + ";" + idade;
    }

    // construtor

    public Cliente(int id, String nome, String cpf, int idade, Endereco endereco) {
        super.Id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
