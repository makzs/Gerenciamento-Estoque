package br.edu.up.Models;

public class Endereco extends BaseEntity {

    public Endereco(int id, String rua, String numero, String complemento, String cidade, String estado, String cep,
            int clienteId, int fornecedorId) {
        super.Id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.ClienteId = clienteId;
        this.FornecedorId = fornecedorId;
    }

    private String rua;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private int ClienteId;
    private int FornecedorId;

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int clienteId) {
        ClienteId = clienteId;
    }

    public int getFornecedorId() {
        return FornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        FornecedorId = fornecedorId;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String toCSV() {
        return super.Id + ";" + rua + ";" + numero + ";" + complemento + ";" + cidade + ";" + estado + ";" + cep + ";"
                + ClienteId + ";"
                + FornecedorId;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
