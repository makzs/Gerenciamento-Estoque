package br.edu.up.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Pedido;

public class PedidoController {
    String relativePath = "Programa\\Pedidos.csv";
    File PedidosBD = new File(relativePath);
    public List<Pedido> listaPedidos = new ArrayList<>();

    /* ProdutoController produtoController = new ProdutoController();
    ClienteController clienteController = new ClienteController(); */

    // Método para carregar os pedidos do arquivo CSV para a listaPedidos
    public void carregarPedidoDoArquivo() {
        try {
            Scanner scanner = new Scanner(PedidosBD);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                System.out.println("Digite o ID do produto a ser carregado: ");
                int produtoId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o ID do cliente a ser carregado: ");
                int  clienteId = scanner.nextInt();
                scanner.nextLine();
                String metododePagamento = (partes[3]);
                int taxadeEntrega = Integer.parseInt(partes[4]);
                scanner.nextLine();
                String status = (partes[5]);
                String observacoes = (partes[6]);

                Pedido pedido = new Pedido(id, produtoId, clienteId, metododePagamento, taxadeEntrega, status, observacoes);
                listaPedidos.add(pedido);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

     // metodo para listar pedidos
     public void listarPedido(){
        try {
            Scanner leitor = new Scanner(PedidosBD);
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
            leitor.close();
        } catch (FileNotFoundException x) {
            System.out.println("O arquivo" + PedidosBD + " não foi encontrado pois " + x.getCause());
        }
    }

    // adicionar pedidos na lista e executa o metodo para salvar no arquivo csv
    public void adicionarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
        salvarPedido();
    }

    // metodo para gravar pedido
    public void salvarPedido() {
        try {
            FileWriter PedidoBDgravar = new FileWriter(PedidosBD, false);
            PrintWriter gravador = new PrintWriter(PedidoBDgravar);

            gravador.println("Id; produtoId; clienteId; metododePagamento; taxadeEntrega; status; observacoes;");

            for (Pedido c : listaPedidos) {
                String linhaCSV = c.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    // metodo para remover pedido da lista e do arquivo csv
    public void removerPedido(int idPedido) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.Id == idPedido) {
                listaPedidos.remove(pedido);
                salvarPedido();
                listaPedidos.clear();
                System.out.println("Pedido removido com sucesso");
                break;
            }
            else{
                System.out.println("Pedido não encontrado");
            }
        }
    }

    // metodo para auxiliar no cadastro de pedidos (auto incremento de ID)
    public int retornarID(){
        int ultimoID = 0;

        try {
            Scanner leitor = new Scanner(PedidosBD);
            leitor.nextLine(); // Ignora o cabeçalho

            String ultimaLinha = null;

            while (leitor.hasNextLine()) {
                ultimaLinha = leitor.nextLine();
            }
    
            if (ultimaLinha != null) {
                String[] partes = ultimaLinha.split(";");
                ultimoID = Integer.parseInt(partes[0]);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter ID para inteiro: " + e.getMessage());
        }

        return ultimoID;
    }
}
