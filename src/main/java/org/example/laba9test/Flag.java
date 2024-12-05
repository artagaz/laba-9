package org.example.laba9test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class Flag extends Application {
    public Rectangle Strip1;
    public Rectangle Strip2;
    public Rectangle Strip3;

    public ToggleGroup Strip1RadioButton;
    public ToggleGroup Strip2RadioButton;
    public ToggleGroup Strip3RadioButton;

    Paint Color(RadioButton button) {

        return switch (button.getText()) {
            case "красненький" -> Paint.valueOf("red");
            case "зелёненький" -> Paint.valueOf("green");
            case "синенький" -> Paint.valueOf("blue");
            case "фиолетовый" -> Paint.valueOf("purple");
            default -> Paint.valueOf("black");
        };
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Flag.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Flag");
        stage.show();
    }

    public void Draw(ActionEvent actionEvent) {
        if (Strip1RadioButton.getSelectedToggle() != null) {
            Strip1.setVisible(true);
            Strip1.setFill(Color((RadioButton) Strip1RadioButton.getSelectedToggle()));
        }
        if (Strip2RadioButton.getSelectedToggle() != null) {
            Strip2.setVisible(true);
            Strip2.setFill(Color((RadioButton) Strip2RadioButton.getSelectedToggle()));
        }
        if (Strip3RadioButton.getSelectedToggle() != null) {
            Strip3.setVisible(true);
            Strip3.setFill(Color((RadioButton) Strip3RadioButton.getSelectedToggle()));
        }

        Button button = (Button) actionEvent.getSource();
        if (button.getText().equals("Draw again")) {
            Strip1.setVisible(false);
            Strip2.setVisible(false);
            Strip3.setVisible(false);
            button.setText("Draw");
        }
        else button.setText("Draw again");

    }
}
