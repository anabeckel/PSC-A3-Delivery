public class ItemPedido {
    private int quantidade;
    private Alimento alimento;

    public ItemPedido(int quantidade, Alimento alimento) {
        this.quantidade = quantidade;
        this.alimento = alimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Alimento getAlimento() {
        return alimento;
    }
}
