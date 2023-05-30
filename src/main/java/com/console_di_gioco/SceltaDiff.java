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
import com.console_di_gioco.DifficultySelectedCallback;

public class SceltaDiff implements Initializable {

    Image Diff = new Image(Objects.requireNonNull(getClass().getResourceAsStream("difficult.jpg")));
    Image Easy = new Image(Objects.requireNonNull(getClass().getResourceAsStream("easy.jpg")));
    private DifficultySelectedCallback difficultySelectedCallback;

    @FXML
    Button Facile;
    @FXML
    Button Difficile;
    @FXML
    AnchorPane sfondo;
    private Controller controller;

    public void setDifficultySelectedCallback(DifficultySelectedCallback callback) {
        this.difficultySelectedCallback = callback;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    void InitImage()
    {
        ImageView view1, view2;

        view1 = new ImageView(Easy);
        Facile.setGraphic(view1);
        view2 = new ImageView(Diff);
        Difficile.setGraphic(view2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InitImage();
    }

    public void onClick(ActionEvent e){
        if(e.getSource() == Facile) {
            controller.selected_diff = 1;
            sfondo.getScene().getWindow().hide();
        }
        else if(e.getSource() == Difficile) {
            controller.selected_diff = 2;
            sfondo.getScene().getWindow().hide();
        }
    }
}
