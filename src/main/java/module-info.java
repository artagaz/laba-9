module org.example.laba9test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.laba9test to javafx.fxml;
    exports org.example.laba9test;
}