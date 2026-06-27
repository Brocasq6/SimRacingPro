package main.data.corridas;

import java.io.Serializable;

/**
 * Condições meteorológicas de uma sessão/corrida.
 * Afecta o desgaste de pneus, o consumo de combustível e a escolha
 * do tipo de pneu apropriado.
 *
 * Cada constante traz consigo um multiplicador de desgaste e de
 * consumo, para que o {@link main.data.carros.Carro} possa calcular
 * o efeito da meteo na simulação sem precisar de conhecer cada caso.
 */
public enum CondicoesMeteo implements Serializable {

    SECO("Pista seca", 1.0, 1.0),
    MISTO("Pista mista (humid track)", 1.15, 1.05),
    CHUVA("Chuva (full wet)", 1.4, 1.10);

    private final String descricao;
    private final double multDesgaste;
    private final double multConsumo;

    CondicoesMeteo(String descricao, double multDesgaste, double multConsumo) {
        // a implementar
        // Atribui os três campos. Construtor de enum — chamado uma vez
        // por constante, no carregamento da classe.
    }

    // ---------- Getters ----------

    public String getDescricao() {
        // a implementar
        // Devolve a descrição legível (para mostrar nos menus).
    }

    public double getMultDesgaste() {
        // a implementar
        // Devolve o multiplicador de desgaste de pneus associado à
        // condição. Será multiplicado pelo desgasteMedioPneus do Carro
        // em cada volta.
    }

    public double getMultConsumo() {
        // a implementar
        // Devolve o multiplicador de consumo de combustível. Em wet
        // anda-se mais devagar mas com mais carga aerodinâmica e
        // patinagem, daí ser ligeiramente > 1.
    }

    // ---------- Comportamento ----------

    public main.data.carros.TipoPneu pneuRecomendado() {
        // a implementar
        // Devolve o tipo de pneu apropriado para esta condição:
        //   SECO  -> SLICK
        //   MISTO -> INTER
        //   CHUVA -> WET
        // Usado pelas estratégias automáticas e por ConfigFullWet.
    }

    public boolean exigeMudancaDe(main.data.carros.TipoPneu tipoMontado) {
        // a implementar
        // Devolve true se o tipo de pneu actualmente montado não é o
        // recomendado para esta meteo. Útil para a estratégia
        // "mudar para wets em chuva".
    }

    @Override
    public String toString() {
        // a implementar
        // Devolve a descrição (mais legível que o nome do enum).
    }
}