package produto;

public enum TipoTamanho {
    //IMPLEMENTE A LOGICA DO ENUM
    // adição dos fatores de multiplicação - REGRA 2
    P(1),M(1.3),G(1.5);
    public final double multiplicador;

    TipoTamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
