package com.company;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Stack;

class Bits extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private int change = 0;
    private Stack<Rectangle> removedPez = new Stack<>();

    public synchronized void pop(Rectangle rect)  {
        TranslateTransition tt3 = new TranslateTransition(Duration.seconds(1), rect);
        tt3.setByY(360-change);

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), rect);
        tt2.setByX(240);

        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), rect);
        tt1.setByX(100);
        tt1.setByY(-55);

        TranslateTransition tt0 = new TranslateTransition(Duration.millis(1000), rect);
        tt0.setByY(-60);
        tt0.setOnFinished(e ->{
            tt1.setOnFinished(e1 -> {
                tt2.setOnFinished(e2 -> {
                    tt3.play();
                });
                tt2.play();
            });
            tt1.play();
        });
        tt0.play();
        change += 35;
        removedPez.add(rect);
    }

    public synchronized void push(Rectangle rectangle) {
        change -= 35;
        TranslateTransition tt0 = new TranslateTransition(Duration.seconds(1), rectangle);
        tt0.setByY(-360+change);

        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), rectangle);
        tt1.setByX(-240);

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), rectangle);
        tt2.setByX(-100);
        tt2.setByY(55);

        TranslateTransition tt3 = new TranslateTransition(Duration.millis(1000), rectangle);
        tt3.setByY(60);
        tt0.setOnFinished(e ->{
            tt1.setOnFinished(e1 -> {
                tt2.setOnFinished(e2 -> tt3.play());
                tt2.play();
            });
            tt1.play();
        });
        tt0.play();
    }

    @Override
    public void start(Stage primaryStage) {
        Line line0 = new Line(50, 100, 50, 500);
        line0.setStrokeWidth(3);
        Line line1 = new Line(50, 500, 350, 500);
        line1.setStrokeWidth(3);
        Line line2 = new Line(350, 500, 350, 200);
        line2.setStrokeWidth(3);
        Line line3 = new Line(50, 100, 350, 100);
        line3.setStrokeWidth(3);
        Line line4 = new Line(50, 157, 160, 100);
        line4.setStrokeWidth(3);

        Text heading = new Text("Pez Dispenser to simulate the working of a Stack data structure");
        heading.setLayoutX(50);
        heading.setLayoutY(20);
        heading.setFont(Font.font("Liberation Serif", FontWeight.BOLD, 24));

        Text message = new Text();
        message.setLayoutY(35);
        message.setLayoutX(80);

        Rectangle pez0 = new Rectangle(55, 465, 290, 30);
        pez0.setFill(Color.DODGERBLUE);
        Rectangle pez1 = new Rectangle(55, 430, 290, 30);
        pez1.setFill(Color.DODGERBLUE);
        Rectangle pez2 = new Rectangle(55, 395, 290, 30);
        pez2.setFill(Color.DODGERBLUE);
        Rectangle pez3 = new Rectangle(55, 360, 290, 30);
        pez3.setFill(Color.DODGERBLUE);
        Rectangle pez4 = new Rectangle(55, 325, 290, 30);
        pez4.setFill(Color.DODGERBLUE);
        Rectangle pez5 = new Rectangle(55, 290, 290, 30);
        pez5.setFill(Color.DODGERBLUE);
        Rectangle pez6 = new Rectangle(55, 255, 290, 30);
        pez6.setFill(Color.DODGERBLUE);
        Rectangle pez7 = new Rectangle(55, 220, 290, 30);
        pez7.setFill(Color.DODGERBLUE);

        Stack<Rectangle> pezStack = new Stack<>();
        pezStack.add(pez0);
        pezStack.add(pez1);
        pezStack.add(pez2);
        pezStack.add(pez3);
        pezStack.add(pez4);
        pezStack.add(pez5);
        pezStack.add(pez6);
        pezStack.add(pez7);

        HBox buttonBar = new HBox();
        buttonBar.setSpacing(20);
        buttonBar.setLayoutX(25);
        buttonBar.setLayoutY(550);

        Button popButton = new Button("Pop");
        popButton.setPrefSize(100, 30);

        popButton.setOnAction(e -> {
            if(pezStack.isEmpty()) {
                message.setText("No more candy left. Try refilling.");
            } else {
                pop(pezStack.pop());
                for (Rectangle rect : pezStack) {
                    TranslateTransition tt0 = new TranslateTransition(Duration.millis(1000), rect);
                    tt0.setByY(-35);
                    tt0.play();
                }
            }
        });

        Button pushButton = new Button("Push");
        pushButton.setPrefSize(100, 30);
        pushButton.setOnAction(e1 -> {
            if (pezStack.size() == 8) {
                message.setText("Candy dispenser is full.");
            } else {
                Rectangle pez = removedPez.pop();
                push(pez);
                for (Rectangle rect : pezStack) {
                    TranslateTransition tt0 = new TranslateTransition(Duration.millis(1000), rect);
                    tt0.setByY(35);
                    tt0.play();
                }
                pezStack.push(pez);
            }
        });

        Button peekButton = new Button("Peek");
        peekButton.setPrefSize(100, 30);

        Button sizeButton = new Button("Size");
        sizeButton.setPrefSize(100, 30);

        Button isEmptyButton = new Button("Empty?");
        isEmptyButton.setPrefSize(100, 30);
        buttonBar.getChildren().addAll(popButton, pushButton, peekButton, sizeButton, isEmptyButton);


        Pane root = new Pane();
        root.setPadding(new Insets(25));
        root.getChildren().addAll(heading, message, line0, line1, line2, line3, line4, pez0, pez1, pez2, pez3,
                pez4, pez5, pez6, pez7, buttonBar);

        primaryStage.setTitle("Pez Dispenser");
        Scene scene = new Scene(root, 750, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
