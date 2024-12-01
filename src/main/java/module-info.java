module org.example.laba9test {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.laba9test to javafx.fxml;
    exports org.example.laba9test;
}