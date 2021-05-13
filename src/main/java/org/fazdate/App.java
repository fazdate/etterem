package org.fazdate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fazdate.etterem.Asztal;
import org.fazdate.etterem.Etel;
import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    public static Stage parentWindow;
    public static ArrayList<Asztal> asztalok = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        asztalInit();
        parentWindow = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Asztalok.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    private void asztalInit() {
        ArrayList<Etel> etel1 = new ArrayList<>();
        ArrayList<Etel> etel2 = new ArrayList<>();
        ArrayList<Etel> etel3 = new ArrayList<>();
        ArrayList<Etel> etel4 = new ArrayList<>();
        ArrayList<Etel> etel5 = new ArrayList<>();
        ArrayList<Etel> etel6 = new ArrayList<>();
        ArrayList<Etel> etel7 = new ArrayList<>();
        ArrayList<Etel> etel8 = new ArrayList<>();
        ArrayList<Etel> etel9 = new ArrayList<>();
        ArrayList<Etel> etel10 = new ArrayList<>();

        asztalok.add(new Asztal("Asztal1", etel1));
        asztalok.add(new Asztal("Asztal2", etel2));
        asztalok.add(new Asztal("Asztal3", etel3));
        asztalok.add(new Asztal("Asztal4", etel4));
        asztalok.add(new Asztal("Asztal5", etel5));
        asztalok.add(new Asztal("Asztal6", etel6));
        asztalok.add(new Asztal("Asztal7", etel7));
        asztalok.add(new Asztal("Asztal8", etel8));
        asztalok.add(new Asztal("Asztal9", etel9));
        asztalok.add(new Asztal("Asztal10", etel10));
    }

    public static void main(String[] args) {
        launch();
    }

}