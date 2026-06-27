package main.data.carros;

/**
 * Carro de categoria TCR — categoria de entrada baseada em turismos.
 * Motor de combustão, gestão de combustível previsível, sem
 * electrónica configurável complexa. O carro mais simples do sistema.
 */
public class TCR extends Carro {

    private static final long serialVersionUID = 1L;

    public TCR() { /* a implementar */ }

    public TCR(String id, String marca, String modelo,
                double consumoMedio, double desgasteMedioPneus,
                double capacidadeDeposito) {
        // a implementar
    }

    public TCR(TCR outro) { /* a implementar */ }

    @Override
    public String getCategoria() {
        // a implementar — devolve "TCR".
    }

    @Override
    public double calcularConsumoVolta(double multiplicadorRitmo) {
        // a implementar — simplesmente consumo base * ritmo,
        // sem mapas de motor nem sistemas adicionais.
    }

    @Override
    public TCR clone() { /* a implementar */ }
}