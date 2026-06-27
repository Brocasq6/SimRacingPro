package main.data.carros;

/**
 * Carro de categoria LMP2 — protótipo sem sistema híbrido.
 * Usa motor padrão Gibson V8 e a gestão estratégica passa muito
 * pelo fuel saving (depósitos grandes, stints longos).
 */
public class LMP2 extends Carro {

    private static final long serialVersionUID = 1L;

    private int mapaMotor;          // 1-8
    private double factorFuelSave;  // multiplicador quando em fuel saving

    public LMP2() { /* a implementar */ }

    public LMP2(String id, String marca, String modelo,
                double consumoMedio, double desgasteMedioPneus,
                double capacidadeDeposito) {
        // a implementar
    }

    public LMP2(LMP2 outro) { /* a implementar */ }

    public int getMapaMotor() { /* a implementar */ }
    public double getFactorFuelSave() { /* a implementar */ }

    public void setMapaMotor(int mapa) {
        // a implementar — validar 1..8.
    }

    public void setFactorFuelSave(double f) {
        // a implementar — validar 0.7 <= f <= 1.0 (não faz sentido
        // poupar mais que 30% do consumo).
    }

    @Override
    public String getCategoria() {
        // a implementar — devolve "LMP2".
    }

    @Override
    public double calcularConsumoVolta(double multiplicadorRitmo) {
        // a implementar — consumo base * ritmo * mapa motor * factor
        // fuel save (se aplicável).
    }

    @Override
    public LMP2 clone() { /* a implementar */ }
}