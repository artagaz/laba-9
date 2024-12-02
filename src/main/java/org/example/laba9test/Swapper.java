package org.example.laba9test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class Swapper extends Application {
    public TextField input1;
    public TextField input2;
    public Button btn;
    boolean flag = false;


    public void swap(ActionEvent actionEvent) {
        String temp = input1.getText();
        input1.setText(input2.getText());
        input2.setText(temp);
        btn.setRotate(btn.getRotate() + 180);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Swapper.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator");

        stage.show();
    }
}
