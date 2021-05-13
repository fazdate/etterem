package org.fazdate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;;import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static org.fazdate.App.asztalok;

public class AsztalokController implements Initializable {

    @FXML
    private Rectangle Asztal1;
    @FXML
    private Rectangle Asztal2;
    @FXML
    private Rectangle Asztal3;
    @FXML
    private Rectangle Asztal4;
    @FXML
    private Rectangle Asztal5;
    @FXML
    private Rectangle Asztal6;
    @FXML
    private Rectangle Asztal7;
    @FXML
    private Rectangle Asztal8;
    @FXML
    private Rectangle Asztal9;
    @FXML
    private Rectangle Asztal10;

    private ArrayList<Rectangle> rect = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rectInit();
    }

    public void pressButtonAsztalok(ActionEvent event) throws Exception {
        Parent window = FXMLLoader.load(getClass().getResource("Asztalok.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Asztalok");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonKategoriak(ActionEvent event) throws Exception {
        Parent window = FXMLLoader.load(getClass().getResource("Kategoriak.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Kategóriák");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    private void rectInit (){
        rect.add(Asztal1);
        rect.add(Asztal2);
        rect.add(Asztal3);
        rect.add(Asztal4);
        rect.add(Asztal5);
        rect.add(Asztal6);
        rect.add(Asztal7);
        rect.add(Asztal8);
        rect.add(Asztal9);
        rect.add(Asztal10);

    }

    public void onMouseFrissit(MouseEvent mouseEvent) {
        for (int i = 0; i < asztalok.size(); i++) {
            if (asztalok.get(i).isFoglalt())
                rect.get(i).setFill(Color.web("#D16014"));
            else
                rect.get(i).setFill(Color.web("#939F5C"));
        }
    }

    public void onMouseOsszegez(MouseEvent mouseEvent) throws IOException {
        Parent window = FXMLLoader.load(getClass().getResource("Osszegzes.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Összegzés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }
}
