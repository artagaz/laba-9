package org.example.laba9test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class Menu extends Application {
    public Button OkroshkaPlus;
    public Button OkroshkaMinus;
    public Button PelmeniPlus;
    public Button PelmeniMinus;
    public Button ShaurmaPlus;
    public Button ShaurmaMinus;
    public Button MakaroniPlus;
    public Button MakaroniMinus;
    public TextField OkroshkaCount;
    public TextField PelmeniCount;
    public TextField ShaurmaCount;
    public TextField MakaroniCount;
    public CheckBox Okroshka;
    public CheckBox Pelmeni;
    public CheckBox Shaurma;
    public CheckBox Makaroni;
    public TextArea TotalArea;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
        stage.show();

    }

    public void Okroshka(ActionEvent actionEvent) {
        CheckBox e = (CheckBox) actionEvent.getSource();
        OkroshkaPlus.setVisible(e.isSelected());
        OkroshkaMinus.setVisible(e.isSelected());
        OkroshkaCount.setText(e.isSelected() ? "1" : "Not added");
    }

    public void Pelmneni(ActionEvent actionEvent) {
        CheckBox e = (CheckBox) actionEvent.getSource();
        PelmeniPlus.setVisible(e.isSelected());
        PelmeniMinus.setVisible(e.isSelected());
        PelmeniCount.setText(e.isSelected() ? "1" : "Not added");
    }

    public void Shaurma(ActionEvent actionEvent) {
        CheckBox e = (CheckBox) actionEvent.getSource();
        ShaurmaPlus.setVisible(e.isSelected());
        ShaurmaMinus.setVisible(e.isSelected());
        ShaurmaCount.setText(e.isSelected() ? "1" : "Not added");
    }

    public void Makaroni(ActionEvent actionEvent) {
        CheckBox e = (CheckBox) actionEvent.getSource();
        MakaroniPlus.setVisible(e.isSelected());
        MakaroniMinus.setVisible(e.isSelected());
        MakaroniCount.setText(e.isSelected() ? "1" : "Not added");
    }

    public void OkroshkaBtn(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();
        int count = Integer.parseInt(OkroshkaCount.getText());
        if (e.getText().equals("+")) OkroshkaCount.setText(count + 1 + "");
        else {
            if (count == 1) {
                OkroshkaCount.setText("Not added");
                Okroshka.setSelected(false);
                OkroshkaPlus.setVisible(false);
                OkroshkaMinus.setVisible(false);
                OkroshkaCount.setText("Not added");
                return;
            }
            OkroshkaCount.setText(count - 1 + "");
        }
    }

    public void PelmeniBtn(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();
        int count = Integer.parseInt(PelmeniCount.getText());
        if (e.getText().equals("+")) PelmeniCount.setText(count + 1 + "");
        else {
            if (count == 1) {
                PelmeniCount.setText("Not added");
                Pelmeni.setSelected(false);
                PelmeniPlus.setVisible(false);
                PelmeniMinus.setVisible(false);
                PelmeniCount.setText("Not added");
                return;
            }
            PelmeniCount.setText(count - 1 + "");
        }
    }

    public void ShaurmaBtn(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();
        int count = Integer.parseInt(ShaurmaCount.getText());
        if (e.getText().equals("+")) ShaurmaCount.setText(count + 1 + "");
        else {
            if (count == 1) {
                ShaurmaCount.setText("Not added");
                Shaurma.setSelected(false);
                ShaurmaPlus.setVisible(false);
                ShaurmaMinus.setVisible(false);
                ShaurmaCount.setText("Not added");
                return;
            }
            ShaurmaCount.setText(count - 1 + "");
        }
    }

    public void MakaroniBtn(ActionEvent actionEvent) {
        Button e = (Button) actionEvent.getSource();
        int count = Integer.parseInt(MakaroniCount.getText());
        if (e.getText().equals("+")) MakaroniCount.setText(count + 1 + "");
        else {
            if (count == 1) {
                MakaroniCount.setText("Not added");
                Makaroni.setSelected(false);
                MakaroniPlus.setVisible(false);
                MakaroniMinus.setVisible(false);
                MakaroniCount.setText("Not added");
                return;
            }
            MakaroniCount.setText(count - 1 + "");
        }
    }

    public void TotalBtn(ActionEvent actionEvent) {
        TotalArea.setText("TOTAL:");
        if(Okroshka.isSelected()) {
            int OkroshkaTotal = Integer.parseInt(OkroshkaCount.getText())*500;
            TotalArea.setText(TotalArea.getText() + "\nкрошка: " + OkroshkaCount.getText() + "шт.X500P = " + OkroshkaTotal);
        }
        if(Pelmeni.isSelected()) {
            int PelmeniTotal = Integer.parseInt(PelmeniCount.getText())*600;
            TotalArea.setText(TotalArea.getText() + "\nПельмени с говядиной: " + PelmeniCount.getText() + "шт.X600P = " + PelmeniTotal);
        }
        if(Shaurma.isSelected()) {
            int ShaurmaTotal = Integer.parseInt(ShaurmaCount.getText())*250;
            TotalArea.setText(TotalArea.getText() + "\nШаурма: " + ShaurmaCount.getText() + "шт.X250P = " + ShaurmaTotal);
        }
        if(Makaroni.isSelected()) {
            int MakaroniTotal = Integer.parseInt(MakaroniCount.getText())*350;
            TotalArea.setText(TotalArea.getText() + "\nМакароны по флотски: " + MakaroniCount.getText() + "шт.X350P = " + MakaroniTotal);
        }
    }
}
