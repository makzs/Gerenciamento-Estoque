package br.edu.up.Models;

public class Pedido extends BaseEntity {

   private Produto produto;
   private Cliente cliente;
   private String metododePagamento;
   private int taxadeEntrega;
   private String status; /*se o pedido ta sendo encaminhado, esta sendo preparado */
   private String observacoes; /*alguma nota ou observacoes no pedido */
   

   public Pedido(int id, String metododePagamento, int taxadeEntrega, String status, String observacoes) {
      super.Id = id;
      this.metododePagamento = metododePagamento;
      this.taxadeEntrega = taxadeEntrega;
      this.status = status;
      this.observacoes = observacoes;
   }

   public Pedido(int id, Produto produto, Cliente cliente, String metododePagamento, int taxadeEntrega, String status,
         String observacoes) {
      super.Id = id;
      this.produto = produto;
      this.cliente = cliente;
      this.metododePagamento = metododePagamento;
      this.taxadeEntrega = taxadeEntrega;
      this.status = status;
      this.observacoes = observacoes;
   }

   // metodo para converter para csv
   public String toCSV(){
      return super.Id + ";" + produto + ";" + cliente + ";" + metododePagamento + ";" + taxadeEntrega + ";" + status + ";" + observacoes + ";";
   }

   public Produto getProduto() {
      return produto;
   }

   public void setProduto(Produto produto) {
      this.produto = produto;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
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
