package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;
import produto.Shake;
import produto.TipoTamanho;

import java.util.ArrayList;
import java.util.Set;

public class Pedido{

    /** ATRIBUTOS */
    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;
    private Set<Adicional> adicionais;
    private Shake shake;

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

    public double calcularTotal(Cardapio cardapio) throws Exception{
        double total= 0;
        double total1= 0;
        double total2= 0;
        double total3= 0;
        double total4= 0;
        double total5= 0;
        double total6= 0;
        //TODO
        for (ItemPedido itemPedido : itens) {
            if (itemPedido.getShake().getTipoTamanho().equals(TipoTamanho.P)) {
                double base = (cardapio.buscarPreco(itemPedido.getShake().getBase()))*(TipoTamanho.P.multiplicador);
                if (itemPedido.getShake().getAdicionais().isEmpty()) {
                    total1 = base * itemPedido.getQuantidade();
                } else {
                    for ( Adicional adicional : itemPedido.getShake().getAdicionais()) {
                        double valorAdicional = cardapio.buscarPreco(adicional);
                        total2 = (base + valorAdicional)* itemPedido.getQuantidade();
                    }
                }
            } else if (itemPedido.getShake().getTipoTamanho().equals(TipoTamanho.M)) {
                double base = (cardapio.buscarPreco(itemPedido.getShake().getBase()))*(TipoTamanho.M.multiplicador);
                if (itemPedido.getShake().getAdicionais().isEmpty()) {
                    total3 = base * itemPedido.getQuantidade();
                } else {
                    for ( Adicional adicional : itemPedido.getShake().getAdicionais()) {
                        double valorAdicional = cardapio.buscarPreco(adicional);
                        total4 = (base + valorAdicional)* itemPedido.getQuantidade();
                    }
                }
            } else {
                double base = (cardapio.buscarPreco(itemPedido.getShake().getBase()))*(TipoTamanho.G.multiplicador);
                if (itemPedido.getShake().getAdicionais().isEmpty()) {
                    total5 = base * itemPedido.getQuantidade();
                } else {
                    for ( Adicional adicional : itemPedido.getShake().getAdicionais()) {
                        double valorAdicional = cardapio.buscarPreco(adicional);
                        total6 = (base + valorAdicional)* itemPedido.getQuantidade();
                    }
                }
            }
            total = total1 + total2 + total3 + total4 + total5 + total6;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) throws Exception {
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

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) throws Exception {

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
