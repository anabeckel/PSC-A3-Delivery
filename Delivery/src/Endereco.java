public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String cep;

    public Endereco(String rua, int numero, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }
}