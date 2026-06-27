package main.menus;

import main.menus.utils.Input;

/**
 * Gestão de carros (secção 2 do enunciado + operações individuais do req. 8.1).
 *
 * As operações sobre um carro (pista, boxes, setup, pneus, piloto) são o que o
 * enunciado destaca como essencial: sem elas a nota máxima cai para 10 valores.
 */
public class MenuCarros {

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Input.lerInt("Opção: ");
            switch (opcao) {
                case 1 -> criarCarro();
                case 2 -> listarCarros();
                case 3 -> verDetalhes();
                case 4 -> colocarEmPista();
                case 5 -> chamarBoxes();
                case 6 -> mudarSetup();
                case 7 -> mudarPneus();
                case 8 -> trocarPiloto();
                case 0 -> { /* voltar */ }
                default -> System.out.println("  \u26A0  Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n──────── GESTÃO DE CARROS ────────");
        System.out.println(" 1. Criar carro (GT3 / LMP2 / Hypercar / GT4 / TCR)");
        System.out.println(" 2. Listar carros");
        System.out.println(" 3. Ver detalhes de um carro");
        System.out.println("  — operar um carro —");
        System.out.println(" 4. Colocar em pista");
        System.out.println(" 5. Chamar às boxes");
        System.out.println(" 6. Mudar setup");
        System.out.println(" 7. Mudar pneus");
        System.out.println(" 8. Atribuir / trocar piloto");
        System.out.println(" 0. Voltar");
    }

    private void criarCarro() { 
        porImplementar("Criar carro"); 
    }
    
    private void listarCarros() { 
        porImplementar("Listar carros"); 
    }
    
    private void verDetalhes() { 
        porImplementar("Ver detalhes do carro"); 
    }
    
    private void colocarEmPista() { 
        porImplementar("Colocar em pista"); 
    }
    
    private void chamarBoxes() { 
        porImplementar("Chamar às boxes"); 
    }
    
    private void mudarSetup() { 
        porImplementar("Mudar setup"); 
    }
    
    private void mudarPneus() { 
        porImplementar("Mudar pneus"); 
    }
    
    private void trocarPiloto() { 
        porImplementar("Atribuir / trocar piloto"); 
    }

    private void porImplementar(String accao) {
        System.out.println("\uD83D\uDD27 [Carros] " + accao + " — por implementar.");
        Input.pausa();
    }
}