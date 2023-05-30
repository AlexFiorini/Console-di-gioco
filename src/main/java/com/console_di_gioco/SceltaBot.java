package com.console_di_gioco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SceltaBot implements Initializable {

    Image utenteVSutente = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSutente.jpg")));
    Image utenteVSbot = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSbot.jpg")));

    @FXML
    Button bUvsU;
    @FXML
    Button bUvsB;
    @FXML
    AnchorPane sfondo;

    void InitImage()
    {
        ImageView view1, view2;

        view1 = new ImageView(utenteVSutente);
        bUvsU.setGraphic(view1);
        view2 = new ImageView(utenteVSbot);
        bUvsB.setGraphic(view2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InitImage();
    }

    public void onClick(ActionEvent e){
        /*if(e.getSource() == bUvsU) {
            Controller.selected_mode = 1;
        }
        else if(e.getSource() == bUvsB) {
            Controller.selected_mode = 2;
        }*/
    }
}
