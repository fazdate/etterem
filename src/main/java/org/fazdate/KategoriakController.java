package org.fazdate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class KategoriakController {

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

    public void pressButtonEloetelek(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("ELŐÉTELEK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonLevesek(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("LEVESEK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonFoFogasok(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("FŐ FOGÁSOK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonGyerekek(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("GYEREKEK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonHusmentes(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("HÚSMENTES");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonSalatak(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("SALÁTÁK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonKetSzemelyes(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("2 SZEMÉLYES");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonDesszertek(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("DESSZERTEK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonAlkoholmentes(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("ALKOHOLMENTES");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonSor(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("SÖR");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonRovid(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("RÖVID");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonBor(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("BOR");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonPezsgo(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("PEZSGŐ");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }

    public void pressButtonMelengetok(MouseEvent mouseEvent) throws Exception {
        RendelesController.setKategoria("MELENGETŐK");
        Parent window = FXMLLoader.load(getClass().getResource("Rendeles.fxml"));
        Stage stage = App.parentWindow;
        stage.setTitle("Rendelés");
        stage.getScene().setRoot(window);
        stage.setMaximized(true);
        stage.show();
    }
}
