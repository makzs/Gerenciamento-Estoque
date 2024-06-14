package br.edu.up.Models;

public class Fornecedor extends BaseEntity {
   private String nome;
   private int cnpj;
   private String telefone;

   
   public Fornecedor (int id, String nome, int cnpj, String telefone) {
      super.Id = id;
      this.nome = nome;
      this.cnpj = cnpj;
      this.telefone = telefone;
   }
   
   private Endereco endereco;

   public Fornecedor(int id, String nome, int cnpj, String telefone, Endereco endereco) {
      super.Id = id;
      this.nome = nome;
      this.cnpj = cnpj;
      this.telefone = telefone;
      this.endereco = endereco;
   }

   public Fornecedor(int fornecedorId, String fornecedorNome) {
    //TODO Auto-generated constructor stub
}

// metodo para converter para csv
   public String toCSV(){
      return super.Id + ";" + nome + ";" + cnpj + ";" + telefone;
   }

   public String getNome() {
      return nome;
   }

   public int getCnpj() {
      return cnpj;
   }

   public String getTelefone() {
      return telefone;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setCnpj(int cnpj) {
      this.cnpj = cnpj;
   }

   public void setTelefone(String end) {
      this.telefone = end;
   }

   public Endereco getEndereco() {
      return endereco;
   }

   public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
   }

}