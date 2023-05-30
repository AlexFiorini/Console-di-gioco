package com.forza4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
public class Classifica implements Initializable {

    @FXML
    Label lU;
    @FXML
    Label lB;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        int contU = 0;
        int contB = 0;
        try {
            FileReader fr = new FileReader("src/main/java/com/forza4/save.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            if ((line = br.readLine()) != null) {
                contU = Integer.parseInt(line);
            } else {
                contU = 0;
            }
            if ((line = br.readLine()) != null) {
                contB = Integer.parseInt(line);
            } else {
                contB = 0;
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        lU.setText(Integer.toString(contU));
        lB.setText(Integer.toString(contB));
    }
}
