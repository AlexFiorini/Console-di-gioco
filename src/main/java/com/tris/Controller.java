package com.tris;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Controller {
    @FXML private Button button;
    public void handleButtonPress(ActionEvent event) {
        button.setVisible(false);
    }
}