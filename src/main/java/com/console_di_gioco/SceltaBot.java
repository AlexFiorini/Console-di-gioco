package com.console_di_gioco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.Objects;

public class SceltaBot {

    Image utenteVSutente = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSutente.jpg")));
    Image utenteVSbot = new Image(Objects.requireNonNull(getClass().getResourceAsStream("utenteVSbot.jpg")));

    public Button bUvsU = new Button();
    public Button bUvsB = new Button();

    void InitImage()
    {
        ImageView view1, view2;

        view1 = new ImageView(utenteVSutente);
        bUvsU.setGraphic(view1);

        view2 = new ImageView(utenteVSbot);
        bUvsB.setGraphic(view2);
    }
}
