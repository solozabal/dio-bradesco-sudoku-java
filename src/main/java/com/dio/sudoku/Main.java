package com.dio.sudoku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();
        board.initializeBoard(args); // ignora args e sempre carrega um tabuleiro fixo embaralhado

        Scanner scanner = new Scanner(System.in);

        while (!board.isComplete()) {
            System.out.println("\n🧩 Jogo Sudoku:");
            board.printBoard();

            System.out.println("\n📌 Digite sua jogada no formato: linha coluna valor (ex: 0 1 5)");
            System.out.print("➤ Sua jogada: ");
            String input = scanner.nextLine().trim();

            String[] tokens = input.split("\\s+");
            if (tokens.length != 3) {
                System.out.println("❌ Entrada inválida. Tente novamente.");
                continue;
            }

            try {
                int row = Integer.parseInt(tokens[0]);
                int col = Integer.parseInt(tokens[1]);
                int value = Integer.parseInt(tokens[2]);

                if (row < 0 || row > 8 || col < 0 || col > 8 || value < 1 || value > 9) {
                    System.out.println("❌ Valores fora do intervalo permitido (0-8 para linha/coluna e 1-9 para valor).");
                    continue;
                }

                board.setCellValue(col, row, value);

            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Use apenas números.");
            }
        }

        System.out.println("\n🎉 Parabéns! Você completou o Sudoku!");
        board.printBoard();
        scanner.close();
    }
}
