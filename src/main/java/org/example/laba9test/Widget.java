package org.example.laba9test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class Widget extends Application {

    public TextField text;
    public Button btn;
    public CheckBox imgCheckBox;
    public CheckBox textCheckBox;
    public CheckBox btnCheckBox;
    public Button imgBtn;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Widget.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Widget");
        stage.show();
    }

    public void imgCheckBox(ActionEvent actionEvent) {
        imgBtn.setVisible(imgCheckBox.isSelected());
    }

    public void textCheckBox(ActionEvent actionEvent) {
        text.setVisible(textCheckBox.isSelected());
    }

    public void btnCheckBox(ActionEvent actionEvent) {
        btn.setVisible(btnCheckBox.isSelected());
    }
}
