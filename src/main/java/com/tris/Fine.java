package com.tris;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Fine extends Application {
    private String vincitore = "a";
    @FXML
    TextField Scritta;

    public void setVincitore(String vincitore){
        this.vincitore = vincitore;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Fine.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Fine!");
        stage.setScene(scene);
        stage.show();
        Scritta.setText(vincitore);
    }
}