package ingredientes;

public class Fruta  implements Adicional,Comparable<Ingrediente>{

     /** ATRIBUTOS */
     private TipoFruta tipoFruta;

     /** MÉTODOS */
     public Fruta(TipoFruta tipoFruta) {
          this.tipoFruta = tipoFruta;
     }

     public TipoFruta getTipoFruta(){
          return this.tipoFruta;
     }

     @Override
     public Enum obterTipo() {
          return this.tipoFruta;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof Fruta)) return false;

          Fruta fruta = (Fruta) o;

          return tipoFruta == fruta.tipoFruta;
     }

     @Override
     public int hashCode() {
          return tipoFruta.hashCode();
     }

     //É necessário consertar o compareTo, para imprimir na ordem correta.
     @Override
     public int compareTo(Ingrediente ingrediente) {
          return ingrediente.obterTipo().toString().compareToIgnoreCase(this.obterTipo().toString());
     }

     @Override
     public String toString() {
          return this.tipoFruta.toString();
     }



}
