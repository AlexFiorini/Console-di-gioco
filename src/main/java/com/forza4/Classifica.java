package com.forza4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.Objects;
public class Classifica {

    @FXML
    Label lRosso = new Label();
    @FXML
    Label lBlu = new Label();
    @FXML
    Label l1 = new Label();
    @FXML
    Label l2 = new Label();

    public void setLabels(int cont, int cont1){
        this.lRosso.setText(cont);
        this.lBlu.setText(cont1);
    }
}
