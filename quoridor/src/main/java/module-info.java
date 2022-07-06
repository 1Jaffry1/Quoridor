module com.example.quoridor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.quoridor to javafx.fxml;
    exports com.example.quoridor;
}