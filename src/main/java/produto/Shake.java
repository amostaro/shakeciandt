package produto;

import ingredientes.Adicional;
import ingredientes.Base;
import ingredientes.Fruta;
import ingredientes.Topping;

import java.util.List;
import java.util.Objects;

public class Shake {

    /** ATRIBUTOS */
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private List<Adicional> adicionais;
    private TipoTamanho  tipoTamanho;

    /** MÉTODOS */
    public Shake(Base base, Fruta fruta, Topping topping, List<Adicional> adicionais, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = adicionais;
        this.tipoTamanho = tipoTamanho;
    }

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;
    }

    public Base getBase() {
        return base;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Topping getTopping() {
        return topping;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    // adição equals and hashcode - REGRA 1
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shake shake = (Shake) o;
        return Objects.equals(base, shake.base) && Objects.equals(fruta, shake.fruta) && Objects.equals(topping, shake.topping) && Objects.equals(adicionais, shake.adicionais) && tipoTamanho == shake.tipoTamanho;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, fruta, topping, adicionais, tipoTamanho);
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
