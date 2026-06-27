package main.menus;

import main.menus.utils.Input;

/**
 * Gestão de equipas e pilotos (requisito 8.1).
 * Criar/listar equipas, registar pilotos e associar carros à equipa.
 * As acções de chefe (registar piloto, associar/remover) só deverão ficar
 * disponíveis quando o utilizador activo for ChefeEquipa — validação a fazer
 * mais tarde, quando o domínio existir.
 */
public class MenuEquipas {

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Input.lerInt("Opção: ");
            switch (opcao) {
                case 1 -> criarEquipa();
                case 2 -> listarEquipas();
                case 3 -> verDetalhes();
                case 4 -> registarPiloto();
                case 5 -> associarCarro();
                case 6 -> removerEntidade();
                case 0 -> { /* voltar ao menu principal */ }
                default -> System.out.println("  \u26A0  Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n──── GESTÃO DE EQUIPAS E PILOTOS ────");
        System.out.println(" 1. Criar equipa");
        System.out.println(" 2. Listar equipas");
        System.out.println(" 3. Ver detalhes de uma equipa");
        System.out.println(" 4. Registar piloto             (chefe)");
        System.out.println(" 5. Associar carro a equipa     (chefe)");
        System.out.println(" 6. Remover piloto / carro      (chefe)");
        System.out.println(" 0. Voltar");
    }

    private void criarEquipa() { 
        porImplementar("Criar equipa"); 
    }
    
    private void listarEquipas() { 
        porImplementar("Listar equipas"); 
    }
    
    private void verDetalhes() { 
        porImplementar("Ver detalhes de equipa"); 
    }
    
    private void registarPiloto() { 
        porImplementar("Registar piloto"); 
    }
    
    private void associarCarro() { 
        porImplementar("Associar carro a equipa"); 
    }
    
    private void removerEntidade() { 
        porImplementar("Remover piloto / carro"); 
    }


    private void porImplementar(String accao) {
        System.out.println("\uD83D\uDD27 [Equipas] " + accao + " — por implementar.");
        Input.pausa();
    }
}