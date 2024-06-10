package br.edu.up.Views;

import java.util.Random;
import java.util.Scanner;

import br.edu.up.Models.*;
import br.edu.up.Controllers.*;

public class Menu {
    Scanner leitor = new Scanner(System.in);
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();
    EnderecoController enderecoController = new EnderecoController();

    public void mostrar() {

        System.out.println("---------------------------");
        System.out.println("    MENU PRINCIPAL  ");
        System.out.println("---------------------------");

        System.out.println("1. Endereço");
        System.out.println("2. Cliente");
        System.out.println("3. Fornecedor");
        System.out.println("4. Produto");
        System.out.println("5. Pedido");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                MenuEndereco();
                break;
            case 2:
                MenuCliente();
                break;
            case 3:
                // menu fornecodr
                break;
            case 4:
                MenuProduto();
                break;
            case 5:
                // menu pedido
                break;
            default:
                System.out.println("Opção Invalida!");
                break;
        }

    }

    public void MenuCliente() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("    MENU CLIENTE  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Cliente");
        System.out.println("4. Sair");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // cadastrar cliente
                Cliente novoCliente = pedirDadosCliente();
                clienteController.adicionarCliente(novoCliente);
                MenuCliente();
                break;
            case 2:
                // remover cliente
                clienteController.carregarClientesDoArquivo();
                System.out.println("Informe o ID do cliente que deseja remover:");
                int idInformado = leitor.nextInt();
                clienteController.removerCliente(idInformado);
                MenuCliente();
                break;
            case 3:
                // listar cliente
                clienteController.carregarClientesDoArquivo();
                clienteController.listarClientes();
                MenuCliente();
                break;
            case 4:
                mostrar();
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
        leitor.close();
    }

    // função para cadastrar um cliente
    public Cliente pedirDadosCliente() {
        leitor.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = leitor.nextLine();
        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();
        System.out.println("Informe a idade:");
        int idade = leitor.nextInt();
        

        int novoId = clienteController.retornarID();
        novoId++;
        var clienteToAdd = new Cliente(novoId, nome, cpf, idade, null);
        return clienteToAdd;

    }

    public void MenuProduto() {

        System.out.println("---------------------------");
        System.out.println("    MENU PRODUTO  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Remover Produto");
        System.out.println("3. Listar Produtos");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                Produto novoProduto = pedirDadosProduto();
                produtoController.adicionarProduto(novoProduto);
                break;
            case 2:
                System.out.println("Informe o ID do produto que deseja remover: ");
                int idInformado = leitor.nextInt();
                removerProduto(idInformado);
                break;
            case 3:
                produtoController.carregarProdutosDoArquivo();
                produtoController.listaProdutos();
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }

    }

    public void MenuEndereco() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("    MENU Endereço  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Endereço");
        System.out.println("2. Remover Endereço");
        System.out.println("3. Listar Endereço");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // cadastrar end
                var novoEndereco = pedirDadosEndereco();
                enderecoController.adicionarEndereco(novoEndereco);
                break;
            case 2:
                // remover cliente
                System.out.println("Informe o ID que do cliente que deseja remover:");
                int idInformado = leitor.nextInt();
                clienteController.removerCliente(idInformado);
                break;
            case 3:
                // listar cliente
                clienteController.carregarClientesDoArquivo();
                clienteController.listarClientes();
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }
        leitor.close();
    }

    public Produto pedirDadosProduto() {
        leitor.nextLine();
        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();
        System.out.println("Informe o preço:");
        double preco = leitor.nextDouble();
        System.out.println("Informe o fornecedor:");
        String fornecedor = leitor.nextLine();

        int novoId = produtoController.retornarID() + 1;
        var produtotoAdd = new Produto(novoId, nome, preco, novoId, fornecedor);
        return produtotoAdd;

    }

    public Endereco pedirDadosEndereco() {
        leitor.nextLine();
        System.out.println("Informe a rua:");
        String rua = leitor.nextLine();
        System.out.println("Informe o numero:");
        String numero = leitor.nextLine();
        System.out.println("Informe o complemento:");
        String complemento = leitor.nextLine();
        System.out.println("Informe o cidade:");
        String cidade = leitor.nextLine();
        System.out.println("Informe o estado:");
        String estado = leitor.nextLine();
        System.out.println("Informe o cep:");
        String cep = leitor.nextLine();
        System.out.println("Informe o Id do cliente:");
        int clientId = leitor.nextInt();
        System.out.println("Informe o Id do fornecedor:");
        int fornecedorId = leitor.nextInt();

        // int novoId = produtoController.retornarID() + 1;
        var enderecoToAdd = new Endereco(2, rua, numero, complemento, cidade, estado, cep, clientId, fornecedorId);
        return enderecoToAdd;

    }

    public void removerProduto(int idProduto) {
        for (Produto produto : produtoController.listaProdutos) {
            if (produto.Id == idProduto) {
                removerProduto(idProduto);
            }
        }
    }
}