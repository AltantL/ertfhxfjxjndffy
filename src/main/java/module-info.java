module org.example.projet2modeletvue {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens org.example.projet2modeletvue to javafx.fxml;
    exports org.example.projet2modeletvue;

    exports vue;
}