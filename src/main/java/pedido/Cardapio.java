package pedido;

import ingredientes.Ingrediente;
import ingredientes.TipoTopping;

import java.util.TreeMap;

public class Cardapio {

    /** ATRIBUTOS */
    private TreeMap<Ingrediente,Double> precos;

    /** MÉTODOS */
    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco) throws Exception {
        //TODO - regra 1 cardápio
        if (preco <= 0) {
            throw new IllegalArgumentException("Preco invalido.");
        }
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco) throws Exception {
       //TODO - regra 2 cardápio
//        Double ingredienteBuscaPreco = precos.get(ingrediente);
        Double ingredienteBuscaPreco = this.buscarPreco(ingrediente);
        if (ingredienteBuscaPreco == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preco invalido.");
        }
        return precos.replace(ingrediente, buscarPreco(ingrediente), preco);
    }

    public boolean removerIngrediente(Ingrediente ingrediente) throws Exception {
        //TODO - regra 2 cardápio
//        Double ingredienteBuscaPreco = precos.get(ingrediente);
        Double ingredienteBuscaPreco = this.buscarPreco(ingrediente);
        if (ingredienteBuscaPreco == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return precos.remove(ingrediente, buscarPreco(ingrediente));
    }

    public Double buscarPreco(Ingrediente ingrediente) throws Exception {
        //TODO - regra 2 cardápio
        Double precoBusca = precos.get(ingrediente);
        if (precoBusca != null) {
            return precoBusca;
        }
        throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
