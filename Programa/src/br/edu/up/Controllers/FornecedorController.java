package br.edu.up.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Fornecedor;

public class FornecedorController {
    String relativePath = "Programa\\Fornecedores.csv";
    File FornecedoresBD = new File(relativePath);
    public List<Fornecedor> listaFornecedores = new ArrayList<>();

    // Método para carregar os fornecedores do arquivo CSV para a listaFornecedores
    public void carregarFornecedorDoArquivo() {
        try {
            Scanner scanner = new Scanner(FornecedoresBD);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int cnpj = Integer.parseInt(partes[2]);
                String telefone = (partes[3]);
                Fornecedor fornecedor = new Fornecedor(id, nome, cnpj, telefone);
                System.out.println(fornecedor.getTelefone());
                listaFornecedores.add(fornecedor);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

     // metodo para listar fornecedores
     public void listarFornecedor(){
        try {
            Scanner leitor = new Scanner(FornecedoresBD);
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
            leitor.close();
        } catch (FileNotFoundException x) {
            System.out.println("O arquivo" + FornecedoresBD + " nao foi encontrado pois " + x.getCause());
        }
    }

    // adicionar fornecedor na lista e executa o metodo para salvar no arquivo csv
    public void adicionarFornecedor(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
        salvarFornecedor();
    }

    // metodo para gravar fornecedor
    public void salvarFornecedor() {
        try {
            FileWriter FornecedorBDgravar = new FileWriter(FornecedoresBD, false);
            PrintWriter gravador = new PrintWriter(FornecedorBDgravar);

            gravador.println("Id | nome | cnpj | telefone |");

            for (Fornecedor c : listaFornecedores) {
                String linhaCSV = c.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    // metodo para remover fornecedor da lista e do arquivo csv
    public void removerFornecedor(int idFornecedor) {
        for (Fornecedor fornecedor : listaFornecedores) {
            if (fornecedor.Id == idFornecedor) {
                listaFornecedores.remove(fornecedor);
                salvarFornecedor();
                listaFornecedores.clear();
                System.out.println("Fornecedor removido com sucesso");
                break;
            }
            else{
                System.out.println("Fornecedor não encontrado");
            }
        }
    }

    // metodo para auxiliar no cadastro de fornecedores (auto incremento de ID)
    public int retornarID(){
        int ultimoID = 0;

        try {
            Scanner leitor = new Scanner(FornecedoresBD);
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

    public void LimparFornecedores()
    {
        listaFornecedores.clear();
    }
}
