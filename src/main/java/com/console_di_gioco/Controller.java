package com.console_di_gioco;

import javafx.application.Platform;
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
    public int selected_diff = 0; //Facile = 1, Difficile = 2

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

        if (e.getSource() == bTris) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SceltaBot.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Scelta modalità");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

            SceltaBot sceltaBotController = loader.getController();
            sceltaBotController.setController(this);
            stage.setOnHidden(windowEvent -> {
                if (selected_mode == 1) {
                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("SceltaDiff.fxml"));
                    Parent root1 = null;
                    try {
                        root1 = loader1.load();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    Stage stage1 = new Stage();
                    stage1.setTitle("Scelta difficoltà");
                    stage1.setScene(new Scene(root1));
                    stage1.setResizable(false);
                    stage1.show();

                    SceltaDiff sceltaDiffController = loader1.getController();
                    sceltaDiffController.setController(this);

                    //wait for SceltaDiff to close
                    stage1.setOnHidden(windowEvent1 -> {
                            Parent root2 = null;
                            FXMLLoader loader2 = null;
                            try {
                                loader2 = new FXMLLoader(getClass().getResource("/com/tris_bot/Finestra.fxml"));
                                root2 = loader2.load();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            Stage stage2 = new Stage();
                            stage2.setTitle("Tris");
                            stage2.setScene(new Scene(root2));
                            stage2.setResizable(false);
                            stage2.show();

                            com.tris_bot.Controller controller2 = loader2.getController();
                            if (selected_diff == 1) {
                                controller2.setPlayer2("easy");
                            } else if (selected_diff == 2) {
                                controller2.setPlayer2("hard");
                            }
                    });
                } else if (selected_mode == 2) {
                    Parent root1 = null;
                    try {
                        root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/tris/Finestra.fxml")));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    Stage stage1 = new Stage();
                    stage1.setTitle("Tris");
                    stage1.setScene(new Scene(root1));
                    stage1.setResizable(false);
                    stage1.show();
                }
            });
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


//