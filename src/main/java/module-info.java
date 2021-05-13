module org.fazdate {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens org.fazdate to javafx.fxml;
    exports org.fazdate;
}