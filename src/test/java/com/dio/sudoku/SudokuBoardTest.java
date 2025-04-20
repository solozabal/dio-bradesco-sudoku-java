
package com.dio.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    private SudokuBoard sudokuBoard;

    @BeforeEach
    void setUp() {
        sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard(null); // Initialize the board
    }

    @Test
    void testInitializeBoard() {
        // Ensure the board is initialized with 9x9 cells
        assertNotNull(sudokuBoard);
        assertDoesNotThrow(() -> sudokuBoard.printBoard());
    }

    @Test
    void testSetCellValue_ValidMove() {
        // Set a value in a non-fixed cell
        boolean result = sudokuBoard.setCellValue(2, 0, 4); // Example: Set 4 at (2, 0)
        assertTrue(result, "Should allow setting a value in a non-fixed cell.");
    }

    @Test
    void testSetCellValue_FixedCell() {
        // Attempt to set a value in a fixed cell
        boolean result = sudokuBoard.setCellValue(0, 0, 4); // Example: Fixed cell (0, 0)
        assertFalse(result, "Should not allow setting a value in a fixed cell.");
    }

    @Test
    void testSetCellValue_InvalidMove_RowConflict() {
        // Attempt to set a value that conflicts with the same row
        boolean result = sudokuBoard.setCellValue(2, 0, 5); // 5 already exists in row 0
        assertFalse(result, "Should not allow setting a value that conflicts with the row.");
    }

    @Test
    void testSetCellValue_InvalidMove_ColumnConflict() {
        // Attempt to set a value that conflicts with the same column
        boolean result = sudokuBoard.setCellValue(0, 1, 5); // 5 already exists in column 0
        assertFalse(result, "Should not allow setting a value that conflicts with the column.");
    }

    @Test
    void testSetCellValue_InvalidMove_BoxConflict() {
        // Attempt to set a value that conflicts with the same 3x3 box
        boolean result = sudokuBoard.setCellValue(1, 1, 5); // 5 already exists in the 3x3 box
        assertFalse(result, "Should not allow setting a value that conflicts with the 3x3 box.");
    }

    @Test
    void testIsComplete_IncompleteBoard() {
        // Ensure the board is not marked as complete initially
        assertFalse(sudokuBoard.isComplete(), "Board should not be complete initially.");
    }

    @Test
    void testIsComplete_CompleteBoard() {
        // Simulate a complete board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!sudokuBoard.setCellValue(j, i, (i * 3 + j) % 9 + 1)) {
                    // Ignore fixed cells or invalid moves
                }
            }
        }
        assertTrue(sudokuBoard.isComplete(), "Board should be marked as complete.");
    }
}
