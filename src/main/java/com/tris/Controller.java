package com.tris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

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
            if(vincitore.equals("Nessuno")) {
                System.out.println("Nessuno ha vinto");
            } else {
                System.out.println(vincitore + " ha vinto");
            }
            //TODO: Aggiungi leaderboard

        }
        turno++;
    }

    public boolean wincheck(){
        //TODO: Aggiungi schermata vincitore

        if(button0.getText().equals(button1.getText()) && button1.getText().equals(button2.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            return true;
        } else if(button3.getText().equals(button4.getText()) && button4.getText().equals(button5.getText()) && !button3.getText().equals("")){
            vincitore = button3.getText();
            return true;
        } else if(button6.getText().equals(button7.getText()) && button7.getText().equals(button8.getText()) && !button6.getText().equals("")){
            vincitore = button6.getText();
            return true;
        } else if(button0.getText().equals(button3.getText()) && button3.getText().equals(button6.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            return true;
        } else if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("")){
            vincitore = button1.getText();
            return true;
        } else if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("")){
            vincitore = button2.getText();
            return true;
        } else if(button0.getText().equals(button4.getText()) && button4.getText().equals(button8.getText()) && !button0.getText().equals("")){
            vincitore = button0.getText();
            return true;
        } else if(button2.getText().equals(button4.getText()) && button4.getText().equals(button6.getText()) && !button2.getText().equals("")){
            vincitore = button2.getText();
            return true;
        } else if(turno == 8){
            vincitore = "Nessuno";
            return true;
        }
        return false;
    }
}