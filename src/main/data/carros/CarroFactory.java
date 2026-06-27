package main.data.carros;

/**
 * Factory para criar carros de diferentes categorias sem que o código
 * cliente precise de conhecer as classes concretas. Permite acrescentar
 * novas categorias sem alterar o código que cria carros (basta adicionar
 * um novo case aqui e uma nova subclasse de Carro).
 */
public class CarroFactory {

    private CarroFactory() {
        // a implementar
        // Construtor privado — classe utilitária, não deve ser instanciada.
    }

    public static Carro criar(String categoria, String id, String marca,String modelo, double consumoMedio, double desgasteMedio, double capacidadeDeposito) {
        // a implementar
        // Switch na categoria ("GT3", "GT4", "LMP2", "TCR", "Hypercar")
        // e devolve uma nova instância da subclasse correspondente.
        // Para o Hypercar, capacidade de bateria pode ficar com valor
        // por omissão (ou criar um overload separado).
        // Atira IllegalArgumentException se a categoria for desconhecida.
    }

    public static Hypercar criarHypercar(String id, String marca, String modelo, double consumoMedio, double desgasteMedio, double capacidadeDeposito, double capacidadeBateria) {
        // a implementar
        // Overload específico para Hypercar (que tem parâmetro extra).
    }
}