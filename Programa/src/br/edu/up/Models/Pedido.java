package br.edu.up.Models;

public class Pedido extends BaseEntity {
   private int id;
   private String produto;
   private String cliente;

   public Pedido(int id, String produto, String cliente) {
      this.id = id;
      this.produto = produto;
      this.cliente = cliente;
   }

   public int getId() {
      return id;
   }

   public String getProduto() {
      return produto;
   }

   public String getCliente() {
      return cliente;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setProduto(String produto) {
      this.produto = produto;
   }

   public void setCliente(String cliente) {
      this.cliente = cliente;
   }
}
