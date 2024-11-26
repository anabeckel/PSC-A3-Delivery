public class Alimento {
    private String descricao;
    private float precoUnitario;
    private Restaurante restaurante;

    public Alimento(String descricao, float precoUnitario, Restaurante restaurante) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.restaurante = restaurante;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }
}
