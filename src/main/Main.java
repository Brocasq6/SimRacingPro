package main;

import main.menus.MenuPrincipal;

/**
 * Ponto de entrada da aplicação.
 *
 * Por agora só lança o menu principal. Mais tarde será aqui que se cria o
 * AppController (o estado global) e se passa para os menus, para que as opções
 * deixem de imprimir "por implementar" e passem a actuar sobre o domínio.
 */
public class Main {
    public static void main(String[] args) {
        new MenuPrincipal().executar();
    }
}