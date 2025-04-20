package com.dio.sudoku;

import java.util.*;

public class SudokuBoard {
    private Cell[][] board = new Cell[9][9];

    public void initializeBoard(String[] args) {
        int[][] baseBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Embaralha valores não nulos de forma aleatória (mantém a mesma estrutura)
        List<Integer> valuesToShuffle = new ArrayList<>();
        for (int[] row : baseBoard)
            for (int val : row)
                if (val != 0)
                    valuesToShuffle.add(val);

        Collections.shuffle(valuesToShuffle);
        Iterator<Integer> shuffled = valuesToShuffle.iterator();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (baseBoard[i][j] != 0) {
                    board[i][j] = new Cell(shuffled.next(), true);
                } else {
                    board[i][j] = new Cell(0, false);
                }
            }
        }
    }

    public void printBoard() {
        System.out.println("\n   A B C   D E F   G H I");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("  +-------+-------+-------+");
            System.out.print(i + " |");
            for (int j = 0; j < 9; j++) {
                int val = board[i][j].getValue();
                System.out.print((val == 0 ? "." : val) + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println("  +-------+-------+-------+");
    }

    public boolean setCellValue(int x, int y, int value) {
        if (board[y][x].isFixed()) {
            System.out.println("❌ Célula fixa. Não pode ser alterada.");
            return false;
        }

        String validationError = getValidationError(x, y, value);
        if (validationError != null) {
            System.out.println("❌ " + validationError);
            return false;
        }

        board[y][x].setValue(value);
        return true;
    }

    public boolean isComplete() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j].getValue() == 0)
                    return false;
        return true;
    }

    private String getValidationError(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i].getValue() == value) return "Valor já existe na linha.";
            if (board[i][x].getValue() == value) return "Valor já existe na coluna.";
        }

        int boxRow = (y / 3) * 3;
        int boxCol = (x / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[boxRow + i][boxCol + j].getValue() == value)
                    return "Valor já existe no bloco 3x3.";

        return null;
    }
    
    public boolean isValidMove(int x, int y, int value) {
        if (board[y][x].isFixed()) return false;
        return getValidationError(x, y, value) == null;
    }
    
    public int getCellValue(int x, int y) {
        return board[y][x].getValue();
    }

    public Cell getCell(int x, int y) {
        return board[y][x];
    }


}
