package menus;

import main.menus.utils.Input;

/**
 * Corrida e simulação (secção 7 do enunciado).
 *
 * É aqui que se faz avançar a simulação volta-a-volta (a tal variável interna
 * de número da volta / tempo de corrida) e se aplicam as configurações de sessão
 * a todos os carros da equipa de uma só vez.
 */
public class MenuCorrida {

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Input.lerInt("Opção: ");
            switch (opcao) {
                case 1 -> configurarPista();
                case 2 -> avancarVolta();
                case 3 -> avancarVarias();
                case 4 -> estadoCorrida();
                case 5 -> aplicarConfigSessao();
                case 6 -> dispararEstrategia();
                case 0 -> { /* voltar */ }
                default -> System.out.println("  \u26A0  Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n---------- CORRIDA E SIMULAÇÃO ----------");
        System.out.println(" 1. Configurar pista / sessão");
        System.out.println(" 2. Avançar 1 volta");
        System.out.println(" 3. Avançar N voltas");
        System.out.println(" 4. Ver estado da corrida");
        System.out.println(" 5. Aplicar config. de sessão (Qual. / Race Start / SC / Full Wet)");
        System.out.println(" 6. Disparar estratégia / plano de stint");
        System.out.println(" 0. Voltar");
        System.out.println("------------------------------------------");
    }

    private void configurarPista() { 
        porImplementar("Configurar pista / sessão"); 
    }
    
    private void avancarVolta() { 
        porImplementar("Avançar 1 volta"); 
    }
    
    private void avancarVarias() { 
        porImplementar("Avançar N voltas"); 
    }
    
    private void estadoCorrida() { 
        porImplementar("Ver estado da corrida"); 
    }
    
    private void aplicarConfigSessao() { 
        porImplementar("Aplicar configuração de sessão"); 
    }
    
    private void dispararEstrategia() { 
        porImplementar("Disparar estratégia / plano de stint"); 
    }

    private void porImplementar(String accao) {
        System.out.println("\uD83D\uDD27 [Corrida] " + accao + " — por implementar.");
        Input.pausa();
    }
}