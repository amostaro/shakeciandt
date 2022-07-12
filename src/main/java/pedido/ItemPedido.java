package pedido;

import produto.Shake;

public class ItemPedido {
    /** ATRIBUTOS */
    private Shake shake;
    private int quantidade;

    /** MÉTODOS */
    public ItemPedido(Shake shake, int quantidade) {
        this.shake = shake;
        this.quantidade = quantidade;
    }

    public Shake getShake() {
        return shake;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.shake + " / x" + this.quantidade;
    }
}
