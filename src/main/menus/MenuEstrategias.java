package main.menus;

import main.menus.utils.Input;

/**
 * Estratégias, planos de stint e configurações de sessão (secções 4, 5, 6)
 * e ainda a geração automática de sugestões (req. 8.4).
 */
public class MenuEstrategias {

    public void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Input.lerInt("Opção: ");
            switch (opcao) {
                case 1 -> criarEstrategia();
                case 2 -> listarEstrategias();
                case 3 -> criarPlanoStint();
                case 4 -> listarPlanosStint();
                case 5 -> criarConfigSessao();
                case 6 -> listarConfigSessao();
                case 7 -> sugestoesAutomaticas();
                case 0 -> { /* voltar */ }
                default -> System.out.println("  \u26A0  Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n── ESTRATÉGIAS, STINTS E CONFIGURAÇÕES ──");
        System.out.println(" 1. Criar estratégia");
        System.out.println(" 2. Listar estratégias");
        System.out.println(" 3. Criar plano de stint");
        System.out.println(" 4. Listar planos de stint");
        System.out.println(" 5. Criar configuração de sessão");
        System.out.println(" 6. Listar configurações de sessão");
        System.out.println(" 7. Sugestões automáticas");
        System.out.println(" 0. Voltar");
    }

    private void criarEstrategia()      { porImplementar("Criar estratégia"); }
    private void listarEstrategias()    { porImplementar("Listar estratégias"); }
    private void criarPlanoStint()      { porImplementar("Criar plano de stint"); }
    private void listarPlanosStint()    { porImplementar("Listar planos de stint"); }
    private void criarConfigSessao()    { porImplementar("Criar configuração de sessão"); }
    private void listarConfigSessao()   { porImplementar("Listar configurações de sessão"); }
    private void sugestoesAutomaticas() { porImplementar("Sugestões automáticas"); }

    private void porImplementar(String accao) {
        System.out.println("\uD83D\uDD27 [Estratégias] " + accao + " — por implementar.");
        Input.pausa();
    }
}