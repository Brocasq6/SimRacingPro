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

    public Carro(String id, String marca, String modelo,double consumoMedio, double desgasteMedioPneus,double capacidadeDeposito) {

    }

    public Carro(Carro outro) {
        this.id = outro.id;
        this.marca = outro.marca;
        this.consumoMedio = outro.consumoMedio;
        this.desgasteMedioPneus = outro.desgasteMedioPneus;
        this.estado = outro.estado;
        this.combustivelAtual = outro.combustivelAtual;
        this.capacidadeDeposito = outro.capacidadeDeposito;
    }

    // ---------- Getters ----------

    public String getId() {
        return this.id;
    }
    
    public String getMarca() {
        return this.marca;
    }
    
    public String getModelo() {
        return this.modelo;
    }
    
    public double getConsumoMedio() {
        return this.consumoMedio;
    }
    
    public double getDesgasteMedioPneus() {
        return this.desgasteMedioPneus;
    }
    
    public EstadoCarro getEstado() {
        return this.estado;
    }
    
    public double getCombustivelAtual() {
        return this.combustivelAtual;
    }
    
    public double getCapacidadeDeposito() { 
        return this.capacidadeDeposito;
    }


    public Pneu[] getPneus() {
        return this.pneus;
    }

    // ---------- Setters ----------

    public void setEstado(EstadoCarro estado) {
        this.estado = estado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public void setDesgasteMedioPneus(double desgasteMedioPneus) {
        this.desgasteMedioPneus = desgasteMedioPneus;
    }

    public void setCombustivelAtual(double combustivel) {
        this.combustivelAtual = combustivel;
    }

    public void setPneus(Pneu[] pneus) {
        this.pneus = pneus;
    }

    public void setCapacidadeDeposito(double capacidadeDeposito) {
        this.capacidadeDeposito = capacidadeDeposito;
    }

    // ---------- Operações sobre o carro ----------

    public void irParaPista() {
        switch (this.estado) {
            case GARAGEM:
                throw new IllegalStateException("Não é possível ir para a pista a partir da garagem.");
            case BOX:
                throw new IllegalStateException("Não é possível ir para a pista a partir dos boxes.");
            case PISTA:
                throw new IllegalStateException("O carro já está na pista.");
            case AVARIADO:
                throw new IllegalStateException("Não é possível ir para a pista com o carro avariado.");
            default:
                this.estado = EstadoCarro.PISTA;
        }
    }

    public void chamarBoxes() {
        switch(this.estado) {
            case GARAGEM:
                throw new IllegalStateException("Não é possível chamar os boxes a partir da garagem.");
            case BOX:
                throw new IllegalStateException("O carro já está nos boxes.");
            case PISTA:
                this.estado = EstadoCarro.BOX;
                break;
            case AVARIADO:
                this.estado = EstadoCarro.BOX;
                break;
            default:
                throw new IllegalStateException("Estado desconhecido: " + this.estado);
        }
    }

    public void recolher() {
        switch(this.estado) {
            case GARAGEM:
                throw new IllegalStateException("O carro já está na garagem.");
            case BOX:
                this.estado = EstadoCarro.GARAGEM;
                break;
            case PISTA:
                throw new IllegalStateException("Não é possível recolher o carro da pista diretamente para a garagem.");
            case AVARIADO:
                this.estado = EstadoCarro.GARAGEM;
                break;
            default:
                throw new IllegalStateException("Estado desconhecido: " + this.estado);
        }
    }

    public void trocarPneus(TipoPneu novoTipo) {
        for (int i = 0; i < NUMERO_PNEUS; i++) {
            this.pneus[i] = new Pneu(novoTipo);
        }
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