package com.console_di_gioco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import com.battaglia_navale.BattleShip;

public class Controller {

    Image Tris = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Tris.png")));
    Image Forza4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Forza4.png")));
    Image BN = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BattagliaNavale.png")));
    Image i2048 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("2048.png")));
    public Button bTris = new Button();
    public Button bForza4 = new Button();
    public Button bBN = new Button();
    public Button b2048 = new Button();
    public int selected_mode = 0; //Bot = 1, Utente = 2
    public int selected_diff = 0; //Facile = 1, Difficile = 3

    void InitImage()
    {
        ImageView view1, view2, view3, view4;

        view1 = new ImageView(Tris);
        bTris.setGraphic(view1);
        view2 = new ImageView(Forza4);
        bForza4.setGraphic(view2);
        view3 = new ImageView(BN);
        bBN.setGraphic(view3);
        view4 = new ImageView(i2048);
        b2048.setGraphic(view4);
    }

    @FXML
    void onClick(ActionEvent e) throws IOException {

        if(e.getSource() == bTris) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SceltaBot.fxml")));
            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/tris/Finestra.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Modalità");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
        else if(e.getSource() == bForza4) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SceltaBot.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Modalità");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
        else if(e.getSource() == bBN) {
            BattleShip.main(new String[0]);
        }


        Stage thisStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        thisStage.setIconified(true);
    }
}