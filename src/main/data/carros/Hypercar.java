package main.data.carros;

/**
 * Carro de categoria Hypercar (LMH/LMDh) — topo do endurance moderno.
 * É híbrido: além do motor de combustão tem um sistema eléctrico que
 * regenera energia em travagem e a entrega na aceleração.
 */
public class Hypercar extends Carro {

    private static final long serialVersionUID = 1L;

    private double energiaEletrica;       // kJ disponíveis
    private double capacidadeBateria;     // kJ máximo
    private double regeneracaoPorVolta;   // kJ recuperados por volta
    private int mapaMotor;                // 1-8
    private int mapaHibrido;              // 1-5 (quanto entrega na aceleração)

    public Hypercar() { /* a implementar */ }

    public Hypercar(String id, String marca, String modelo,
                    double consumoMedio, double desgasteMedioPneus,
                    double capacidadeDeposito, double capacidadeBateria) {
        // a implementar
    }

    public Hypercar(Hypercar outro) { /* a implementar */ }

    // ---------- Getters/Setters ----------

    public double getEnergiaEletrica() { /* a implementar */ }
    public double getCapacidadeBateria() { /* a implementar */ }
    public double getRegeneracaoPorVolta() { /* a implementar */ }
    public int getMapaMotor() { /* a implementar */ }
    public int getMapaHibrido() { /* a implementar */ }

    public void setMapaMotor(int m) {
        // a implementar — validar 1..8.
    }

    public void setMapaHibrido(int m) {
        // a implementar — validar 1..5.
    }

    // ---------- Comportamento híbrido ----------

    public void regenerarEnergia() {
        // a implementar
        // Acrescenta regeneracaoPorVolta à energia, saturando na
        // capacidade da bateria. Chamado no final de cada volta.
    }

    public double consumirEnergia(double pedido) {
        // a implementar
        // Tenta consumir 'pedido' kJ da bateria. Devolve quanto
        // realmente foi entregue (pode ser menos se a bateria estiver
        // quase vazia).
    }

    // ---------- Overrides ----------

    @Override
    public String getCategoria() {
        // a implementar — devolve "Hypercar".
    }

    @Override
    public double calcularConsumoVolta(double multiplicadorRitmo) {
        // a implementar
        // OVERRIDE com lógica híbrida: o consumo de combustível é
        // reduzido pela contribuição do sistema híbrido (mapaHibrido
        // mais alto => mais energia eléctrica entregue => menos
        // combustível gasto).
    }

    @Override
    public void fazerVolta(double multiplicadorDesgaste) {
        // a implementar
        // OVERRIDE: chama o super.fazerVolta() e depois invoca
        // regenerarEnergia() para repor energia recuperada na volta.
    }

    @Override
    public Hypercar clone() { /* a implementar */ }
}