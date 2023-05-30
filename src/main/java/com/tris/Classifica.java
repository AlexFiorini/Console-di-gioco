package com.tris;
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
    Label lX;
    @FXML
    Label lO;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        int contX = 0;
        int contO = 0;
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
        lX.setText(Integer.toString(contX));
        lO.setText(Integer.toString(contO));
    }
}

