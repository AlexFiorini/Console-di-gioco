package com.tris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

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
    Image croce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Croce.png")));
    Image cerchio = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Cerchio.png")));

    public void onClick(ActionEvent event) throws Exception {
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

        if(!started) {
            started = true;
            try {
                FileReader fr = new FileReader("src/main/java/com/tris/save.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                if ((line = br.readLine()) != null) {
                    contX = Integer.parseInt(line);
                } else {
                    contX = 0;
                }
                if ((line = br.readLine()) != null) {
                    contO = Integer.parseInt(line);
                } else {
                    contO = 0;
                }
                br.close();
                fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(wincheck()){
            button0.setDisable(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            button5.setDisable(true);
            button6.setDisable(true);
            button7.setDisable(true);
            button8.setDisable(true);
            //TODO: Aggiungi leaderboard
        }
        turno++;
    }

    public boolean wincheck(){
        //TODO: Aggiungi schermata vincitore

        if(button0.getText().equals(button1.getText()) && button1.getText().equals(button2.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button3.getText().equals(button4.getText()) && button4.getText().equals(button5.getText()) && !button3.getText().equals("")){
            vincitore = button3.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button6.getText().equals(button7.getText()) && button7.getText().equals(button8.getText()) && !button6.getText().equals("")){
            vincitore = button6.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button0.getText().equals(button3.getText()) && button3.getText().equals(button6.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("")){
            vincitore = button1.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("")){
            vincitore = button2.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button0.getText().equals(button4.getText()) && button4.getText().equals(button8.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(button2.getText().equals(button4.getText()) && button4.getText().equals(button6.getText()) && !button2.getText().equals("")){
            vincitore = button2.getText();
            if(vincitore.equals("X")){
                contX++;
            }else{
                contO++;
            }
            save_file(vincitore);
            return true;
        } else if(turno == 8){
            vincitore = "Nessuno";
            save_file(vincitore);
            return true;
        }
        return false;
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