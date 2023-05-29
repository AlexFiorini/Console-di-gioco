package com.forza4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
        this.lRosso.setText(Integer.toString(cont));
        this.lBlu.setText(Integer.toString(cont1));
    }
}
