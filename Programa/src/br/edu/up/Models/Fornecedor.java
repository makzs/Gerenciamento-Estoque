package br.edu.up.Models;

public class Fornecedor extends BaseEntity {
   private String nome;
   private int cnpj;
   private String end;

   public Fornecedor (String nome, int cnpj, String end) {
      this.nome = nome;
      this.cnpj = cnpj;
      this.end = end;
   }

   public String getNome() {
      return nome;
   }

   public int getCnpj() {
      return cnpj;
   }

   public String getEnd() {
      return end;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setCnpj(int cnpj) {
      this.cnpj = cnpj;
   }

   public void setEnd(String end) {
      this.end = end;
   }

}