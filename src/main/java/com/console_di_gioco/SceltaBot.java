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
import com.console_di_gioco.ModeSelectedCallback;

public class SceltaBot implements Initializable {

    Image utenteVSutente = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSutente.jpg")));
    Image utenteVSbot = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSbot.jpg")));
    private ModeSelectedCallback modeSelectedCallback;
    @FXML
    Button bUvsU;
    @FXML
    Button bUvsB;
    @FXML
    AnchorPane sfondo;
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

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
        if(e.getSource() == bUvsU) {
            controller.selected_mode = 2;
            sfondo.getScene().getWindow().hide();
        }
        else if(e.getSource() == bUvsB) {
            controller.selected_mode = 1;
            sfondo.getScene().getWindow().hide();
        }
    }

    public void setModeSelectedCallback(ModeSelectedCallback callback) {
        this.modeSelectedCallback = callback;
    }
}
