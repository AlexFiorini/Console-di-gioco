package com.tris_bot;

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        boolean appRunning = true;
        boolean inGame = false;
        Scanner scanner = new Scanner(System.in);
        while(appRunning) {
            System.out.print("Input command: ");
            String command = scanner.nextLine();
            String mode = "";
            String player1 = "";
            String player2 = "";
            if (command.split(" ").length == 1) mode = command.split(" ")[0];
            if (command.split(" ").length == 3) {
                mode = command.split(" ")[0];
                player1 = command.split(" ")[1];
                player2 = command.split(" ")[2];
            }
            boolean badInput = false;
            switch (mode) {
                case "start" -> {
                    inGame = true;
                    for (String player : new String[]{player1, player2}) {
                        switch (player) {
                            case "easy", "medium", "hard", "user" -> inGame = true;
                            default -> {
                                badInput = true;
                                inGame = false;
                            }
                        }
                    }
                }
                case "exit" -> appRunning = false;
                default -> badInput = true;
            }
            if (badInput) {
                System.out.println("Bad parameters!");
                inGame = false;
            }
            char[][] board = new char[3][3];
            for (char[] row : board) {
                Arrays.fill(row, ' ');
            }
            if (inGame) display(board);

            while (inGame) {
                switch (player1) {
                    case "user" -> playerMove(board, 1);
                    case "easy" -> easyMove(board, 1);
                    case "medium" -> mediumMove(board, 1);
                    case "hard" -> hardMove(board, 1);
                }
                display(board);
                inGame = gameState(board);
                if (!inGame) break;
                switch (player2) {
                    case "user" -> playerMove(board, 2);
                    case "easy" -> easyMove(board, 2);
                    case "medium" -> mediumMove(board, 2);
                    case "hard" -> hardMove(board, 2);
                }
                display(board);
                inGame = gameState(board);
            }
        }

    }

    private static void playerMove(char[][] board, int player) {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;
        int move1, move2;
        int index1, index2;
        while (!validMove) {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                move1 = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }
            if (scanner.hasNextInt()) {
                move2 = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }
            index1 = 3 - move2;
            index2 = move1 - 1;
            if (index1 < 0 || index1 > 2 || index2 < 0 || index2 > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (board[index1][index2] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            validMove = true;

            char symbol = player == 2 ? 'O' : 'X';

            board[index1][index2] = symbol;
        }
    }

    private static void display(char[][] state) {
        System.out.println("---------");
        System.out.println("| " + state[0][0] + ' ' + state[0][1] + ' ' + state[0][2] + " |");
        System.out.println("| " + state[1][0] + ' ' + state[1][1] + ' ' + state[1][2] + " |");
        System.out.println("| " + state[2][0] + ' ' + state[2][1] + ' ' + state[2][2] + " |");
        System.out.println("---------");

    }

    private static void easyMove(char[][] board, int player) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int choice;
        do {
            choice = random.nextInt(9);
        } while (board[choice/3][choice%3] != ' ');

        char symbol = player == 1 ? 'X' : 'O';

        board[choice/3][choice%3] = symbol;
    }

    private static void mediumMove(char[][] board, int player) {
        System.out.println("Making move level \"medium\"");
        int choice;
        int [] coordinate = new int[2];
        boolean choiceMade = false;

        char symbol = 'O';
        char enemySymbol = 'X';
        switch (player) {
            case 1 -> {
                symbol = 'X';
                enemySymbol = 'O';
            }
            case 2 -> {
            }
        }

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

    private static void hardMove(char[][] board, int player) {
        System.out.println("Making move level \"hard\"");

        char symbol = ' ';
        if (player == 1) {
            symbol = 'X';
        } else if (player == 2) {
            symbol = 'O';
        }
        Move bestMove = minimax(board, player, player);
        board[bestMove.index[0]][bestMove.index[1]] = symbol;
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

}

class Move {
    int[] index;
    int score;

    Move() {

    }

    Move(int s) {
        score = s;
    }
}