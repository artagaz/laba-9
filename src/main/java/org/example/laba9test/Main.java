package org.example.laba9test;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //1
        TextField leftText = new TextField(" ");
        leftText.setLayoutX(100);
        leftText.setLayoutY(100);
        leftText.setPrefWidth(200);
        leftText.setPrefHeight(50);
        TextField rightText = new TextField(" ");
        rightText.setLayoutX(350);
        rightText.setLayoutY(100);
        rightText.setPrefWidth(200);
        rightText.setPrefHeight(50);

        ImageView arrow = new ImageView();
        arrow.setImage(new Image("file:arrow.png"));
        arrow.setLayoutX(300);
        arrow.setLayoutY(100);
        arrow.setFitWidth(50);
        arrow.setFitHeight(50);

        Button btnSwap = new Button();
        btnSwap.setText("swap");
        btnSwap.setLayoutX(250);
        btnSwap.setLayoutY(160);
        btnSwap.setPrefWidth(150);
        btnSwap.setOnAction(event -> {
            String cache = leftText.getText();
            leftText.setText(rightText.getText());
            rightText.setText(cache);
            arrow.setRotate(arrow.getRotate() + 180);
        });

        Group swapGroup = new Group(btnSwap, leftText, rightText, arrow);

        //2
        ImageView widgetArrow = new ImageView();
        widgetArrow.setImage(new Image("file:arrow.png"));
        widgetArrow.setLayoutX(10);
        widgetArrow.setLayoutY(100);
        widgetArrow.setFitWidth(50);
        widgetArrow.setFitHeight(50);

        TextField widgetText = new TextField(" ");
        widgetText.setLayoutX(100);
        widgetText.setLayoutY(100);
        widgetText.setPrefWidth(100);
        widgetText.setPrefHeight(50);

        Button widgetBtn = new Button();
        widgetBtn.setText("click me");
        widgetBtn.setLayoutX(250);
        widgetBtn.setLayoutY(75);
        widgetBtn.setPrefWidth(100);
        widgetBtn.setPrefHeight(100);
        widgetBtn.setOnAction(event -> widgetBtn.setText("Hello!"));

        CheckBox widgetArrowCheckBox = new CheckBox("arrow");
        widgetArrowCheckBox.setSelected(true);
        widgetArrowCheckBox.setLayoutX(10);
        widgetArrowCheckBox.setLayoutY(10);
        widgetArrowCheckBox.setOnAction(event -> widgetArrow.visibleProperty().set(widgetArrowCheckBox.isSelected()));

        CheckBox widgetTextFieldCheckBox = new CheckBox("text field");
        widgetTextFieldCheckBox.setSelected(true);
        widgetTextFieldCheckBox.setLayoutX(100);
        widgetTextFieldCheckBox.setLayoutY(10);
        widgetTextFieldCheckBox.setOnAction(event -> widgetText.visibleProperty().set(widgetTextFieldCheckBox.isSelected()));

        CheckBox widgetBtnCheckBox = new CheckBox("button");
        widgetBtnCheckBox.setSelected(true);
        widgetBtnCheckBox.setLayoutX(250);
        widgetBtnCheckBox.setLayoutY(10);
        widgetBtnCheckBox.setOnAction(event -> widgetBtn.visibleProperty().set(widgetBtnCheckBox.isSelected()));

        Group widgetGroup = new Group(widgetArrow, widgetText, widgetBtn, widgetArrowCheckBox, widgetTextFieldCheckBox, widgetBtnCheckBox);

        //3
        Text McCrispy = new Text("Spicy McCrispy $5.49");
        AtomicInteger AmountMcCrispy = new AtomicInteger();
        Text McCrispyCount = new Text(AmountMcCrispy + "pcs");

        Button removeMcCrispy = new Button();
        removeMcCrispy.setText("-");
        removeMcCrispy.setOnAction(event -> {
            AmountMcCrispy.getAndDecrement();
            McCrispyCount.setText(AmountMcCrispy + "pcs");
            if (AmountMcCrispy.get()<2) removeMcCrispy.setVisible(false);
        });
        removeMcCrispy.setVisible(false);
        Button addMcCrispy = new Button();
        addMcCrispy.setText("+");
        addMcCrispy.setOnAction(event -> {
            AmountMcCrispy.getAndIncrement();
            McCrispyCount.setText(AmountMcCrispy + "pcs");
            if (AmountMcCrispy.get()>1) removeMcCrispy.setVisible(true);
        });
        addMcCrispy.setVisible(false);

        CheckBox McCrispyCheckBox = new CheckBox();
        McCrispyCheckBox.setSelected(false);
        McCrispyCheckBox.setOnAction(event -> {
            if (McCrispyCheckBox.isSelected()) {
                McCrispyCount.setText(1 + "pcs");
                AmountMcCrispy.getAndIncrement();
            } else {
                McCrispyCount.setText(0 + "pcs");
                AmountMcCrispy.set(0);
            };
            addMcCrispy.setVisible(McCrispyCheckBox.isSelected());
            removeMcCrispy.setVisible(McCrispyCheckBox.isSelected());
        });

        FlowPane McCrispyPane = new FlowPane(10, 10, McCrispy, McCrispyCount, McCrispyCheckBox, addMcCrispy, removeMcCrispy);

        Text BigMac = new Text("Big Mac $5.29");
        AtomicInteger AmountBigMac = new AtomicInteger();
        Text BigMacCount = new Text(AmountBigMac + "pcs");

        Button removeBigMac = new Button();
        removeBigMac.setText("-");
        removeBigMac.setOnAction(event -> {
            AmountBigMac.getAndDecrement();
            BigMacCount.setText(AmountBigMac + "pcs");
            if (AmountBigMac.get()<2) removeBigMac.setVisible(false);
        });
        removeBigMac.setVisible(false);
        Button addMBigMac = new Button();
        addMBigMac.setText("+");
        addMBigMac.setOnAction(event -> {
            AmountBigMac.getAndIncrement();
            BigMacCount.setText(AmountBigMac + "pcs");
            if (AmountBigMac.get()>1) removeBigMac.setVisible(true);
        });
        addMBigMac.setVisible(false);

        CheckBox BigMacCheckBox = new CheckBox();
        BigMacCheckBox.setSelected(false);
        BigMacCheckBox.setOnAction(event -> {
            if (BigMacCheckBox.isSelected()) {
                BigMacCount.setText(1 + "pcs");
                AmountBigMac.getAndIncrement();
            } else {
                BigMacCount.setText(0 + "pcs");
                AmountBigMac.set(0);
            };
            addMBigMac.setVisible(BigMacCheckBox.isSelected());
            removeBigMac.setVisible(BigMacCheckBox.isSelected());
        });

        FlowPane BigMacPane = new FlowPane(10, 10, BigMac, BigMacCount, BigMacCheckBox, addMBigMac, removeBigMac);

        Text Nuggets = new Text("Chicken McNuggets $2.99");
        AtomicInteger AmountNuggets = new AtomicInteger();
        Text NuggetsCount = new Text(AmountNuggets + "pcs");

        Button removeNuggets = new Button();
        removeNuggets.setText("-");
        removeNuggets.setOnAction(event -> {
            AmountNuggets.getAndDecrement();
            NuggetsCount.setText(AmountNuggets + "pcs");
            if (AmountNuggets.get()<2) removeNuggets.setVisible(false);
        });
        removeNuggets.setVisible(false);
        Button addNuggets = new Button();
        addNuggets.setText("+");
        addNuggets.setOnAction(event -> {
            AmountNuggets.getAndIncrement();
            NuggetsCount.setText(AmountNuggets + "pcs");
            if (AmountNuggets.get()>1) removeNuggets.setVisible(true);
        });
        addNuggets.setVisible(false);

        CheckBox NuggetsCheckBox = new CheckBox();
        NuggetsCheckBox.setSelected(false);
        NuggetsCheckBox.setOnAction(event -> {
            if (NuggetsCheckBox.isSelected()) {
                NuggetsCount.setText(1 + "pcs");
                AmountNuggets.getAndIncrement();
            } else {
                NuggetsCount.setText(0 + "pcs");
                AmountNuggets.set(0);
            };
            addNuggets.setVisible(NuggetsCheckBox.isSelected());
            removeNuggets.setVisible(NuggetsCheckBox.isSelected());
        });

        FlowPane NuggetsPane = new FlowPane(10, 10, Nuggets, NuggetsCount, NuggetsCheckBox, addNuggets, removeNuggets);

        Text Coffee = new Text("Iced Coffee $2.19");
        AtomicInteger AmountCoffee = new AtomicInteger();
        Text CoffeeCount = new Text(AmountCoffee + "pcs");

        Button removeCoffee = new Button();
        removeCoffee.setText("-");
        removeCoffee.setOnAction(event -> {
            AmountCoffee.getAndDecrement();
            CoffeeCount.setText(AmountCoffee + "pcs");
            if (AmountCoffee.get()<2) removeCoffee.setVisible(false);
        });
        removeCoffee.setVisible(false);
        Button addCoffee = new Button();
        addCoffee.setText("+");
        addCoffee.setOnAction(event -> {
            AmountCoffee.getAndIncrement();
            CoffeeCount.setText(AmountCoffee + "pcs");
            if (AmountCoffee.get()>1) removeCoffee.setVisible(true);
        });
        addCoffee.setVisible(false);

        CheckBox CoffeeCheckBox = new CheckBox();
        CoffeeCheckBox.setSelected(false);
        CoffeeCheckBox.setOnAction(event -> {
            if (CoffeeCheckBox.isSelected()) {
                CoffeeCount.setText(1 + "pcs");
                AmountCoffee.getAndIncrement();
            } else {
                CoffeeCount.setText(0 + "pcs");
                AmountCoffee.set(0);
            };
            addCoffee.setVisible(CoffeeCheckBox.isSelected());
            removeCoffee.setVisible(CoffeeCheckBox.isSelected());
        });

        FlowPane CoffeePane = new FlowPane(10, 10, Coffee, CoffeeCount, CoffeeCheckBox, addCoffee, removeCoffee);

        Button total = new Button();
        Text totalText = new Text ();
        total.setText("=TOTAL=");
        total.setOnAction(event -> {
            totalText.setText("Spicy McCrispy: " + AmountMcCrispy.get() + "x$5.49=$" + AmountMcCrispy.get()*5.49 + "\n"
                    + "Big Mac: " + AmountBigMac.get() + "x$5.29=$" + AmountBigMac.get()*5.29 + "\n"
                    + "Chicken McNuggets: " + AmountNuggets.get() + "x$2.99=$" + AmountMcCrispy.get()*2.99 + "\n"
                    + "Iced Coffee: " + AmountCoffee.get() + "x$2.19=$" + AmountMcCrispy.get()*2.19 + "\n"
                    + "TOTAL: $" + (AmountMcCrispy.get()*5.49 + AmountBigMac.get()*5.29 + AmountMcCrispy.get()*2.99 + AmountMcCrispy.get()*2.19));
        });
        FlowPane totalPane = new FlowPane(Orientation.VERTICAL, total, totalText);

        FlowPane menu = new FlowPane(Orientation.VERTICAL, McCrispyPane, BigMacPane, NuggetsPane, CoffeePane, totalPane);
        Group menuGroup = new Group(menu);

        //constructor
        Scene scene = getScene(stage, swapGroup, widgetGroup, menuGroup);
        stage.setScene(scene);
        stage.setTitle("Selector");
        stage.setMinHeight(300);
        stage.setMinWidth(650);
        stage.show();
    }

    private static Scene getScene(Stage stage, Group swapGroup, Group widgetGroup, Group menuGroup) {
        Button select1 = new Button();
        select1.setText("#1");
        select1.setLayoutX(0);
        select1.setLayoutY(10);
        select1.setPrefWidth(150);
        select1.setPrefHeight(20);
        select1.setOnAction(event -> {
            Scene swapScene = new Scene(swapGroup);
            stage.setScene(swapScene);
            stage.setTitle("Перекидыватель слов");
        });

        Button select2 = new Button();
        select2.setText("#2");
        select2.setLayoutX(0);
        select2.setLayoutY(40);
        select2.setPrefWidth(150);
        select2.setPrefHeight(20);
        select2.setOnAction(event -> {
            Scene widgetScene = new Scene(widgetGroup);
            stage.setScene(widgetScene);
            stage.setTitle("Виджеты");
        });

        Button select3 = new Button();
        select3.setText("#3");
        select3.setLayoutX(0);
        select3.setLayoutY(70);
        select3.setPrefWidth(150);
        select3.setPrefHeight(20);
        select3.setOnAction(event -> {
            Scene swapScene = new Scene(menuGroup);
            stage.setScene(swapScene);
            stage.setTitle("Меню");
        });

        Group Selector = new Group(select1, select2, select3);
        return new Scene(Selector);
    }
}