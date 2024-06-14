package br.edu.up.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Produto;

public class ProdutoController {

    String relativePath = "Programa\\Produtos.csv";
    String oldPath = "C:\\Users\\snack\\Desktop\\Gerenciamento-Estoque\\Programa\\Produtos.csv";

    File ProdutosBD = new File(relativePath);

    public List<Produto> listaProdutos = new ArrayList<>();
    FornecedorController fController = new FornecedorController();

    public void carregarProdutosDoArquivo() {
        try {
            Scanner scanner = new Scanner(ProdutosBD);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                double preco = Double.parseDouble(partes[2]);
                int quantidade = Integer.parseInt(partes[3]);
                int fornercedorId = Integer.parseInt(partes[4]);

                Produto produto = new Produto(id, nome, preco, quantidade, fornercedorId);
                listaProdutos.add(produto);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valor: " + e.getMessage());
        }
    }

    public int retornarID() {
        int ultimoID = 0;

        try {
            Scanner leitor = new Scanner(ProdutosBD);
            leitor.nextLine();

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

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        salvarProduto();
    }

    public void listaProdutos() {
        try {

            Scanner leitor = new Scanner(ProdutosBD);
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }

            leitor.close();
        } catch (FileNotFoundException x) {
            System.out.println("O arquivo" + ProdutosBD + " nao foi encontrado pois " + x.getCause());
        }
    }

    public void salvarProduto() {
        try {
            FileWriter ProdutoBDgravar = new FileWriter(ProdutosBD, false);
            PrintWriter gravador = new PrintWriter(ProdutoBDgravar);

            gravador.println("ID | nome | preço | quantidade | fornecedorId");

            for (Produto c : listaProdutos) {
                String linhaCSV = c.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    public void removerProduto(int idProduto) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == idProduto) {
                listaProdutos.remove(produto);
                salvarProduto();
                listaProdutos.clear();
                System.out.println("Produto removido com sucesso");
                break;
            } else {
                System.out.println("Produto não encontrado");
            }
        }

    }

    public void LimparProdutos() {
        listaProdutos.clear();
    }
}