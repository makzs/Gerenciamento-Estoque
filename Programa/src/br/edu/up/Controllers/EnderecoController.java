package br.edu.up.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Endereco;

public class EnderecoController {

    File enderecoDB = new File(
            "C:\\Users\\autologon\\Desktop\\teste\\Gerenciamento-Estoque\\Programa\\Enderecos.csv");
    public List<Endereco> listaEnderecos = new ArrayList<>();

    public void carregarEnderecosDoArquivo() {
        try {
            Scanner scanner = new Scanner(enderecoDB);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String rua = partes[1];
                String numero = partes[2];
                String complemento = partes[3];
                String cidade = partes[4];
                String estado = partes[5];
                String cep = partes[6];
                int clienteId = Integer.parseInt(partes[7]);
                int fornecedorId = Integer.parseInt(partes[8]);
                Endereco endereco = new Endereco(id, rua, numero, complemento, cidade, estado, cep, clienteId,
                        fornecedorId);
                listaEnderecos.add(endereco);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public void adicionarEndereco(Endereco end) {
        listaEnderecos.add(end);
        salvarCliente();
    }

    public Endereco BuscarPorId(int idDoDono) {
        Endereco enderecoEncontrado = null;
        for (Endereco endereco : listaEnderecos) {
            if (endereco.getFornecedorId() == idDoDono) {
                enderecoEncontrado = endereco;
                break; // Se encontrado, podemos interromper o loop
            }
        }
        return enderecoEncontrado;
    }

    public void salvarCliente() {
        try {
            FileWriter ClienteBDgravar = new FileWriter(enderecoDB, true);
            PrintWriter gravador = new PrintWriter(ClienteBDgravar);

            for (var e : listaEnderecos) {
                String linhaCSV = e.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }
}
