package com.tris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.*;

public class Controller {
    int turno = 0;
    String vincitore = "";
    @FXML
    Button button0;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;

    Button[][] matrix = new Button[3][3];
    Image croce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Croce.png")));
    Image cerchio = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Cerchio.png")));

    public void onClick(ActionEvent event) {
        creaMatrice();
        Button btn = (Button) event.getSource();
        btn.setTextFill(Color.WHITE);
        ImageView view;
        if(turno%2 == 0){
            btn.setText("X");
            view = new ImageView(croce);

        }else{
            btn.setText("O");
            view = new ImageView(cerchio);
        }
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        btn.setGraphic(view);
        btn.setDisable(true);
        turno++;
    }

    private void creaMatrice() {
        matrix[0][0] = button0;
        matrix[0][1] = button1;
        matrix[0][2] = button2;
        matrix[1][0] = button3;
        matrix[1][1] = button4;
        matrix[1][2] = button5;
        matrix[2][0] = button6;
        matrix[2][1] = button7;
        matrix[2][2] = button8;
    }

    private static void Running(String player2) {
        boolean inGame = true;
        char[][] board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }

        while (inGame) {
            inGame = gameState(board);
            if (!inGame) break;
            easyMove(board);
            /*switch (player2) {
                case "easy" -> easyMove(board);
                case "medium" -> mediumMove(board);
                case "hard" -> hardMove(board);
            }*/
            inGame = gameState(board);
        }
    }

    private static void easyMove(char[][] board) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int choice;
        do {
            choice = random.nextInt(9);
        } while (board[choice/3][choice%3] != ' ');

        char symbol = 'O';

        board[choice/3][choice%3] = symbol;
    }

    private static void mediumMove(char[][] board) {
        System.out.println("Making move level \"medium\"");
        int choice;
        int [] coordinate = new int[2];
        boolean choiceMade = false;

        char symbol = 'O';
        char enemySymbol = 'X';

        int[] bestMove = seekWin(board, symbol);
        if (bestMove[0] != -1) {
            choiceMade = true;
            coordinate = bestMove;
        }

        if (!choiceMade) {
            bestMove = seekWin(board, enemySymbol);
            if (bestMove[0] != -1) {
                choiceMade = true;
                coordinate = bestMove;
            }
        }

        if (!choiceMade) {
            Random random = new Random();

            do {
                choice = random.nextInt(9);
            } while (board[choice / 3][choice % 3] != ' ');

            board[choice / 3][choice % 3] = symbol;
        } else {
            board[coordinate[0]][coordinate[1]] = symbol;
        }
    }

    private static void hardMove(char[][] board) {
        System.out.println("Making move level \"hard\"");

        char symbol;
        symbol = 'O';
        Move bestMove = minimax(board, 2, 2);
        board[bestMove.index[0]][bestMove.index[1]] = symbol;
    }

    private static boolean gameState(char[][] board) {
        boolean xWins = false;
        boolean oWins = false;
        boolean impossible = false;
        boolean draw = false;
        boolean inGame = true;
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'X') {
                    xWins = true;
                } else if (board[0][i] == 'O') {
                    oWins = true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'X') {
                    xWins = true;
                } else if (board[i][0] == 'O'){
                    oWins = true;
                }
            }
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[2][0] == board[1][1] && board[1][1] == board[0][2])) {
            if (board[1][1] == 'X') {
                xWins = true;
            } else if (board[1][1] == 'O') {
                oWins = true;
            }
        }

        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xCount++;
                } else if (board[i][j] == 'O') {
                    oCount++;
                }
            }
        }
        if (((xCount == 4 && oCount == 5) || (xCount == 5 && oCount == 4)) && (!xWins && !oWins)) {
            draw = true;
        } else if (xCount >= oCount + 2 || oCount >= xCount + 2) {
            impossible = true;
        }
        if (xWins && oWins) {
            impossible = true;
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        }
        if (impossible) {
            System.out.println("Impossible");
        } else if (draw) {
            System.out.println("Draw");
        }

        if (xWins || oWins || draw || impossible) inGame = false;

        return inGame;
    }

    private static int[] seekWin(char[][] board, char symbol) {
        int row = -1;
        int column = -1;
        if ((board[0][0] == symbol && board[2][2] == symbol && board[1][1] == ' ') || (board[2][0] == symbol && board[0][2] == symbol && board[1][1] == ' ')) {
            row = 1;
            column = 1;
        } else if (board[1][1] == symbol) {
            if (board[0][0] == symbol && board[2][2] == ' ') {
                row = 2;
                column = 2;
            } else if (board[2][2] == symbol && board[0][0] == ' ') {
                row = 0;
                column = 0;
            } else if (board[0][2] == symbol && board[2][0] == ' ') {
                row = 2;
                column = 0;
            } else if (board[2][0] == symbol && board[0][2] == ' ') {
                row = 0;
                column = 2;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == ' ') {
                row = i;
                column = 2;
            } else if (board[i][1] == symbol && board[i][2] == symbol && board[i][0] == ' ') {
                row = i;
                column = 0;
            } else if (board[i][0] == symbol && board[i][2] == symbol && board[i][1] == ' ') {
                row = i;
                column = 1;
            } else if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == ' ') {
                row = 2;
                column = i;
            } else if (board[1][i] == symbol && board[2][i] == symbol && board[0][i] == ' ') {
                row = 0;
                column = i;
            } else if (board[0][i] == symbol && board[2][i] == symbol && board[1][i] == ' ') {
                row = 1;
                column = i;
            }
        }

        return new int[] {row, column};
    }

    private static Move minimax(char[][] board, int callingPlayer, int currentPlayer) {
        char enemySymbol = ' ';
        char callingSymbol = ' ';
        if (callingPlayer == 1) {
            callingSymbol = 'X';
            enemySymbol = 'O';
        } else if (callingPlayer == 2) {
            callingSymbol = 'O';
            enemySymbol = 'X';
        }

        char symbol = ' ';
        int enemyNumber = 0;
        if (currentPlayer == 1) {
            symbol = 'X';
            enemyNumber = 2;
        } else if (currentPlayer == 2) {
            symbol = 'O';
            enemyNumber = 1;
        }
        int[][] availableSpots = emptyIndexes(board);

        if (winning(board, enemySymbol)) {
            return new Move(-10);
        } else if (winning(board, callingSymbol)) {
            return new Move(10);
        } else if (!areThereEmptyIndexes(board)) {
            return new Move(0);
        }
        List<Move> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (availableSpots[i][j] == 1) {
                    Move move = new Move();
                    move.index = new int[]{i, j};
                    board[i][j] = symbol;
                    Move result = minimax(board, callingPlayer, enemyNumber);
                    move.score = result.score;
                    board[i][j] = ' ';
                    moves.add(move);
                }
            }
        }

        int bestMove = 0;

        if (currentPlayer == callingPlayer) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }
        return moves.get(bestMove);
    }

    private static int[][] emptyIndexes(char[][] state) {
        int[][] empties = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == ' ') {
                    empties[i][j] = 1;
                } else {
                    empties[i][j] = 0;
                }
            }
        }
        return empties;
    }

    private static boolean winning(char[][] board, char player) {
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
                (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
                (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
                (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean areThereEmptyIndexes(char[][] state) {
        boolean empties = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == ' ') {
                    empties = true;
                    break;
                }
            }
        }
        return empties;
    }
}
