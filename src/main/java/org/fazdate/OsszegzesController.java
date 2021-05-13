package org.fazdate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fazdate.etterem.Asztal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static org.fazdate.App.asztalok;

public class OsszegzesController implements Initializable {

    @FXML
    private ListView<String> etelekLista;
    @FXML
    private ListView<String> asztalokLista;
    @FXML
    private Label ar;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> items2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        etelekLista.setItems(items);
        asztalokLista.setItems(items2);
        // Asztalok hozzáadása a listview-hoz
        for (int i = 0; i < asztalok.size(); i++)
            items2.add(asztalok.get(i).getNev());
        // Az asztalok kiválasztása alapján a rendelések kiírása az ételek listview-ra
        asztalokLista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int asztalId = Integer.parseInt(t1.substring(6)) - 1;
                items.clear();
                int osszeg = 0;
                // Ételek listview-hoz adása és a végösszeg kiszámolása
                for (int i = 0; i < asztalok.get(asztalId).getRendeles().size(); i++) {
                    items.add(asztalok.get(asztalId).getRendeles().get(i).getNev());
                    osszeg += asztalok.get(asztalId).getRendeles().get(i).getAr();
                }
                // Ár label szövege
                ar.setText(String.valueOf(osszeg) + " Ft");
                // A listview-ok mérete
                etelekLista.setPrefHeight(items.size() * 24);
                asztalokLista.setPrefHeight(items2.size() * 24);
            }
        });
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

    public void OnMouseTorles(MouseEvent mouseEvent) {
        int asztalID = asztalokLista.getSelectionModel().getSelectedIndex();
        int etelID = etelekLista.getSelectionModel().getSelectedIndex();
        asztalok.get(asztalID).getRendeles().remove(etelID);
    }

    public void OnMouseFizetes(MouseEvent mouseEvent) throws IOException {
        int asztalID = asztalokLista.getSelectionModel().getSelectedIndex();
        writeToJSON(asztalok.get(asztalID));
        // Rendelés nullázása
        asztalok.get(asztalID).setFoglalt(false);
        asztalok.get(asztalID).torles();

        Parent window = FXMLLoader.load(getClass().getResource("Asztalok.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Asztalok");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void writeToJSON(Asztal asztal) {

        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < asztal.getRendeles().size(); i++)
            array.add(i, asztal.getRendeles().get(i).getNev());

        obj.put("Asztal", asztal.getNev());
        obj.put("Végösszeg", asztal.osszErtek());
        obj.put("Rendelés", array);

        FileWriter file = null;
        try {
            file = new FileWriter("src/main/java/Vendegek.json", true);
            file.write(obj.toJSONString());
            System.out.println("Sikeresen kilett írva a JSON Objektum...");
            System.out.println("\nJSON Objektum: " + obj);
            }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
