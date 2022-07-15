package pedido;

import produto.Shake;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return quantidade == that.quantidade && Objects.equals(shake, that.shake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shake, quantidade);
    }

    @Override
    public String toString() {
        return this.shake + " / x" + this.quantidade;
    }
}
