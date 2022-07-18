package pedido;

import ingredientes.Ingrediente;

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
            throw new IllegalArgumentException("Preco inválido");
        }
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco) throws Exception {
       //TODO - regra 2 cardápio
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return precos.replace(ingrediente, buscarPreco(ingrediente), preco);
    }

    public boolean removerIngrediente(Ingrediente ingrediente) throws Exception {
        //TODO - regra 2 cardápio
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return precos.remove(ingrediente, buscarPreco(ingrediente));
    }

    public Double buscarPreco(Ingrediente ingrediente) throws Exception {
        //TODO - regra 2 cardápio
        Double preco = precos.get(ingrediente);
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return preco;
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
