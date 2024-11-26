import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private String email;
    private ArrayList<Endereco> listaEndereco;
    private ArrayList<Telefone> listaTelefone;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.listaEndereco = new ArrayList<>();
        this.listaTelefone = new ArrayList<>();
    }

    public void adicionarEndereco(Endereco endereco) {
        listaEndereco.add(endereco);
    }

    public void adicionarTelefone(Telefone telefone) {
        listaTelefone.add(telefone);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}