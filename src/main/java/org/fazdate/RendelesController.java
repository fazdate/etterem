package org.fazdate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fazdate.etterem.Etel;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static org.fazdate.App.asztalok;

public class RendelesController implements Initializable {

    @FXML
    private ListView<String> etelekLista;
    @FXML
    private ListView<String> asztalokLista;
    @FXML
    private Spinner<Integer> mySpinner;
    private SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> items2 = FXCollections.observableArrayList();
    private static String kategoria;

    private Etel etel = new Etel("ELŐÉTELEK", 0);
    private static Etel etel2;
    static {
        try {
            etel2 = new Etel("ELŐÉTELEK", 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<ArrayList<Etel>> etelek;
    static {
        try {
            etelek = etel2.getEtelek();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<Etel> eloetelek = etel.getEloetelek();
    private ArrayList<Etel> levesek = etel.getLevesek();
    private ArrayList<Etel> foFogasok = etel.getFoFogasok();
    private ArrayList<Etel> gyerekek = etel.getGyerekekKedvere();
    private ArrayList<Etel> husmentes = etel.getHusmentes();
    private ArrayList<Etel> salatak = etel.getSalatak();
    private ArrayList<Etel> ketszemelyes = etel.getKetSzemelyes();
    private ArrayList<Etel> desszertek = etel.getDesszertek();
    private ArrayList<Etel> alkoholmentes = etel.getAlkoholmentesek();
    private ArrayList<Etel> sorok = etel.getSorok();
    private ArrayList<Etel> rovidek = etel.getRovidek();
    private ArrayList<Etel> borok = etel.getBorok();
    private ArrayList<Etel> pezsgok = etel.getPezsgok();
    private ArrayList<Etel> melengetok = etel.getMelengetok();

    public RendelesController() throws IOException, ParseException { }

    public static void setKategoria(String kategoria) {
        RendelesController.kategoria = kategoria;
    }

    @Override
    // ViewList-hez elemek hozzáadása
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rendeles.fxml"));
        etelekLista.setItems(items);
        asztalokLista.setItems(items2);
        for (int i = 0; i < asztalok.size(); i++)
            items2.add(asztalok.get(i).getNev());
        etelInit();
        // A ViewList elemeinek száma alapján határozza meg a ViewList magasságát.
        etelekLista.setPrefHeight(items.size() * 24);
        asztalokLista.setPrefHeight(items2.size() * 24);

        // Mennyiség beállításáért felel
        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
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

    private void etelInit() {
        items.clear();
        switch (kategoria) {
            case "ELŐÉTELEK":
                for (int i = 0; i < eloetelek.size(); i++)
                    items.add(eloetelek.get(i).getNev());
                break;

            case "LEVESEK":
                for (int i = 0; i < levesek.size(); i++)
                    items.add(levesek.get(i).getNev());
                break;

            case "FŐ FOGÁSOK":
                for (int i = 0; i < foFogasok.size(); i++)
                    items.add(foFogasok.get(i).getNev());
                break;

            case "GYEREKEK":
                for (int i = 0; i < gyerekek.size(); i++)
                    items.add(gyerekek.get(i).getNev());
                break;

            case "HÚSMENTES":
                for (int i = 0; i < husmentes.size(); i++)
                    items.add(husmentes.get(i).getNev());
                break;

            case "SALÁTÁK":
                for (int i = 0; i < salatak.size(); i++)
                    items.add(salatak.get(i).getNev());
                break;

            case "2 SZEMÉLYES":
                for (int i = 0; i < ketszemelyes.size(); i++)
                    items.add(ketszemelyes.get(i).getNev());
                break;

            case "DESSZERTEK":
                for (int i = 0; i < desszertek.size(); i++)
                    items.add(desszertek.get(i).getNev());
                break;

            case "ALKOHOLMENTES":
                for (int i = 0; i < alkoholmentes.size(); i++)
                    items.add(alkoholmentes.get(i).getNev());
                break;

            case "SÖR":
                for (int i = 0; i < sorok.size(); i++)
                    items.add(sorok.get(i).getNev());
                break;

            case "RÖVID":
                for (int i = 0; i < rovidek.size(); i++)
                    items.add(rovidek.get(i).getNev());
                break;

            case "BOR":
                for (int i = 0; i < borok.size(); i++)
                    items.add(borok.get(i).getNev());
                break;

            case "PEZSGŐ":
                for (int i = 0; i < pezsgok.size(); i++)
                    items.add(pezsgok.get(i).getNev());
                break;

            case "MELENGETŐK":
                for (int i = 0; i < melengetok.size(); i++)
                    items.add(melengetok.get(i).getNev());
                break;

            default:
                for (int i = 0; i < etelek.size(); i++)
                    for (int j = 0; j < etelek.get(i).size(); j++)
                        items.add(etelek.get(i).get(j).getNev());
        }
    }

    public void pressButtonRendeles(MouseEvent mouseEvent) throws IOException, ParseException {
        // Az etelek listában megkeressük a ListViewban kiválasztott ételt, és egy külön változóba mentjük azt
        String etel = etelekLista.getSelectionModel().getSelectedItem();
        int etelI = 0;
        int etelJ = 0;
        outerloop:
        for (int i = 0; i < etelek.size(); i++)
            for (int j = 0; j < etelek.get(i).size(); j++)
                if (etel == etelek.get(i).get(j).getNev()) {
                    etelI = i;
                    etelJ = j;
                    break outerloop;
                }
        Etel kaja = etelek.get(etelI).get(etelJ);

        // A ListViewban kiválasztott asztal-t lekérjük, majd a 6. karaktertől számítva létrehozunk egy változót,
        // ami az asztalok ArrayListben lévő pozíciót fogja megadni
        String asztal = asztalokLista.getSelectionModel().getSelectedItem();
        int asztalId = Integer.parseInt(asztal.substring(6)) - 1;

        // A spinner értékét lekérjük
        int SpinnerValue = mySpinner.getValue();

        // Mennyiségszer hozzáadjuk az ételt az asztal listájához
        for (int i = 0; i < SpinnerValue; i++)
            asztalok.get(asztalId).setRendeles(kaja);
        asztalok.get(asztalId).setFoglalt(true);

        // Visszaállítja a mennyiséget 1-re
        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
    }
}
