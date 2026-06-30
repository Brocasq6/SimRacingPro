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
    private static final int standardTC = 6;   // valor neutro
    private static final int standardABS = 6;  // valor neutro
    private static final int standardMap = 4;  // valor neutro

    public GT3() {
        super();
        this.tractionControl = standardTC;
        this.abs = standardABS;              
        this.mapaMotor = standardMap;        
    }

    public GT3(String id, String marca, String modelo, double consumoMedio, double desgasteMedioPneus, double capacidadeDeposito) {
        super(id, marca, modelo, consumoMedio, desgasteMedioPneus, capacidadeDeposito);
        this.tractionControl = standardTC;
        this.abs = standardABS;              
        this.mapaMotor = standardMap;        
    }

    public GT3(GT3 outro) {
        super(outro);
        this.tractionControl = outro.tractionControl;
        this.abs = outro.abs;
        this.mapaMotor = outro.mapaMotor;
    }

    // ---------- Getters/Setters específicos ----------

    public int getTractionControl() {
        return this.tractionControl;
    }
    public int getAbs() { return this.abs; }
    public int getMapaMotor() { return this.mapaMotor; }

    public void setTractionControl(int tc) {
        this.tractionControl = tc;
        if (tc < 0) this.tractionControl = 0;
        if (tc > 12) this.tractionControl = 12;
    }

    public void setAbs(int abs) {
        this.abs = abs;
        if (abs < 0) this.abs = 0;
        if (abs > 12) this.abs = 12;
    }

    public void setMapaMotor(int mapa) {
        this.mapaMotor = mapa;
        if (mapa < 1) this.mapaMotor = 1;
        if (mapa > 8) this.mapaMotor = 8;
    }

    // ---------- Overrides ----------

    @Override
    public String getCategoria() {
        return "GT3";
    }

    public static double calcularConsumoPorVolta(double distanciaVoltaKm, double consumoAos100) {
        if (distanciaVoltaKm <= 0 || consumoAos100 <= 0) {
            throw new IllegalArgumentException("Os valores de entrada devem ser maiores que zero.");
        }
        return (distanciaVoltaKm / 100.0) * consumoAos100;
    }

    @Override
    public GT3 clone() {
        return new GT3(this);
    }
}