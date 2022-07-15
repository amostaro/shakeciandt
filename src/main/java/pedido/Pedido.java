package pedido;

import java.util.ArrayList;

public class Pedido{

    /** ATRIBUTOS */
    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    /** MÉTODOS */
    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total= 0;
        //TODO
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        //TODO
        //precisa index pq ItemPedido é ArrayList
        int indexItem = itens.indexOf(itemPedidoAdicionado);

        if (indexItem < 0) {
            itens.add(itemPedidoAdicionado);
        } else {
            ItemPedido itemExistente = itens.get(indexItem);
            itemExistente.setQuantidade(itemExistente.getQuantidade() + itemPedidoAdicionado.getQuantidade());
            itens.set(indexItem, itemExistente);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {

        try {
            int indexItem = itens.indexOf(itemPedidoRemovido);
            ItemPedido item = itens.get(indexItem);
            item.setQuantidade(item.getQuantidade() - 1); // regra 5

            //substitua o true por uma condição
            if (!item.equals(0)) {
                //TODO
                itens.set(indexItem, item);
            } else {
                itens.remove(indexItem);
            }
            return true;

        } catch (Exception e) {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
