package com.tris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Controller {
    int turno = 0;
    boolean started = false;
    int contX = 0;
    int contO = 0;
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
    @FXML
    Button np;
    @FXML
    Button c;

    Button[][] matrix = new Button[3][3];
    char[][] board = new char[3][3];
    Image croce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Croce.png")));
    Image cerchio = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Cerchio.png")));
    String player2 = "hard";

    ImageView view;

    public void onClick(ActionEvent event) throws IOException {
        if(event.getSource() == np) {
            reset();
        } else if (event.getSource() == c){
            openWindow("Classifica.fxml", "Classifica", 200, 80, false);
        }else{
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
                        case "hard" -> hardMove();
                    }
                    if(vince('O')) {
                        vittoria("O");
                    }
                }
            }
            turno += 2;
        }

        if(vincitore.equals("Nessuno")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vincitore");
            alert.setContentText("Nessuno ha vinto");
            alert.showAndWait();
        }


        if(!started) {
            started = true;
            try {
                FileReader fr = new FileReader("src/main/java/com/tris/save.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                if ((line = br.readLine()) != null) {
                    contX = Integer.parseInt(line);
                } else {
                    contO = 0;
                }
                if ((line = br.readLine()) != null) {
                    contX = Integer.parseInt(line);
                } else {
                    contO = 0;
                }
                br.close();
                fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
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

    private void hardMove() {
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
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Vincitore");
        alert1.setContentText(v + " ha vinto!");
        alert1.showAndWait();

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                matrix[i][j].setDisable(true);
            }
        }
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

    private boolean vince(char symbol) {
        if(button0.getText().equals(button1.getText()) && button1.getText().equals(button2.getText()) && !button0.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button0.getText().charAt(0) == symbol;
        } else if(button3.getText().equals(button4.getText()) && button4.getText().equals(button5.getText()) && !button3.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button3.getText().charAt(0) == symbol;
        } else if(button6.getText().equals(button7.getText()) && button7.getText().equals(button8.getText()) && !button6.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button6.getText().charAt(0) == symbol;
        } else if(button0.getText().equals(button3.getText()) && button3.getText().equals(button6.getText()) && !button0.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button0.getText().charAt(0) == symbol;
        } else if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button1.getText().charAt(0) == symbol;
        } else if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button2.getText().charAt(0) == symbol;
        } else if(button0.getText().equals(button4.getText()) && button4.getText().equals(button8.getText()) && !button0.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button0.getText().charAt(0) == symbol;
        } else if(button2.getText().equals(button4.getText()) && button4.getText().equals(button6.getText()) && !button2.getText().equals("")){
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return button2.getText().charAt(0) == symbol;
        } else if(turno == 8){
            vincitore = "Nessuno";
            return false;
        }
        return false;
    }

    public void reset() {
        button0.setText("");
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");


        button0.setDisable(false);
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);


        button0.setGraphic(null);
        button1.setGraphic(null);
        button2.setGraphic(null);
        button3.setGraphic(null);
        button4.setGraphic(null);
        button5.setGraphic(null);
        button6.setGraphic(null);
        button7.setGraphic(null);
        button8.setGraphic(null);
        turno = 0;
    }
    private void openWindow(String fileFxml, String title, int width, int height, boolean resiz) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fileFxml));
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(resiz);
        stage.show();
    }
    private void save_file(String winner) {
        try {
            FileWriter fw = new FileWriter(".\\src\\main\\java\\com\\tris\\save.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contX + "\n" + contO);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}