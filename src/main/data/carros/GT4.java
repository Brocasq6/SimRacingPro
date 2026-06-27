package main.data.carros;

/**
 * Carro de categoria GT4 — categoria GT mais acessível.
 * Versão mais simples dos GT3: tem TC e ABS mas não mapas de motor
 * configuráveis. Pneus desgastam menos por terem ritmo inferior.
 */
public class GT4 extends Carro {

    private static final long serialVersionUID = 1L;

    private int tractionControl;
    private int abs;

    public GT4() { /* a implementar */ }

    public GT4(String id, String marca, String modelo,
               double consumoMedio, double desgasteMedioPneus,
               double capacidadeDeposito) {
        // a implementar
    }

    public GT4(GT4 outro) { /* a implementar */ }

    public int getTractionControl() { /* a implementar */ }
    public int getAbs() { /* a implementar */ }

    public void setTractionControl(int tc) {
        // a implementar — validar 0..12.
    }

    public void setAbs(int abs) {
        // a implementar — validar 0..12.
    }

    @Override
    public String getCategoria() {
        // a implementar — devolve "GT4".
    }

    @Override
    public double calcularConsumoVolta(double multiplicadorRitmo) {
        // a implementar — consumo base * ritmo. Mais previsível que o GT3.
    }

    @Override
    public GT4 clone() { /* a implementar */ }
}