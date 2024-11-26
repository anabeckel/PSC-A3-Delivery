public class Cliente extends Pessoa {
    private String cpf;

    public Cliente(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public void realizarPedido(Pedido pedido) {
        System.out.println("Pedido realizado pelo cliente: " + getNome());
    }

    public String getCpf() {
        return cpf;
    }
}