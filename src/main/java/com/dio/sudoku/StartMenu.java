package com.dio.sudoku;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎮 Bem-vindo ao Sudoku DIO!");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1 - Terminal");
        System.out.println("2 - Interface Gráfica (GUI)");
        System.out.print("➤ Sua escolha: ");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                Main.main(new String[]{}); // Chama o modo terminal
                break;
            case "2":
                SudokuGUI.main(new String[]{}); // Chama o modo gráfico
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }

        scanner.close();
    }
}
