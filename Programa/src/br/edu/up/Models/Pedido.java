package br.edu.up.Models;

public class Pedido extends BaseEntity {

   
   private int id; /* Identificador da entrega */
   private String produto;
   private String cliente;
   private String metododePagamento;
   private int taxadeEntrega;
   private String status; /*se o pedido ta sendo encaminhado, esta sendo preparado */
   private String observacoes; /*alguma nota ou observacoes no pedido */

   public Pedido(int id, String produto, String cliente) {
      this.id = id;
      this.produto = produto;
      this.cliente = cliente;
   }

   public Pedido(String metododePagamento, int taxadeEntrega, String status, String observacoes) {
      this.metododePagamento = metododePagamento;
      this.taxadeEntrega = taxadeEntrega;
      this.status = status;
      this.observacoes = observacoes;
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

   public String getMetododePagamento() {
      return metododePagamento;
   }

   public void setMetododePagamento(String metododePagamento) {
      this.metododePagamento = metododePagamento;
   }

   public int getTaxadeEntrega() {
      return taxadeEntrega;
   }

   public void setTaxadeEntrega(int taxadeEntrega) {
      this.taxadeEntrega = taxadeEntrega;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getObservacoes() {
      return observacoes;
   }

   public void setObservacoes(String observacoes) {
      this.observacoes = observacoes;
   }

   

}
