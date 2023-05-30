package com.forza4_bot;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Bot {
    int ROWS = 6;
    int COLS = 7;

    int PLAYER_TURN = 0;
    int AI_TURN = 1;

    int PLAYER_PIECE = 1;
    int AI_PIECE = 2;

    Color BLUE = new Color(0, 0, 255);
    Color BLACK = new Color(0, 0, 0);
    Color RED = new Color(255, 0, 0);
    Color YELLOW = new Color(255, 255, 0);

    boolean GAME_OVER = false;


    int[][] create_board() {
        return new int[ROWS][COLS];
    }

    void drop_piece(int[][] board, int row, int col, int piece) {
        board[row][col] = piece;
    }

    boolean is_valid_location(int [][] board, int col){
        return board[0][col] == 0;
    }


            // checking where the piece will fall in the current column
// i.e., finding the first zero row in the given column
    int get_next_open_row(int[][] board, int col) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][col] == 0) {
                return r;
            }
        }
        return -1;
    }


// calculating if the current state of the board for player or AI is a win
    boolean winning_move(int[][] board, int piece) {
        // checking horizontal 'windows' of 4 for win
        for (int c = 0; c < COLS - 3; c++) {
            for (int r = 0; r < ROWS; r++) {
                if (board[r][c] == piece && board[r][c + 1] == piece && board[r][c + 2] == piece && board[r][c + 3] == piece) {
                    return true;
                }
            }
        }

        // checking vertical 'windows' of 4 for win
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (board[r][c] == piece && board[r + 1][c] == piece && board[r + 2][c] == piece && board[r + 3][c] == piece) {
                    return true;
                }
            }
        }

        // checking positively sloped diagonals for win
        for (int c = 0; c < COLS - 3; c++) {
            for (int r = 3; r < ROWS; r++) {
                if (board[r][c] == piece && board[r - 1][c + 1] == piece && board[r - 2][c + 2] == piece && board[r - 3][c + 3] == piece) {
                    return true;
                }
            }
        }

        // checking negatively sloped diagonals for win
        for (int c = 3; c < COLS; c++) {
            for (int r = 3; r < ROWS; r++) {
                if (board[r][c] == piece && board[r - 1][c - 1] == piece && board[r - 2][c - 2] == piece && board[r - 3][c - 3] == piece) {
                    return true;
                }
            }
        }
        return false;
    }

    void print_board(int[][] board) {
    }

    public int evaluate_window(int[] window, int piece) {
        int opponentPiece = PLAYER_PIECE;

        if (piece == PLAYER_PIECE) {
            opponentPiece = AI_PIECE;
        }

        int score = 0;

        if (countOccurrences(window, piece) == 4) {
            score += 100;
        } else if (countOccurrences(window, piece) == 3 && countOccurrences(window, 0) == 1) {
            score += 5;
        } else if (countOccurrences(window, piece) == 2 && countOccurrences(window, 0) == 2) {
            score += 2;
        }
        if (countOccurrences(window, opponentPiece) == 3 && countOccurrences(window, 0) == 1) {
            score -= 4;
        }

        return score;
    }


// scoring the overall attractiveness of a board after a piece has been droppped
    public int scorePosition(int[][] board, int piece) {

        int score = 0;
        int ROWS = board.length;
        int COLS = board[0].length;

    // score center column --> we are prioritizing the central column because it provides more potential winning windows
        int[] centerArray = new int[ROWS];
        for(int i=0; i<ROWS; i++){
            centerArray[i] = board[i][COLS/2];
        }
        int centerCount = countOccurrences(centerArray, piece);
        score += centerCount * 6;

    // below we go over every single window in different directions and adding up their values to the score
    // score horizontal
        for (int r = 0; r < ROWS; r++) {
            int[] rowArray = board[r];
            for (int c = 0; c <= COLS - 4; c++) {
                int[] window = Arrays.copyOfRange(rowArray, c, c+4);
                score += evaluate_window(window, piece);
            }
        }

    // score vertical
        for (int c = 0; c < COLS; c++) {
            int[] colArray = new int[ROWS];
            for(int r=0; r<ROWS; r++){
                colArray[r] = board[r][c];
            }
            for (int r = 0; r <= ROWS-4; r++) {
                int[] window = Arrays.copyOfRange(colArray, r, r+4);
                score += evaluate_window(window, piece);
            }
        }

    // score positively sloped diagonals
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c <= COLS - 4; c++) {
                int[] window = new int[]{board[r][c], board[r-1][c+1], board[r-2][c+2], board[r-3][c+3]};
                score += evaluate_window(window, piece);
            }
        }

    // score negatively sloped diagonals
        for (int r = 3; r < ROWS; r++) {
            for (int c = 3; c < COLS; c++) {
                int[] window = new int[]{board[r][c], board[r-1][c-1], board[r-2][c-2], board[r-3][c-3]};
                score += evaluate_window(window, piece);
            }
        }

        return score;
    }

    public static int countOccurrences(int[] arr, int target){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target)
                count++;
        }
        return count;
    }



// checking if the given turn or in other words node in the minimax tree is terminal
// a terminal node is player winning, AI winning or board being filled up

    boolean is_terminal_node(int[][] board) {
        return winning_move(board, PLAYER_PIECE) || winning_move(board, AI_PIECE) || getValidLocations(board).size() == 0;
    }

    public int[] minimax(int[][] board, int depth, int alpha, int beta, boolean maximizingPlayer) {

        List<Integer> validLocations = getValidLocations(board);
        boolean isTerminal = is_terminal_node(board);

        if (depth == 0 || isTerminal) {
            if (isTerminal) {
                if (winning_move(board, AI_PIECE)) {
                    return new int[]{-1, 10000000};
                } else if (winning_move(board, PLAYER_PIECE)) {
                    return new int[]{-1, -10000000};
                } else {
                    return new int[]{-1, 0};
                }
            } else { // depth = 0
                return new int[]{-1, score_position(board, AI_PIECE)};
            }
        }

        // Se la board corrente non è terminale e siamo nel turno del giocatore massimizzante
        if (maximizingPlayer) {
            int value = Integer.MIN_VALUE;

            Random rand = new Random();
            int randomIndex = rand.nextInt(validLocations.size());
            int column = validLocations.get(randomIndex);


            for (int col : validLocations) {
                int row = get_next_open_row(board, col);
                int [][] bCopy = new int[board.length][];
                for(int i = 0; i < board.length; i++)
                    bCopy[i] = board[i].clone();
                drop_piece(bCopy, row, col, AI_PIECE);
                int[] newScore = minimax(bCopy, depth - 1, alpha, beta, false);
                int score = newScore[1];

                if (score > value) {
                    value = score;
                    column = col;
                }

                alpha = Math.max(value, alpha);
                if (alpha >= beta) {
                    break;
                }
            }

            return new int[]{column, value};
        } else { // Giocatore minimizzante
            int value = Integer.MAX_VALUE;
            Random rand = new Random();
            int randomIndex = rand.nextInt(validLocations.size());
            int column = validLocations.get(randomIndex);

            for (int col : validLocations) {
                int row = get_next_open_row(board, col);
                int [][] bCopy = new int[board.length][];
                for(int i = 0; i < board.length; i++)
                    bCopy[i] = board[i].clone();
                drop_piece(bCopy, row, col, PLAYER_PIECE);
                int[] newScore = minimax(bCopy, depth - 1, alpha, beta, true);
                int score = newScore[1];

                if (score < value) {
                    value = score;
                    column = col;
                }

                beta = Math.min(value, beta);
                if (alpha >= beta) {
                    break;
                }
            }

            return new int[]{column, value};
        }
    }

    public int score_position(int[][] board, int piece) {

        int score = 0;

        int[] center_array = new int[ROWS];
        for(int i = 0; i < ROWS; i++) {
            center_array[i] = board[i][COLS/2];
        }
        int center_count = countOccurrences(center_array, piece); // count the number of occurrences of the piece in the center column
        score += center_count * 6;

        for (int r = 0; r < ROWS; r++) {
            int[] row_array = board[r];
            for (int c = 0; c < COLS - 3; c++) {
                int[] window = Arrays.copyOfRange(row_array, c, c + 4); // get the window of 4 pieces horizontally
                score += evaluate_window(window, piece);
            }
        }

        for (int c = 0; c < COLS; c++) {
            int[] col_array = new int[ROWS];
            for (int r = 0; r < ROWS; r++) {
                col_array[r] = board[r][c];
            }
            for (int r = 0; r < ROWS - 3; r++) {
                int[] window = Arrays.copyOfRange(col_array, r, r + 4);
                score += evaluate_window(window, piece);
            }
        }

// score positively sloped diagonals
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                int[] window = new int[]{board[r][c], board[r-1][c+1], board[r-2][c+2], board[r-3][c+3]}; // get the window of 4 pieces on a positively sloped diagonal
                score += evaluate_window(window, piece);
            }
        }

// score negatively sloped diagonals
        for (int r = 3; r < ROWS; r++) {
            for (int c = 3; c < COLS; c++) {
                int[] window = new int[]{board[r][c], board[r-1][c-1], board[r-2][c-2], board[r-3][c-3]}; // get the window of 4 pieces on a negatively sloped diagonal
                score += evaluate_window(window, piece);
            }
        }

        return score;
    }

    public List<Integer> getValidLocations(int[][] board) {
        List<Integer> validLocations=new ArrayList<Integer>();

        for (int col = 0; col < COLS; col++) {
            if (is_valid_location(board, col)) {
                validLocations.add(col);
            }
        }

        return validLocations;
    }

    public void end_game() {
        GAME_OVER = true;
        System.out.println(GAME_OVER);
    }
}
