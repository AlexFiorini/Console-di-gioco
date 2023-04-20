package com.console_di_gioco;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Objects;
import java.awt.*;

public class Controller {

    Image tris = new Image(Objects.requireNonNull(getClass().getResourceAsStream("tris.png")));
    public Button bTris = new Button();
    public Button bForza4 = new Button();
    public Button bBN = new Button();
    public Button b2048 = new Button();

}