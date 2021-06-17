package com.company;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.lang.management.GarbageCollectorMXBean;

public class Tryouts extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group gp=new Group();
        Line ln1=new Line(100,431,400,445);
//        ln1.setFill(Color.SEAGREEN);
        ln1.setStroke(Color.GOLD);
        ln1.setStrokeWidth(5);
        gp.getChildren().add(ln1);

        Scene sc=new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setTitle("250");
        primaryStage.show();

    }
}
