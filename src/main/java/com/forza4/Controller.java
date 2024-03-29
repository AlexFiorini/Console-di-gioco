package com.forza4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    Image rosso = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Rosso.png")));
    Image blu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Blu.png")));
    public boolean filled = false;
    public Button[][] bottoni = new Button[6][7];
    public int contRosso = 0;
    public int contBlu = 0;
    String turno = "Rosso";
    public boolean started = false;
    @FXML
    Button np;
    @FXML
    Button c;
    @FXML
    Button b00;
    @FXML
    Button b01;
    @FXML
    Button b02;
    @FXML
    Button b03;
    @FXML
    Button b04;
    @FXML
    Button b05;
    @FXML
    Button b06;
    @FXML
    Button b10;
    @FXML
    Button b11;
    @FXML
    Button b12;
    @FXML
    Button b13;
    @FXML
    Button b14;
    @FXML
    Button b15;
    @FXML
    Button b16;
    @FXML
    Button b20;
    @FXML
    Button b21;
    @FXML
    Button b22;
    @FXML
    Button b23;
    @FXML
    Button b24;
    @FXML
    Button b25;
    @FXML
    Button b26;
    @FXML
    Button b30;
    @FXML
    Button b31;
    @FXML
    Button b32;
    @FXML
    Button b33;
    @FXML
    Button b34;
    @FXML
    Button b35;
    @FXML
    Button b36;
    @FXML
    Button b40;
    @FXML
    Button b41;
    @FXML
    Button b42;
    @FXML
    Button b43;
    @FXML
    Button b44;
    @FXML
    Button b45;
    @FXML
    Button b46;
    @FXML
    Button b50;
    @FXML
    Button b51;
    @FXML
    Button b52;
    @FXML
    Button b53;
    @FXML
    Button b54;
    @FXML
    Button b55;
    @FXML
    Button b56;

    public void onClick(ActionEvent e) throws IOException {
        if(!filled) {
            init();
            filled = true;
            np.setDisable(true);
        }

        if(!started) {
            started = true;
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
        }

        if(e.getSource() == np) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    bottoni[i][j].setText("");
                    bottoni[i][j].setGraphic(null);
                    bottoni[i][j].setDisable(false);
                }
            }
            np.setDisable(true);
        } else if (e.getSource() == c){
            openWindow("Classifica.fxml", "Classifica", 200, 80, false);
        } else {
            insert((Button) e.getSource());
            check();
            np.setDisable(false);
        }
    }

    public void init() {
        bottoni[0][0] = b00;
        bottoni[0][1] = b01;
        bottoni[0][2] = b02;
        bottoni[0][3] = b03;
        bottoni[0][4] = b04;
        bottoni[0][5] = b05;
        bottoni[0][6] = b06;
        bottoni[1][0] = b10;
        bottoni[1][1] = b11;
        bottoni[1][2] = b12;
        bottoni[1][3] = b13;
        bottoni[1][4] = b14;
        bottoni[1][5] = b15;
        bottoni[1][6] = b16;
        bottoni[2][0] = b20;
        bottoni[2][1] = b21;
        bottoni[2][2] = b22;
        bottoni[2][3] = b23;
        bottoni[2][4] = b24;
        bottoni[2][5] = b25;
        bottoni[2][6] = b26;
        bottoni[3][0] = b30;
        bottoni[3][1] = b31;
        bottoni[3][2] = b32;
        bottoni[3][3] = b33;
        bottoni[3][4] = b34;
        bottoni[3][5] = b35;
        bottoni[3][6] = b36;
        bottoni[4][0] = b40;
        bottoni[4][1] = b41;
        bottoni[4][2] = b42;
        bottoni[4][3] = b43;
        bottoni[4][4] = b44;
        bottoni[4][5] = b45;
        bottoni[4][6] = b46;
        bottoni[5][0] = b50;
        bottoni[5][1] = b51;
        bottoni[5][2] = b52;
        bottoni[5][3] = b53;
        bottoni[5][4] = b54;
        bottoni[5][5] = b55;
        bottoni[5][6] = b56;
    }

    public void insert(Button premuto) {
        int colonna = ((int) premuto.getId().charAt(2)) - 48;

        for(int i = 5; i >= 0; i--) {
            if(bottoni[i][colonna].getText().equals("")) {
                bottoni[i][colonna].setTextFill(Color.WHITE);
                ImageView view;
                if(turno.equals("Rosso")) {
                    bottoni[i][colonna].setText("R");
                    view = new ImageView(rosso);
                    bottoni[i][colonna].setGraphic(view);
                    turno = "Blu";
                } else {
                    bottoni[i][colonna].setText("B");
                    view = new ImageView(blu);
                    bottoni[i][colonna].setGraphic(view);
                    turno = "Rosso";
                }
                view.setFitHeight(60);
                view.setPreserveRatio(true);
                bottoni[i][colonna].setDisable(true);
                break;
            }
        }
    }

    public void check() {
        boolean winnerFound = false; // Track if a winner is found

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (!bottoni[i][j].getText().equals("")) {
                    if (i < 3) {
                        if (j < 4) {
                            if (bottoni[i][j].getText().equals(bottoni[i + 1][j + 1].getText()) &&
                                bottoni[i][j].getText().equals(bottoni[i + 2][j + 2].getText()) &&
                                bottoni[i][j].getText().equals(bottoni[i + 3][j + 3].getText())) {
                                if (bottoni[i][j].getText().equals("R")) {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Vincitore");
                                    alert.setContentText("Ha vinto il rosso!");
                                    alert.showAndWait();
                                    contRosso++;
                                    disable("Rosso");
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Vincitore");
                                    alert.setContentText("Ha vinto il blu!");
                                    alert.showAndWait();
                                    contBlu++;
                                    disable("Blu");
                                }
                                winnerFound = true; // Winner found, set the flag
                                break; // Exit the inner loop
                            }
                        }
                    }
                    if (i > 2) {
                        if (j < 4) {
                            if (bottoni[i][j].getText().equals(bottoni[i - 1][j + 1].getText()) &&
                                bottoni[i][j].getText().equals(bottoni[i - 2][j + 2].getText()) &&
                                bottoni[i][j].getText().equals(bottoni[i - 3][j + 3].getText())) {
                                if (bottoni[i][j].getText().equals("R")) {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Vincitore");
                                    alert.setContentText("Ha vinto il rosso!");
                                    alert.showAndWait();
                                    contRosso++;
                                    disable("Rosso");
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Vincitore");
                                    alert.setContentText("Ha vinto il blu!");
                                    alert.showAndWait();
                                    contBlu++;
                                    disable("Blu");
                                }
                                winnerFound = true; // Winner found, set the flag
                                break; // Exit the inner loop
                            }
                        }
                    }
                    if (j < 4) {
                        if (bottoni[i][j].getText().equals(bottoni[i][j + 1].getText()) &&
                            bottoni[i][j].getText().equals(bottoni[i][j + 2].getText()) &&
                            bottoni[i][j].getText().equals(bottoni[i][j + 3].getText())) {
                            if (bottoni[i][j].getText().equals("R")) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Vincitore");
                                alert.setContentText("Ha vinto il rosso!");
                                alert.showAndWait();
                                contRosso++;
                                disable("Rosso");
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Vincitore");
                                alert.setContentText("Ha vinto il blu!");
                                alert.showAndWait();
                                contBlu++;
                                disable("Blu");
                            }
                            winnerFound = true; // Winner found, set the flag
                            break; // Exit the inner loop
                        }
                    }
                    if (i < 3) {
                        if (bottoni[i][j].getText().equals(bottoni[i + 1][j].getText()) &&
                            bottoni[i][j].getText().equals(bottoni[i + 2][j].getText()) &&
                            bottoni[i][j].getText().equals(bottoni[i + 3][j].getText())) {
                            if (bottoni[i][j].getText().equals("R")) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Vincitore");
                                alert.setContentText("Ha vinto il rosso!");
                                alert.showAndWait();
                                contRosso++;
                                disable("Rosso");
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Vincitore");
                                alert.setContentText("Ha vinto il blu!");
                                alert.showAndWait();
                                contBlu++;
                                disable("Blu");
                            }
                            winnerFound = true; // Winner found, set the flag
                            break; // Exit the inner loop
                        }
                    }
                }
            }

            if (winnerFound) {
                break; // Exit the outer loop
            }
        }
    }


    public void disable(String winner) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                bottoni[i][j].setDisable(true);
            }
        }
        np.setDisable(false);
        save_file(winner);
    }

    private void openWindow(String fileFxml, String title, int width, int height, boolean resiz) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fileFxml));
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(resiz);
        stage.show();
    }

    private void save_file(String winner) {
        try {
            FileWriter fw = new FileWriter(".\\src\\main\\java\\com\\forza4\\save.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contRosso + "\n" + contBlu);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}