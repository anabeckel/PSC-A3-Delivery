import java.util.ArrayList;

public class Pedido {
    private String formaPagamento;
    private Cliente cliente;
    private Restaurante restaurante;
    private ArrayList<ItemPedido> listaItens;

    public Pedido(String formaPagamento, Cliente cliente, Restaurante restaurante) {
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.listaItens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        listaItens.add(item);
    }

    public float calcularPrecoTotal() {
        float precoTotal = 0;
        for (ItemPedido item : listaItens) {
            precoTotal += item.getQuantidade() * item.getAlimento().getPrecoUnitario();
        }
        return precoTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
