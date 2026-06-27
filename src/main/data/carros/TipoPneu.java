package main.data.carros;
import main.data.corridas.CondicoesMeteo;

public enum TipoPneu {
    
    SOFT("Macios", CondicoesMeteo.SECO),
    MEDIUM("Medios", CondicoesMeteo.SECO),
    HARD("Duros", CondicoesMeteo.SECO),
    INTER("Intermedios", CondicoesMeteo.MISTO),
    WET("Chuva", CondicoesMeteo.CHUVA);

    private final String descricao;
    private final CondicoesMeteo condIdeal;

    private TipoPneu(String descricao, CondicoesMeteo condIdeal) {
        this.descricao = descricao;
        this.condIdeal = condIdeal;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public CondicoesMeteo getCondicaoIdeal(){
        return this.condIdeal;
    }
    
    public boolean isAdequadoPara(CondicoesMeteo meteo){
        if (this.condIdeal == meteo) {
            return true;
        }

        else return false;
    }

    public double multiplicadorDeDesgaste(CondicoesMeteo meteo) {
    switch (this) {
        case SOFT:
            switch (meteo) {
                case SECO:  return 1.4;
                case MISTO: return 1.8;
                case CHUVA: return 3.5;
            }
            break;
        case MEDIUM:
            switch (meteo) {
                case SECO:  return 1.0;
                case MISTO: return 1.5;
                case CHUVA: return 3.0;
            }
            break;
        case HARD:
            switch (meteo) {
                case SECO:  return 0.8;
                case MISTO: return 1.3;
                case CHUVA: return 2.8;
            }
            break;
        case SLICK:
            switch (meteo) {
                case SECO:  return 1.0;
                case MISTO: return 1.5;
                case CHUVA: return 3.0;
            }
            break;
        case INTER:
            switch (meteo) {
                case SECO:  return 2.0;
                case MISTO: return 1.0;
                case CHUVA: return 1.5;
            }
            break;
        case WET:
            switch (meteo) {
                case SECO:  return 3.5;
                case MISTO: return 1.5;
                case CHUVA: return 1.0;
            }
            break;
        }
        return 1.0; // fallback defensivo
    }

    public double multiplicadorDeRitmo(CondicoesMeteo meteo) {
        switch (this) {
            case SOFT:
                switch (meteo) {
                    case SECO:  return 1.00;
                    case MISTO: return 1.12;
                    case CHUVA: return 1.35;
                }
                break;
            case MEDIUM:
                switch (meteo) {
                    case SECO:  return 1.01;
                    case MISTO: return 1.10;
                    case CHUVA: return 1.32;
                }
                break;
            case HARD:
                switch (meteo) {
                    case SECO:  return 1.02;
                    case MISTO: return 1.09;
                    case CHUVA: return 1.30;
                }
                break;
            case SLICK:
                switch (meteo) {
                    case SECO:  return 1.01;
                    case MISTO: return 1.10;
                    case CHUVA: return 1.30;
                }
                break;
            case INTER:
                switch (meteo) {
                    case SECO:  return 1.06;
                    case MISTO: return 1.00;
                    case CHUVA: return 1.08;
                }
                break;
            case WET:
                switch (meteo) {
                    case SECO:  return 1.18;
                    case MISTO: return 1.06;
                    case CHUVA: return 1.00;
                }
                break;
        }
        return 1.0;
    }

}
