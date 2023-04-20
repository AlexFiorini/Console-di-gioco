package com.console_di_gioco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);
        scene.getStylesheets().addAll(this.getClass().getResource("Test.css").toExternalForm());
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}