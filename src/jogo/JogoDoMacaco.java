package jogo;
import modelo.Macaco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoMacacos {
    private List<Macaco> macacos;
    private Scanner scanner;

    public JogoMacacos() {
        this.scanner = new Scanner(System.in);
        this.macacos = new ArrayList<>();
    }

    public void iniciar() {
        System.out.print("Quantos macacos irão jogar? ");
        int numeroDeMacacos = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        for (int i = 0; i < numeroDeMacacos; i++) {
            System.out.print("Nome do macaco " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            macacos.add(new Macaco(nome));
        }

        boolean jogoContinua = true;
        while (jogoContinua) {
            for (Macaco macaco : macacos) {
                if (macaco.procurarComida()) {
                    macaco.comer();
                    if (macaco.checarVitoria()) {
                        System.out.println("==================================================");
                        System.out.println("PARABÉNS! " + macaco.getNome() + " venceu o jogo!");
                        System.out.println("Bucho vencedor: " + macaco.getBucho());
                        System.out.println("==================================================");
                        jogoContinua = false;
                        break;
                    }
                }
            }

            // Mostrar o bucho de todos os macacos após todos jogarem
            if (jogoContinua) {
                System.out.println("--------------------------------------------------");
                System.out.println("Estado atual dos macacos:");
                for (Macaco m : macacos) {
                    System.out.println(m.getNome() + " - Bucho: " + m.getBucho());
                }
                System.out.println("--------------------------------------------------");

                // Esperar que o usuário pressione Enter para continuar
                System.out.println("Pressione Enter para a próxima rodada...");
                scanner.nextLine();
                limparConsole();
            }
        }

        scanner.close();
    }
    private void limparConsole() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

