package com.tris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.*;

public class Controller2 {
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
    char[][] board = new char[3][3];
    Image croce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Croce.png")));
    Image cerchio = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Cerchio.png")));
    String player2 = "medium";

    ImageView view;

    public void onClick(ActionEvent event) {

        disegna((Button) event.getSource());
        creaMatrice();
        if(vince('X')){
            vittoria("X");
        } else {
            if(vince('O')) {
                vittoria("O");
            } else if(turno < 8) {
                switch (player2) {
                    case "easy" -> easyMove();
                    case "medium" -> mediumMove();
                    case "hard" -> hardMove();
                }
                if(vince('O')) {
                    vittoria("O");
                }
            }
        }
        turno += 2;
        if(vincitore.equals("Nessuno")) {
            System.out.println("Draw");
        }
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

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(matrix[i][j].getText().length()==0) {
                    board[i][j]=' ';
                } else {
                    board[i][j]=matrix[i][j].getText().charAt(0);
                }
            }
        }
    }

    private void easyMove() {
        Random random = new Random();
        int choice;
        do {
            choice = random.nextInt(9);
        } while (board[choice/3][choice%3] != ' ');

        char symbol = 'O';

        board[choice/3][choice%3] = symbol;
        disegna(choice/3, choice%3);
    }

    private void mediumMove() {
        int choice;
        int [] coordinate = new int[2];
        boolean choiceMade = false;

        char symbol = 'O';
        char enemySymbol = 'X';

        int[] bestMove = seekWin(symbol);
        if (bestMove[0] != -1) {
            choiceMade = true;
            coordinate = bestMove;
        }

        if (!choiceMade) {
            bestMove = seekWin(enemySymbol);
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
            disegna(choice / 3, choice % 3);
        } else {
            board[coordinate[0]][coordinate[1]] = symbol;
            disegna(coordinate[0], coordinate[1]);
        }
    }

    private void disegna(Button b) {
        b.setTextFill(Color.WHITE);
        b.setText("X");
        view = new ImageView(croce);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        b.setGraphic(view);
        b.setDisable(true);
    }

    private void disegna(int x, int y) {
        Button btn = matrix[x][y];
        btn.setTextFill(Color.WHITE);
        btn.setText("O");
        view = new ImageView(cerchio);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        btn.setGraphic(view);
        btn.setDisable(true);
    }

    private void vittoria(String v) {
        vincitore = v;
        System.out.println(v + " wins");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                matrix[i][j].setDisable(true);
            }
        }
    }

    private void hardMove() {
        System.out.println("Making move level \"hard\"");

        char symbol;
        symbol = 'O';
        Move bestMove = minimax(2, 2);
        board[bestMove.index[0]][bestMove.index[1]] = symbol;
    }

    private boolean gameState() {
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

    private int[] seekWin(char symbol) {
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

    private Move minimax(int callingPlayer, int currentPlayer) {
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
        int[][] availableSpots = emptyIndexes();

        if (vince(enemySymbol)) {
            return new Move(-10);
        } else if (vince(callingSymbol)) {
            return new Move(10);
        } else if (!areThereEmptyIndexes()) {
            return new Move(0);
        }
        List<Move> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (availableSpots[i][j] == 1) {
                    Move move = new Move();
                    move.index = new int[]{i, j};
                    board[i][j] = symbol;
                    Move result = minimax(callingPlayer, enemyNumber);
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

    private int[][] emptyIndexes() {
        int[][] empties = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    empties[i][j] = 1;
                } else {
                    empties[i][j] = 0;
                }
            }
        }
        return empties;
    }

    private boolean vince(char symbol) {
        if(button0.getText().equals(button1.getText()) && button1.getText().equals(button2.getText()) && !button0.getText().equals("")){
            return button0.getText().charAt(0) == symbol;
        } else if(button3.getText().equals(button4.getText()) && button4.getText().equals(button5.getText()) && !button3.getText().equals("")){
            return button3.getText().charAt(0) == symbol;
        } else if(button6.getText().equals(button7.getText()) && button7.getText().equals(button8.getText()) && !button6.getText().equals("")){
            return button6.getText().charAt(0) == symbol;
        } else if(button0.getText().equals(button3.getText()) && button3.getText().equals(button6.getText()) && !button0.getText().equals("")){
            return button0.getText().charAt(0) == symbol;
        } else if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("")){
            return button1.getText().charAt(0) == symbol;
        } else if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("")){
            return button2.getText().charAt(0) == symbol;
        } else if(button0.getText().equals(button4.getText()) && button4.getText().equals(button8.getText()) && !button0.getText().equals("")){
            return button0.getText().charAt(0) == symbol;
        } else if(button2.getText().equals(button4.getText()) && button4.getText().equals(button6.getText()) && !button2.getText().equals("")){
            return button2.getText().charAt(0) == symbol;
        } else if(turno == 8){
            vincitore = "Nessuno";
            return false;
        }
        return false;
    }

    private boolean areThereEmptyIndexes() {
        boolean empties = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    empties = true;
                    break;
                }
            }
        }
        return empties;
    }
}
