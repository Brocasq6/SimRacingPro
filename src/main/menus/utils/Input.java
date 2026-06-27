package main.menus.utils;

import java.util.Scanner;

/**
 * Leitura segura do teclado.
 *
 * Há UM único Scanner para todo o programa. System.in só deve ser lido por
 * um Scanner — abrir vários sobre o mesmo input causa bugs difíceis de apanhar.
 * Por isso esta classe é utilitária (construtor privado, métodos estáticos).
 */
public final class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private Input() { } // utilitário: não se instancia

    /** Lê um inteiro, repetindo enquanto o utilizador não escrever um número válido. */
    public static int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("  \u26A0  Valor inválido — escreve um número inteiro.");
            }
        }
    }

    /** Lê um número decimal. Aceita vírgula ou ponto (ex: 2,7 ou 2.7). */
    public static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("  \u26A0  Valor inválido — escreve um número (ex: 2.7).");
            }
        }
    }

    /** Lê uma linha de texto. */
    public static String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /** Pergunta sim/não e devolve true para sim. */
    public static boolean lerConfirmacao(String prompt) {
        while (true) {
            System.out.print(prompt + " (s/n): ");
            String r = scanner.nextLine().trim().toLowerCase();
            if (r.equals("s") || r.equals("sim")) return true;
            if (r.equals("n") || r.equals("nao") || r.equals("não")) return false;
            System.out.println("  \u26A0  Responde com 's' ou 'n'.");
        }
    }

    /** Espera que o utilizador prima Enter (para ler o ecrã antes de continuar). */
    public static void pausa() {
        System.out.print("\n  (Enter para continuar) ");
        scanner.nextLine();
    }
}