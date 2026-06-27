package main.data.carros;

/**
 * Carro de categoria GT3 — categoria GT de topo amadora/profissional.
 * Permite regulação de traction control, ABS e mapas de motor.
 */
public class GT3 extends Carro {

    private static final long serialVersionUID = 1L;

    private int tractionControl;  // 0-12
    private int abs;              // 0-12
    private int mapaMotor;        // 1-8

    public GT3() {
        // a implementar
        // Construtor por omissão.
    }

    public GT3(String id, String marca, String modelo,
               double consumoMedio, double desgasteMedioPneus,
               double capacidadeDeposito) {
        // a implementar
        // Construtor principal — TC, ABS e mapa de motor em valores médios.
    }

    public GT3(GT3 outro) {
        // a implementar
        // Construtor de cópia.
    }

    // ---------- Getters/Setters específicos ----------

    public int getTractionControl() { /* a implementar */ }
    public int getAbs() { /* a implementar */ }
    public int getMapaMotor() { /* a implementar */ }

    public void setTractionControl(int tc) {
        // a implementar
        // Validar 0 <= tc <= 12.
    }

    public void setAbs(int abs) {
        // a implementar
        // Validar 0 <= abs <= 12.
    }

    public void setMapaMotor(int mapa) {
        // a implementar
        // Validar 1 <= mapa <= 8. Mapa mais agressivo => mais consumo.
    }

    // ---------- Overrides ----------

    @Override
    public String getCategoria() {
        // a implementar
        // Devolve "GT3".
    }

    @Override
    public double calcularConsumoVolta(double multiplicadorRitmo) {
        // a implementar
        // Consumo base * multiplicador de ritmo * factor do mapa de
        // motor (mapas mais agressivos consomem mais).
    }

    @Override
    public GT3 clone() {
        // a implementar
        // return new GT3(this);
    }
}