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
        switch(expression) {
            case x:
                // code block
                break;
            case y:
                // code block
                break;
            default:
                // code block
        }
    }

    public double multiplicadorDeDesgaste(CondicoesMeteo meteo){
        // funcao que dependendo do tipo de peneu selecionado aplica um 
        // nivel de desgaste aos mesmos
    }

    public double multiplicadorDeRitmo(){
        // Multiplicador a aplicar ao tempo de volta base do carro,
        // em função das condições da pista.
    }
}
