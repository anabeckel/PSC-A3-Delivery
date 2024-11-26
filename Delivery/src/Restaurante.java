import java.util.ArrayList;

public class Restaurante {
    private String nome;
    private String email;
    private String tipoComida;
    private ArrayList<Endereco> listaEndereco;
    private ArrayList<Telefone> listaTelefone;
    private ArrayList<Alimento> listaAlimentos;

    public Restaurante(String nome, String email, String tipoComida) {
        this.nome = nome;
        this.email = email;
        this.tipoComida = tipoComida;
        this.listaEndereco = new ArrayList<>();
        this.listaTelefone = new ArrayList<>();
        this.listaAlimentos = new ArrayList<>();
    }

    public void adicionarEndereco(Endereco endereco) {
        listaEndereco.add(endereco);
    }

    public void adicionarTelefone(Telefone telefone) {
        listaTelefone.add(telefone);
    }

    public void adicionarAlimento(Alimento alimento) {
        listaAlimentos.add(alimento);
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoComida() {
        return tipoComida;
    }
}
