package org.example.laba9test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

public class Calc extends Application {

    public Label InputLabel;
    private String input = "0";
    private String operation = "";
    private double number1 = 0;

    void Operation() {
        switch (operation) {
            case "+":
                number1 = number1 + Double.parseDouble(input);
                input = "";
                break;
            case "-":
                number1 = number1 - Double.parseDouble(input);
                input = "";
                break;
            case "*":
                number1 = number1 * Double.parseDouble(input);
                input = "";
                break;
            case "/":
                if (Double.parseDouble(input) == 0) {
                    operation = "";
                    throw new ArithmeticException();
                }
                number1 = number1 / Double.parseDouble(input);
                input = "";
                break;

            default:
                if (number1 == 0) {
                    number1 = Double.parseDouble(input);
                }
                input = "0";
                break;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calc.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calc");
        stage.show();
    }

    public void NumButton(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();
        InputLabel.setText(InputLabel.getText() + e.getText());
        input += e.getText();
    }

    public void OperationButton(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();

        if ("".equals(e.getText())) {
            Operation();
            InputLabel.setText(String.valueOf(number1));
            operation = "";
            input = "0";
            return;
        }

        String WrongSymbol = String.valueOf(InputLabel.getText().charAt(InputLabel.getText().length()-1));
        if (WrongSymbol.matches("[+\\-*/]")) {
            InputLabel.setText(InputLabel.getText().substring(0, InputLabel.getText().length() - 1));
            operation = "";
        }

        InputLabel.setText(InputLabel.getText() + e.getText());

        Operation();

        operation = e.getText();
    }

        public void Clean (ActionEvent actionEvent){
            InputLabel.setText("");
            number1 = 0;
            input = "0";
            operation = "";
        }

        public void CleanOne (ActionEvent actionEvent) {
            if (String.valueOf(InputLabel.getText().charAt(InputLabel.getText().length() - 1)).matches("[+\\-*/]")) {
                operation = "";
            }
            else {input = input.substring(0, input.length() - 1);}
            InputLabel.setText(InputLabel.getText().substring(0, InputLabel.getText().length() - 1));
        }
    }

