package br.edu.up.Views;

import java.util.Scanner;

import br.edu.up.Models.*;
import br.edu.up.Controllers.*;

public class Menu {
    // controlers e leitor
    Scanner leitor = new Scanner(System.in);
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();
    EnderecoController enderecoController = new EnderecoController();
    FornecedorController fornecedorController = new FornecedorController();
    PedidoController pedidoController = new PedidoController();

    // MENU PRINCIPAL -----------------------------------
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
                MenuFornecedor();
                break;
            case 4:
                MenuProduto();
                break;
            case 5:
                MenuPedido();
                break;
            default:
                System.out.println("Opção Invalida!");
                break;
        }

    }
    // FIM MENU PRINCIPAL -----------------------------------

    // MENU PEDIDO -----------------------------------
    private void MenuPedido() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("    MENU PEDIDO  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedido");
        System.out.println("4. Sair");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // cadastrar Pedido
                Pedido novoPedido = pedirDadosPedido();
                pedidoController.adicionarPedido(novoPedido);
                MenuPedido();
                break;
            case 2:
                // remover Pedido
                pedidoController.carregarPedidoDoArquivo();
                System.out.println("Informe o ID do pedido que deseja remover:");
                int idInformado = leitor.nextInt();
                pedidoController.removerPedido(idInformado);
                MenuPedido();
                break;
            case 3:
                // listar Pedido
                pedidoController.carregarPedidoDoArquivo();
                pedidoController.listarPedido();
                MenuPedido();
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
    // FIM MENU PEDIDO -----------------------------------

    // MENU FORNECEDOR -----------------------------------
    private void MenuFornecedor() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("    MENU FORNECEDOR  ");
        System.out.println("---------------------------");
        System.out.println("1. Adicionar Fornecedor");
        System.out.println("2. Remover Fornecedor");
        System.out.println("3. Listar Fornecedor");
        System.out.println("4. Sair");
        System.out.println("---------------------------");
        System.out.println("Opção: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // cadastrar Fornecedor
                fornecedorController.carregarFornecedorDoArquivo();
                Fornecedor novoFornecedor = pedirDadosFornecedor();
                fornecedorController.adicionarFornecedor(novoFornecedor);
                fornecedorController.LimparFornecedores();
                MenuFornecedor();
                break;
            case 2:
                // remover Fornecedor
                fornecedorController.carregarFornecedorDoArquivo();
                System.out.println("Informe o ID do fornecedor que deseja remover:");
                int idInformado = leitor.nextInt();
                fornecedorController.removerFornecedor(idInformado);
                fornecedorController.LimparFornecedores();
                MenuFornecedor();
                break;
            case 3:
                // listar Fornecedor
                fornecedorController.carregarFornecedorDoArquivo();
                fornecedorController.listarFornecedor();
                MenuFornecedor();
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
    // FIM MENU FORNECEDOR -----------------------------------

    // MENU CLIENTE -----------------------------------
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
                clienteController.carregarClientesDoArquivo();
                Cliente novoCliente = pedirDadosCliente();
                clienteController.adicionarCliente(novoCliente);
                clienteController.LimparClientes();
                MenuCliente();
                break;
            case 2:
                // remover cliente
                clienteController.carregarClientesDoArquivo();
                System.out.println("Informe o ID do cliente que deseja remover:");
                int idInformado = leitor.nextInt();
                clienteController.removerCliente(idInformado);
                clienteController.LimparClientes();
                MenuCliente();
                break;
            case 3:
                // listar cliente
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
    // FIM MENU CLIENTE -----------------------------------

    // MENU PRODUTO -----------------------------------
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
                produtoController.carregarProdutosDoArquivo();
                Produto novoProduto = pedirDadosProduto();
                produtoController.adicionarProduto(novoProduto);
                produtoController.LimparProdutos();
                MenuProduto();
                break;
            case 2:
                produtoController.carregarProdutosDoArquivo();
                System.out.println("Informe o ID do produto que deseja remover: ");
                int idInformado = leitor.nextInt();
                produtoController.removerProduto(idInformado);
                produtoController.LimparProdutos();
                MenuProduto();
                break;
            case 3:
                produtoController.carregarProdutosDoArquivo();
                produtoController.listaProdutos();
                MenuProduto();
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }

    }
    // FIM MENU PRODUTO -----------------------------------

    // MENU ENDERECO -----------------------------------
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
                // remover endereco

                break;
            case 3:
                // buscar endereco
                System.out.println("Informe o clientId");
                int clienteId = leitor.nextInt();
                enderecoController.carregarEnderecosDoArquivo();
                var endereco = enderecoController.BuscarPorClienteId(clienteId);
                System.out.println(endereco);

                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }
        leitor.close();
    }
    // FIM MENU ENDERECO -----------------------------------

    // FUNÇÕES

    // função para cadastrar um cliente
    public Cliente pedirDadosCliente() {
        leitor.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = leitor.nextLine();
        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();
        System.out.println("Informe a idade:");
        int idade = leitor.nextInt();
        Endereco novoendereco = pedirDadosEndereco();

        int novoId = clienteController.retornarID();
        novoId++;

        novoendereco.setClienteId(novoId);
        enderecoController.adicionarEndereco(novoendereco);

        var clienteToAdd = new Cliente(novoId, nome, cpf, idade);
        return clienteToAdd;

    }

    // função para cadastrar um produto
    public Produto pedirDadosProduto() {
        leitor.nextLine();

        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();

        System.out.println("Informe o preço:");
        double preco = leitor.nextDouble();

        System.out.println("Informe a quantidade:");
        int quantidade = leitor.nextInt();
        leitor.nextLine();

        // pedir apenas o ID e o nome do fornecedor
        System.out.println("Informe o ID do fornecedor:");
        int fornecedorId = leitor.nextInt();
        leitor.nextLine();

        // Criar o novo produto com os dados coletados
        int novoId = produtoController.retornarID() + 1;
        Produto produtoToAdd = new Produto(novoId, nome, preco, quantidade, fornecedorId);

        return produtoToAdd;
    }

    // função para cadastrar um endereço
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

        int novoId = enderecoController.retornarID() + 1;
        var enderecoToAdd = new Endereco(novoId, rua, numero, complemento, cidade, estado, cep, clientId, fornecedorId);
        return enderecoToAdd;

    }

    // função para cadastrar um fornecedor
    public Fornecedor pedirDadosFornecedor() {
        int novoId = fornecedorController.retornarID();
        novoId++;

        leitor.nextLine();
        System.out.println("Informe o nome:");
        String nome = leitor.nextLine();
        System.out.println("Informe o telefone:");
        String telefone = leitor.nextLine();
        System.out.println("Informe o cnpj:");
        int cnpj = leitor.nextInt();
        Endereco novoendereco = pedirDadosEndereco();
        enderecoController.adicionarEndereco(novoendereco);

        Fornecedor fornecedorToAdd = new Fornecedor(novoId, nome, cnpj, telefone);
        return fornecedorToAdd;

    }

    // função para cadastrar um pedido
    public Pedido pedirDadosPedido() {
        int novoId = pedidoController.retornarID();
        novoId++;

        leitor.nextLine();

        System.out.println("Informe os dados do produto:");
        Produto novoProduto = pedirDadosProduto();
        produtoController.adicionarProduto(novoProduto);
        leitor.nextLine();

        System.out.println("Informe os dados do cliente:");
        Cliente novoCliente = pedirDadosCliente();
        clienteController.adicionarCliente(novoCliente);
        leitor.nextLine();

        System.out.println("Informe o método de pagamento:");
        String metododePagamento = leitor.nextLine();

        System.out.println("Informe a taxa de entrega:");
        int taxadeEntrega = leitor.nextInt();
        leitor.nextLine();
        
        System.out.println("Informe o status do pedido:");
        String status = leitor.nextLine();

        System.out.println("Adicione observacoes sobre o pedido:");
        String observacoes = leitor.nextLine();

        var pedidoToAdd = new Pedido(novoId, novoProduto, novoCliente, metododePagamento, taxadeEntrega, status, observacoes);
        return pedidoToAdd;

    }

    // FIM FUNÇÕES
}