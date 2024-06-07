package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Models.*;
import br.edu.up.Controllers.*;

public class Menu {
    Scanner leitor = new Scanner(System.in);
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();

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
                // menu endereço;
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

    public void MenuCliente(){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("---------------------------");
        System.out.println("    MENU CLIENTE  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Cliente");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // cadastrar cliente
                Cliente novoCliente = pedirDadosCliente();
                clienteController.adicionarCliente(novoCliente);
                break;
            case 2:
                // remover cliente
                break;
            case 3:
                clienteController.carregarClientesDoArquivo();
                clienteController.listarClientes();
                break;
            
            default:
                System.out.println("Opção invalida!");
                break;
        }


    }

    public Cliente pedirDadosCliente(){
        leitor.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = leitor.nextLine();
        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();
        System.out.println("Informe a idade:");
        int idade = leitor.nextInt();

        int novoId = clienteController.retornarID() + 1;
        var clienteToAdd = new Cliente(novoId, nome, cpf, idade, null);
        return clienteToAdd;

    }


    public void MenuProduto(){
        Scanner leitor = new Scanner(System.in);
        
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
                // remover produto
                break;
            case 3:
                produtoController.carregarProdutosDoArquivo();
                produtoController.listarClientes();
                break;
            
            default:
                System.out.println("Opção invalida!");
                break;
        }


    }

    public Cliente pedirDadosProduto(){
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
}