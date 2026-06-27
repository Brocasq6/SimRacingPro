package main.data.carros;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa um pneu de um carro.
 * Cada pneu tem um tipo (slick, intermédio ou wet), um desgaste acumulado
 * (em percentagem) e um contador de voltas que já fez.
 */
public class Pneu implements Serializable {

    private static final long serialVersionUID = 1L;

    // Limite a partir do qual se considera que o pneu está gasto.
    public static final double DESGASTE_MAXIMO = 100.0;

    private TipoPneu tipo;
    private double desgaste; // 0.0 a 100.0
    private int voltas;

    // ---------- Construtores ----------

    public Pneu() {
        // a implementar
        // Construtor por omissão: pneu slick novo, 0% de desgaste e 0 voltas.
    }

    public Pneu(TipoPneu tipo) {
        // a implementar
        // Cria um pneu novo do tipo indicado (desgaste 0, voltas 0).
    }

    public Pneu(TipoPneu tipo, double desgaste, int voltas) {
        // a implementar
        // Construtor completo. Validar que o desgaste está entre 0 e 100
        // e que voltas >= 0; caso contrário lançar IllegalArgumentException.
    }

    public Pneu(Pneu outro) {
        // a implementar
        // Construtor de cópia (deep copy) — usado pelo clone() e para
        // copiar pneus entre carros sem partilhar referências.
    }

    // ---------- Getters ----------

    public TipoPneu getTipo() {
        // a implementar
        // Devolve o tipo do pneu.
    }

    public double getDesgaste() {
        // a implementar
        // Devolve a percentagem de desgaste actual.
    }

    public int getVoltas() {
        // a implementar
        // Devolve o número de voltas que este pneu já fez.
    }

    // ---------- Setters ----------

    public void setTipo(TipoPneu tipo) {
        // a implementar
        // Define o tipo do pneu. Tipicamente usado ao montar pneus novos
        // de outro tipo (ex: trocar slicks por wets).
    }

    public void setDesgaste(double desgaste) {
        // a implementar
        // Define o desgaste, validando que está entre 0 e 100.
    }

    public void setVoltas(int voltas) {
        // a implementar
        // Define o contador de voltas, validando que é >= 0.
    }

    // ---------- Comportamento ----------

    public void desgastar(double percentagem) {
        // a implementar
        // Incrementa o desgaste pela percentagem dada (tipicamente o
        // desgaste médio por volta do carro, eventualmente ajustado pelas
        // condições meteorológicas). Saturar em 100 — não passar disso.
        // Também incrementa o contador de voltas em 1.
    }

    public boolean estaGasto() {
        // a implementar
        // Devolve true se o desgaste atingiu (ou ultrapassou) o limite
        // máximo, indicando que o pneu deve ser trocado.
    }

    public double percentagemRestante() {
        // a implementar
        // Devolve a "vida" restante do pneu (100 - desgaste). Útil para
        // estratégias do tipo "trocar pneus quando restar menos de X%".
    }

    public void reset(TipoPneu novoTipo) {
        // a implementar
        // Substitui o pneu por um novo do tipo indicado: desgaste a 0
        // e voltas a 0. Usado nas paragens nas boxes quando se montam
        // pneus novos.
    }

    // ---------- Object overrides ----------

    @Override
    public boolean equals(Object o) {
        // a implementar
        // Dois pneus são iguais se tiverem o mesmo tipo, desgaste e voltas.
    }

    @Override
    public int hashCode() {
        // a implementar
        // Coerente com o equals — usar Objects.hash(tipo, desgaste, voltas).
    }

    @Override
    public String toString() {
        // a implementar
        // Representação textual do tipo "Pneu{tipo=SLICK, desgaste=42.5%, voltas=12}".
    }

    @Override
    public Pneu clone() {
        // a implementar
        // Devolve uma cópia profunda usando o construtor de cópia.
    }
}