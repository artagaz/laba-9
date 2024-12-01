package org.example.laba9test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.regex.Pattern;

public class CalulatorController {
    public Label console;

    @FXML
    private Label operationText;
    protected String input = "";
    protected String operation = "";
    protected double number1 = 0;

    public void operationController() {
        switch (operation) {
            case "+":
                number1 += Double.parseDouble(input);
                break;
            case "-":
                number1 -= Double.parseDouble(input);
                break;
            case "*":
                number1 *= Double.parseDouble(input);
                break;
            case "/":
                number1 /= Double.parseDouble(input);
                break;
        }
    }

    @FXML
    protected void ButtonAction(javafx.event.ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button.getText().matches("[0-9.]")) {
            input += button.getText();
        }
        else if (button.getText().matches("[+\\- */]")) {
            operation = button.getText();
            if ( Pattern.compile("[+\\- */]").matcher(operationText.getText()).find()) {
                operationText.setText(operationText.getText().substring(0, operationText.getText().length() -1));
            }
            if (!input.isEmpty()) {
                operationController();
                input = "";
            }
            else {
                number1 = Double.parseDouble(operationText.getText());
                input = "";
            }

            console.setText(input);
        }
        else if (button.getText().equals("=")){
            operationController();
            input = "";

            operationText.setText(String.valueOf(number1));
            return;
        }

        operationText.setText(operationText.getText() + button.getText());

    }

    public void Clear(ActionEvent actionEvent) {
        operationText.setText("");
        input = "";
        number1 = 0;
        operation = "";
        console.setText("0");
    }

    public void backspace(ActionEvent actionEvent) {
        operationText.setText(operationText.getText().substring(0, operationText.getText().length() -1));
        input =  input.substring(0, input.length() -1);
    }
}