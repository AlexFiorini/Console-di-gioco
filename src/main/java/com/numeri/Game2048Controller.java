package com.numeri;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class Game2048Controller implements Initializable {

    @FXML
    private GridPane gameBoard;

    private Button[][] buttons = new Button[4][4];

    private int[][] board = new int[4][4];

    private Random random = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createGameBoard();
        initializeBoard();
        updateGameBoard();
    }

    private void createGameBoard() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                buttons[row][col] = button;
                gameBoard.add(button, col, row);
            }
        }
    }

    private void initializeBoard() {
        // Inizializza la board con valori iniziali
        // ...
        // Esempio: Inizializza tutti i bottoni con valore 0
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = 0;
            }
        }

        // Genera due numeri casuali (2 o 4) all'inizio del gioco
        generateRandomNumber();
        generateRandomNumber();
    }

    private void updateGameBoard() {
        // Aggiorna i bottoni sulla board in base ai valori della matrice
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int value = board[row][col];
                String text = value == 0 ? "" : String.valueOf(value);
                buttons[row][col].setText(text);
            }
        }
    }

    private void generateRandomNumber() {
        // Genera un numero casuale (2 o 4) in una posizione vuota sulla board
        List<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    emptyCells.add(new int[]{row, col});
                }
            }
        }

        if (emptyCells.isEmpty()) {
            return; // Non ci sono celle vuote
        }

        int[] randomCell = emptyCells.get(random.nextInt(emptyCells.size()));
        int randomValue = random.nextInt(10) < 9 ? 2 : 4; // Probabilità del 90% per 2 e 10% per 4
        board[randomCell[0]][randomCell[1]] = randomValue;
    }

    private void moveTilesLeft() {
        int[][] newBoard = new int[4][4];

        for (int row = 0; row < 4; row++) {
            int currentIndex = 0;
            int mergeIndex = 0;
            int mergeValue = 0;

            for (int col = 0; col < 4; col++) {
                int currentValue = board[row][col];

                if (currentValue != 0) {
                    if (currentValue == mergeValue) {
                        // Combina i numeri uguali
                        newBoard[row][mergeIndex++] = currentValue * 2;
                        mergeValue = 0;
                    } else {
                        // Sposta il numero a sinistra
                        if (mergeIndex != currentIndex) {
                            newBoard[row][currentIndex] = currentValue;
                            board[row][col] = 0;
                        } else {
                            newBoard[row][currentIndex++] = currentValue;
                        }

                        mergeValue = currentValue;
                    }
                }
            }
        }

        board = newBoard;
        generateRandomNumber();
        updateGameBoard();
    }

    private void moveTilesRight() {
        reverseBoard();
        moveTilesLeft();
        reverseBoard();
    }

    private void moveTilesUp() {
        reverseBoard();
        moveTilesLeft();
        reverseBoard();
    }

    private void moveTilesDown() {
        reverseBoard();
        moveTilesLeft();
        reverseBoard();
    }

    @FXML
    private void newGame() {
        initializeBoard();
        updateGameBoard();
    }

    private void handleKey(KeyEvent event) {
        if (!canMove()) {
            // Game over, do nothing
            return;
        }

        if (event.getCode() == KeyCode.LEFT) {
            moveTilesLeft();
        } else if (event.getCode() == KeyCode.RIGHT) {
            moveTilesRight();
        } else if (event.getCode() == KeyCode.UP) {
            moveTilesUp();
        } else if (event.getCode() == KeyCode.DOWN) {
            moveTilesDown();
        }

        if (canMove()) {
            generateRandomNumber();
            updateGameBoard();

            if (!canMove()) {
                // Game over, add your logic here
                System.out.println("Game over!");
            }
        }
    }

    private void reverseBoard() {
        int[][] newBoard = new int[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                newBoard[row][col] = board[row][3 - col];
            }
        }

        board = newBoard;
    }

    private void transposeBoard() {
        int[][] newBoard = new int[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                newBoard[row][col] = board[col][row];
            }
        }

        board = newBoard;
    }

    private boolean canMove() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                // Check if there is an empty cell
                if (board[row][col] == 0) {
                    return true;
                }

                // Check if there are adjacent cells with the same value
                if (col < 3 && board[row][col] == board[row][col + 1]) {
                    return true;
                }
                if (row < 3 && board[row][col] == board[row + 1][col]) {
                    return true;
                }
            }
        }

        return false;
    }

}