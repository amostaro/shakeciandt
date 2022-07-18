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

        //TODO
        for (ItemPedido item : itens) {
            var tipoTamanhoMultiplicador = item.getShake().getTipoTamanho().multiplicador;
            var basePreco = cardapio.buscarPreco(item.getShake().getBase());

            if (item.getShake().getAdicionais() != null) {
                var adicionaisSetList = item.getShake().getAdicionais();
                for (Adicional adicional : adicionaisSetList) {
                    var adicionalPreco = (cardapio.buscarPreco(adicional)) * item.getQuantidade();
                    total += adicionalPreco;
                }
            }
            var itemPrecoTotal = ((tipoTamanhoMultiplicador * basePreco) * item.getQuantidade());
            total += itemPrecoTotal;
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
//            item.setQuantidade(item.getQuantidade() - 1); // regra 5

            int qtd = item.getQuantidade() -1;
            item.setQuantidade(qtd);

            //substitua o true por uma condição
            if (qtd > 0) {
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
