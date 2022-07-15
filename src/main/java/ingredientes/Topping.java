package ingredientes;

public class Topping implements Adicional,Comparable<Ingrediente> {

    /** ATRIBUTOS */
    private TipoTopping tipoTopping;

    /** MÉTODOS */
    public Topping(TipoTopping tipoTopping) {
        this.tipoTopping = tipoTopping;
    }

    public TipoTopping getTipoTopping(){
        return this.tipoTopping;
    }

    @Override
    public Enum obterTipo() {
        return this.tipoTopping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topping)) return false;

        Topping topping = (Topping) o;

        return tipoTopping == topping.tipoTopping;
    }

    @Override
    public int hashCode() {
        return tipoTopping.hashCode();
    }

    //É necessário consertar o compareTo, para imprimir na ordem correta.
    @Override
    public int compareTo(Ingrediente ingrediente) {
        return this.obterTipo().toString().compareToIgnoreCase(ingrediente.obterTipo().toString());
    }

    @Override
    public String toString() {
        return this.tipoTopping.toString();
    }


}
