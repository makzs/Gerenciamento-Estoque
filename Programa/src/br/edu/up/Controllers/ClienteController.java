package br.edu.up.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Endereco;

public class ClienteController {

    File ClientesBD = new File("C:\\Users\\autologon\\Desktop\\teste\\Gerenciamento-Estoque\\Programa\\Clientes.csv");
    public List<Cliente> listaClientes = new ArrayList<>();

    // Método para carregar os clientes do arquivo CSV para a listaClientes
    public void carregarClientesDoArquivo() {
        try {
            Scanner scanner = new Scanner(ClientesBD);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String cpf = partes[1];
                String nome = partes[2];
                int idade = Integer.parseInt(partes[3]);
                Endereco endereco = null;
                Cliente cliente = new Cliente(id, nome, cpf, idade, endereco);
                listaClientes.add(cliente);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    // metodo para auxiliar no cadastro de cliente (auto incremento de ID)
    public int retornarID(){
        int ultimoID = 0;

        try {
            Scanner leitor = new Scanner(ClientesBD);
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


    // adicionar cliente na lista e executa o metodo para salvar no arquivo csv
    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        salvarCliente();
    }


    // metodo para listar clientes
    public void listarClientes(){
        try { 

            Scanner leitor = new Scanner(ClientesBD);
            leitor.nextLine();


            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
                

            }

            leitor.close();
        } catch (FileNotFoundException x) {
            System.out.println("O arquivo" + ClientesBD + " nao foi encontrado pois " + x.getCause());
        }
    }

    // metodo para gravar cliente
    public void salvarCliente() {
        try {
            FileWriter ClienteBDgravar = new FileWriter(ClientesBD, false);
            PrintWriter gravador = new PrintWriter(ClienteBDgravar);

            gravador.println("ID | cpf | nome | idade | endereco");

            for (Cliente c : listaClientes) {
                String linhaCSV = c.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    // metodo para remover cliente da lista e do arquivo csv
    public void removerCliente(int idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.Id == idCliente) {
                listaClientes.remove(cliente);
                salvarCliente();
                listaClientes.clear();
                System.out.println("Cliente Removido com sucesso");
                break;
            }
            else{
                System.out.println("Cliente nao encontrado");
            }
        }
    
        
    }
    

}
