package main.data.carros;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe abstracta base de todos os carros do SimRacingPro.
 * Define os atributos e comportamento comuns a todas as categorias
 * (GT3, GT4, LMP2, Hypercar, TCR, ...). As subclasses devem fornecer
 * comportamento específico através dos métodos abstractos.
 */
public abstract class Carro implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    protected static final int NUMERO_PNEUS = 4;

    private String id;
    private String marca;
    private String modelo;
    private double consumoMedio;          // litros/volta
    private double desgasteMedioPneus;    // %/volta
    private EstadoCarro estado;
    private Pneu[] pneus;                 // 4 pneus
    private double combustivelAtual;      // litros
    private double capacidadeDeposito;    // litros

    // ---------- Construtores ----------

    public Carro() {
        // a implementar
        // Construtor por omissão. Inicializa estado=GARAGEM, pneus com 4
        // pneus slick novos, combustivel a 0 e os outros campos a valores
        // neutros. Útil para deserialização.
    }

    public Carro(String id, String marca, String modelo,
                    double consumoMedio, double desgasteMedioPneus,
                    double capacidadeDeposito) {
        // a implementar
        // Construtor principal. Carro arranca na GARAGEM, com 4 pneus
        // slick novos e depósito vazio. Validar argumentos (id não vazio,
        // consumos >= 0, capacidade > 0).
    }

    public Carro(Carro outro) {
        // a implementar
        // Construtor de cópia (deep copy): copia todos os atributos
        // primitivos e clona o array de pneus para evitar partilha de
        // referências.
    }

    // ---------- Getters ----------

    public String getId() { /* a implementar */ }
    public String getMarca() { /* a implementar */ }
    public String getModelo() { /* a implementar */ }
    public double getConsumoMedio() { /* a implementar */ }
    public double getDesgasteMedioPneus() { /* a implementar */ }
    public EstadoCarro getEstado() { /* a implementar */ }
    public double getCombustivelAtual() { /* a implementar */ }
    public double getCapacidadeDeposito() { /* a implementar */ }

    public Pneu[] getPneus() {
        // a implementar
        // Devolve uma CÓPIA do array de pneus (deep copy) para preservar
        // o encapsulamento — o exterior não deve poder mexer nos pneus
        // sem passar pelos métodos da classe.
    }

    // ---------- Setters ----------

    public void setEstado(EstadoCarro estado) {
        // a implementar
        // Define o estado do carro. Validar que não é null.
    }

    public void setCombustivelAtual(double combustivel) {
        // a implementar
        // Define o combustível, saturando entre 0 e capacidadeDeposito.
    }

    // (os outros setters dos atributos imutáveis em corrida — id, marca,
    // modelo — podem ser omitidos se quiseres torná-los efectivamente
    // finais após o construtor)

    // ---------- Operações sobre o carro ----------

    public void irParaPista() {
        // a implementar
        // Transição GARAGEM/BOX -> PISTA. Atira excepção se o carro
        // estiver AVARIADO ou já em PISTA.
    }

    public void chamarBoxes() {
        // a implementar
        // Transição PISTA -> BOX. Atira excepção se o carro não estiver
        // em pista.
    }

    public void recolher() {
        // a implementar
        // Transição BOX -> GARAGEM (fim de sessão).
    }

    public void trocarPneus(TipoPneu novoTipo) {
        // a implementar
        // Substitui os 4 pneus por pneus novos do tipo indicado. Só pode
        // ser feito em BOX ou GARAGEM (não em PISTA).
    }

    public void abastecer(double litros) {
        // a implementar
        // Acrescenta combustível ao depósito, saturando na capacidade
        // máxima. Só pode ser feito em BOX/GARAGEM. Validar litros >= 0.
    }

    public void fazerVolta(double multiplicadorDesgaste) {
        // a implementar
        // Simula uma volta: desconta consumoMedio ao combustível e
        // desgasta cada pneu pelo desgasteMedioPneus * multiplicador
        // (o multiplicador permite ao Carro/Corrida ajustar consoante
        // condições meteorológicas, ritmo, etc.). Se o combustível chegar
        // a 0, mudar estado para AVARIADO (ou similar).
    }

    // ---------- Métodos abstractos (comportamento por categoria) ----------

    public abstract String getCategoria();
    // a implementar nas subclasses: devolve o nome da categoria
    // ("GT3", "LMP2", etc.). Útil para apresentação e estatísticas.

    public abstract double calcularConsumoVolta(double multiplicadorRitmo);
    // a implementar nas subclasses: cálculo do consumo numa volta tendo
    // em conta o ritmo (push, normal, fuel saving) e características
    // específicas da categoria (hybrid recovery no Hypercar, etc.).

    // ---------- Object overrides ----------

    @Override
    public boolean equals(Object o) {
        // a implementar
        // Dois carros são iguais se tiverem o mesmo id (o id é o
        // identificador único do carro no sistema).
    }

    @Override
    public int hashCode() {
        // a implementar
        // Coerente com o equals — basear-se no id.
    }

    @Override
    public String toString() {
        // a implementar
        // Algo como "[GT3] BMW M4 #42 — PISTA — 62L — pneus SLICK".
    }

    @Override
    public abstract Carro clone();
    // a implementar nas subclasses: cada subclasse devolve uma instância
    // de si própria usando o seu construtor de cópia.
}