package com.dio.sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuGUI {
    private static final int SIZE = 9;
    private static JTextField[][] cells = new JTextField[SIZE][SIZE];

    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();
        board.initializeBoard(null);

        JFrame frame = new JFrame("🧩 Sudoku DIO - GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JTextField cellField = new JTextField();
                int value = board.getCellValue(j, i);
                if (value != 0) {
                    cellField.setText(String.valueOf(value));
                    cellField.setEditable(false);
                    cellField.setBackground(new Color(220, 220, 220));
                } else {
                    cellField.setHorizontalAlignment(JTextField.CENTER);
                }

                cells[i][j] = cellField;
                panel.add(cellField);
            }
        }

        JButton validarBtn = new JButton("Validar");
        validarBtn.addActionListener(e -> {
            boolean valid = true;

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!board.getCell(j, i).isFixed()) {
                        try {
                            int val = Integer.parseInt(cells[i][j].getText());
                            if (!board.isValidMove(j, i, val)) {
                                valid = false;
                                cells[i][j].setBackground(Color.PINK);
                            } else {
                                cells[i][j].setBackground(Color.WHITE);
                            }
                        } catch (NumberFormatException ex) {
                            valid = false;
                            cells[i][j].setBackground(Color.PINK);
                        }
                    }
                }
            }

            if (valid) {
                JOptionPane.showMessageDialog(frame, "🎉 Sudoku válido!");
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Há erros no tabuleiro.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(validarBtn, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
