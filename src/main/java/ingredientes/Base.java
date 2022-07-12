package ingredientes;

public class Base implements Ingrediente,Comparable<Ingrediente>{

    /** ATRIBUTOS */
    private TipoBase tipoBase;

    /** MÉTODOS */
    public Base(TipoBase tipoBase) {
        this.tipoBase = tipoBase;
    }

    public TipoBase getTipoBase(){
        return this.tipoBase;
    }

    @Override
    public Enum obterTipo() {
        return this.tipoBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;

        Base base = (Base) o;

        return tipoBase == base.tipoBase;
    }

    @Override
    public int hashCode() {
        return tipoBase.hashCode();
    }

    //É necessário consertar o compareTo, para imprimir na ordem correta.
    @Override
    public int compareTo(Ingrediente ingrediente) {
        return ingrediente.obterTipo().toString().compareTo(this.obterTipo().toString());
    }

    @Override
    public String toString() {
        return this.tipoBase.toString();
    }


}
