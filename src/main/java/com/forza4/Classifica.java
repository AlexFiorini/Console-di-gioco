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
    Label lRosso;
    @FXML
    Label lBlu;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        int contRosso = 0;
        int contBlu = 0;
        try {
                FileReader fr = new FileReader("src/main/java/com/forza4/save.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                if ((line = br.readLine()) != null) {
                    contRosso = Integer.parseInt(line);
                } else {
                    contRosso = 0;
                }
                if ((line = br.readLine()) != null) {
                    contBlu = Integer.parseInt(line);
                } else {
                    contBlu = 0;
                }
                br.close();
                fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        lRosso.setText(Integer.toString(contRosso));
        lBlu.setText(Integer.toString(contBlu));
    }
}
