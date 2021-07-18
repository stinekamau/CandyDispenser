package com.company;

import javafx.application.Application;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class workingRate extends Application {
    private int change = 0;
    private final Stack<Rectangle> removedPez = new Stack<>();
    private final Stack<Rectangle> pezStack = new Stack<>();
    private List<Line> lineList;
    private final Stack<Line> poppedLines = new Stack<>();
    int lines = 11;

    public synchronized void pop(Rectangle rect)  {
        TranslateTransition tt3 = new TranslateTransition(Duration.seconds(1), rect);
        tt3.setByY(360-change);

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), rect);
        tt2.setByX(240);

        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), rect);
        tt1.setByX(100);
        tt1.setByY(-55);

        TranslateTransition tt0 = new TranslateTransition(Duration.millis(100), rect);
        tt0.setByY(-60);
        tt0.setOnFinished(e ->{
            spring();
            tt1.setOnFinished(e1 -> {
                tt2.setOnFinished(e2 -> tt3.play());
                tt2.play();
            });
            tt1.play();
        });
        tt0.play();
        change += 35;
        removedPez.add(rect);
        if (pezStack.isEmpty() )
            lines = 41;
    }

    public synchronized void push(Rectangle rectangle) {
        change -= 35;
        TranslateTransition tt0 = new TranslateTransition(Duration.seconds(1), rectangle);
        tt0.setByY(-360+change);

        TranslateTransition tt1 = new TranslateTransition(Duration.millis(1000), rectangle);
        tt1.setByX(-240);

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), rectangle);
        tt2.setByX(-100);
        tt2.setByY(55);

        TranslateTransition tt3 = new TranslateTransition(Duration.millis(1000), rectangle);
        tt3.setByY(60);
        tt0.setOnFinished(e ->{
            tt1.setOnFinished(e1 -> {
                tt2.setOnFinished(e2 -> {
                    // reverseSpring();
                    tt3.play();});
                tt2.play();
            });
            tt1.play();
        });
        tt0.play();

        if (pezStack.size() == 8)
            lines = 11;
    }

    public void spring() {
        double startY;
        Line hold1 = lineList.get(0);
        hold1.setStartY(hold1.getStartY() - 35);
        hold1.setEndY(hold1.getEndY() - 35);
//            poppedLines.add(hold1);
        startY = hold1.getStartY();

        for (int i = 1; i < lineList.size()-1; i++) {
            Line line = lineList.get(i);
            line.setStartY(startY);
            line.setEndY(startY + lines);
            startY = line.getEndY();
            poppedLines.add(line);
        }
        lines += 5;


        Line base1 = lineList.get(lineList.size()-1);
        base1.setStartY(startY);
        poppedLines.add(base1);

//    //reversing stack
//    while (!poppedLines.isEmpty()) {
//        lineList.add(poppedLines.pop());
//    }
    }

    public void reverseSpring() {
        double startY;
        Line hold1 = lineList.get(0);
        hold1.setStartY(hold1.getStartY() + 35);
        hold1.setEndY(hold1.getEndY() + 35);
        poppedLines.add(hold1);
        startY = hold1.getStartY();

        for (int i = 1; i < lineList.size()-1; i++) {
            Line line = lineList.get(i);
            line.setStartY(startY);
            line.setEndY(startY + lines);
            startY = line.getEndY();
            poppedLines.add(line);
        }
        lines -= 5;

        Line base1 = lineList.get(lineList.size()-1);
        base1.setStartY(startY);
        poppedLines.add(base1);
    }

    @Override
    public void start(Stage primaryStage) {
        Line line0 = new Line(50, 100, 50, 535);
        line0.setStrokeWidth(3);
        Line line1 = new Line(50, 535, 350, 535);
        line1.setStrokeWidth(3);
        Line line2 = new Line(350, 535, 350, 200);
        line2.setStrokeWidth(3);
        Line line3 = new Line(50, 100, 350, 100);
        line3.setStrokeWidth(3);
        Line line4 = new Line(50, 157, 160, 100);
        line4.setStrokeWidth(3);

        //Spring
        Line hold = new Line(55, 499, 345, 499);
        hold.setStrokeWidth(3);
        Line spring0 = new Line(200, 499, 55, 504);
        spring0.setStrokeWidth(2);
        Line spring1 = new Line(55, 504, 345, 509);
        spring1.setStrokeWidth(2);
        Line spring2 = new Line(345, 509, 55, 514);
        spring2.setStrokeWidth(2);
        Line spring3 = new Line(55, 514, 345, 519);
        spring3.setStrokeWidth(2);
        Line spring4 = new Line(345, 519, 55, 524);
        spring4.setStrokeWidth(2);
        Line spring5 = new Line(55, 524, 345, 529);
        spring5.setStrokeWidth(2);
        Line base = new Line(345, 529, 200, 534);
        base.setStrokeWidth(2);

        lineList = new ArrayList<>(Arrays.asList(hold, spring0, spring1, spring2, spring3, spring4, spring5, base));

        Text heading = new Text("Pez Dispenser to simulate the working of a Stack data structure");
        heading.setLayoutX(50);
        heading.setLayoutY(20);
        heading.setFont(Font.font("Liberation Serif", FontWeight.BOLD, 24));

        Text message = new Text();
        message.setLayoutY(55);
        message.setLayoutX(80);
        message.setFont(Font.font("Liberation Serif", FontWeight.SEMI_BOLD, 18));

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
                lines = 41;
            } else {
                pop(pezStack.pop());
                for (Rectangle rect : pezStack) {
                    TranslateTransition tt0 = new TranslateTransition(Duration.millis(60), rect);
                    tt0.setByY(-35);
                    tt0.play();
                }
//            if (removedPez.size() == 8)
//                lines = 41;
            }
        });

        Button pushButton = new Button("Push");
        pushButton.setPrefSize(100, 30);
        pushButton.setOnAction(e1 -> {
            if (pezStack.size() == 8) {
                message.setText("Candy dispenser is full.");
                lines = 11;
            } else {
                Rectangle pez = removedPez.pop();
                push(pez);
                for (Rectangle rect : pezStack) {
                    TranslateTransition tt0 = new TranslateTransition(Duration.millis(1000), rect);
                    tt0.setByY(35);
                    tt0.play();
                }
                reverseSpring();
                pezStack.push(pez);
            }
        });

        Button peekButton = new Button("Peek");
        peekButton.setPrefSize(100, 30);
        peekButton.setOnAction(e -> {
            pezStack.peek().setFill(Color.TURQUOISE);
        });

        Button sizeButton = new Button("Size");
        sizeButton.setPrefSize(100, 30);
        sizeButton.setOnAction(e -> {
            message.setText("Size: " +pezStack.size());
        });

        Button isEmptyButton = new Button("Empty?");
        isEmptyButton.setPrefSize(100, 30);
        isEmptyButton.setOnAction(e -> {
            message.setText("Is empty? : " +pezStack.isEmpty());
        });
        buttonBar.getChildren().addAll(popButton, pushButton, peekButton, sizeButton, isEmptyButton);

        Pane root = new Pane();
        root.setPadding(new Insets(25));
        root.getChildren().addAll(heading, message, line0, line1, line2, line3, line4, pez0, pez1, pez2, pez3,
                pez4, pez5, pez6, pez7, hold, spring0, spring1, spring2, spring3, spring4, spring5, base, buttonBar);
        primaryStage.setTitle("Pez Dispenser");
        Scene scene = new Scene(root, 800, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
