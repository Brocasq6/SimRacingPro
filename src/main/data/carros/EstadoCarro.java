package main.data.carros;

/**
 * Estado em que um carro se pode encontrar durante a sua operação.
 * Usado por {@link Carro} para controlar as transições permitidas
 * (ex: só se pode chamar às boxes um carro que esteja em PISTA).
 */
public enum EstadoCarro {
    
    GARAGEM("Na garagem"),
    PISTA("Em pista"),
    BOX("Nas boxes"),
    AVARIADO("Avariado");

    private final String descricao;

    EstadoCarro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}