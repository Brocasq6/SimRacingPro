package main.menus;

import main.menus.utils.Input;

/**
 * Menu de entrada da aplicação. Encaminha para os sub-menus.
 *
 * Por agora as acções que ainda não têm domínio por trás imprimem apenas um
 * aviso "por implementar" — o esqueleto de navegação já funciona de ponta a ponta.
 * Quando o domínio existir, cada acção passa a chamar o controller respectivo.
 */

public class MenuPrincipal {

    public void executar() {
        System.out.println("\n========================================");
        System.out.println("        \uD83C\uDFC1  SIM RACING PRO  \uD83C\uDFC1");
        System.out.println("========================================");

        int opcao;
        do {
            mostrarMenu();
            opcao = Input.lerInt("Opção: ");
            switch (opcao) {
                case 1 -> sessaoUtilizador();
                case 2 -> new MenuEquipas().executar();
                case 3 -> new MenuCarros().executar();
                case 4 -> new MenuCorrida().executar();
                case 5 -> new MenuEstrategias().executar();
                case 6 -> estatisticas();
                case 7 -> guardarCarregar();
                case 0 -> System.out.println("\nA terminar. Até já! \uD83C\uDFCE\uFE0F");
                default -> System.out.println("  \u26A0  Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n──────── MENU PRINCIPAL ────────");
        System.out.println(" 1. Sessão / Utilizador");
        System.out.println(" 2. Gestão de Equipas e Pilotos");
        System.out.println(" 3. Gestão de Carros");
        System.out.println(" 4. Corrida e Simulação");
        System.out.println(" 5. Estratégias, Planos de Stint e Configurações");
        System.out.println(" 6. Estatísticas");
        System.out.println(" 7. Guardar / Carregar estado");
        System.out.println(" 0. Sair");
    }

    private void sessaoUtilizador() {
        System.out.println("\uD83D\uDD27 Entrar / criar utilizador — por implementar.");
        Input.pausa();
    }

    private void estatisticas() {
        System.out.println("\uD83D\uDD27 Estatísticas — por implementar.");
        Input.pausa();
    }

    private void guardarCarregar() {
        System.out.println("\uD83D\uDD27 Guardar / carregar estado — por implementar.");
        Input.pausa();
    }
}