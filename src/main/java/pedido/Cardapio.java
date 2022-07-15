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
        //TODO
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco) throws Exception {
       //TODO
        return precos.replace(ingrediente, buscarPreco(ingrediente), preco);
    }

    public boolean removerIngrediente(Ingrediente ingrediente) throws Exception {
       //TODO
        return precos.remove(ingrediente, buscarPreco(ingrediente));
    }

    public Double buscarPreco(Ingrediente ingrediente) throws Exception {
        //TODO
        Double preco = precos.get(ingrediente);
        if (preco != null) {
            return preco;
        }
        throw new Exception("Preço deve ser diferente de nulo.");
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
