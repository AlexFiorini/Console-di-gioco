package com.battaglia_navale;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    //Get all columns and rows from Battaglia-navale.fxml
    @FXML
    GridPane tabella;
    Button[][] buttons = new Button[10][10];

    public void test() {
        System.out.println(tabella);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++){
                buttons[i][j] = new Button();
                buttons[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                tabella.add(buttons[i][j], i, j);
            }
        }
    }
}