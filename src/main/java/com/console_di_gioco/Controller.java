package com.console_di_gioco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

public class Controller {

    Image Tris = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Tris.png")));
    Image Forza4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Forza4.png")));
    Image BN = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BattagliaNavale.png")));
    Image i2048 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("2048.png")));
    public Button bTris = new Button();
    public Button bForza4 = new Button();
    public Button bBN = new Button();
    public Button b2048 = new Button();


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
    void onClick(ActionEvent e){
        /*if(e.getSource() == bTris) {
            new SceltaBot();
        }
        else if(e.getSource() == bForza4) {
            new SceltaBot();
        }
        else if(e.getSource() == bBN) {
            new SceltaBot();
        }
        else if(e.getSource() == b2048) {
            new SceltaBot();
        }*/
    }
}