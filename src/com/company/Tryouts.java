package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tryouts extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    void increaseSpringSize(ArrayList<Line> arr)
    {
        Double height=50.0/13.0;
        ArrayList<Double> temp=new ArrayList<>();
        temp.add(0.0);  temp.add(0.0);
        System.out.println("Initialized the method data");
        temp.set(0,arr.get(0).getStartY());
        temp.set(1,arr.get(0).getEndY());

        arr.get(0).setStartY(arr.get(0).getStartY()-height);
        arr.get(0).setEndY(arr.get(0).getEndY()-height);


        for(int u=1;u<12;u++)
        {
            arr.get(u).setStartY(temp.get(0));
            arr.get(u).setEndY(temp.get(1));

            temp.set(0,arr.get(u).getStartY());
            temp.set(1,arr.get(u).getEndY());
            System.out.println(temp.toString());


        }
        System.out.println(temp.toString());




    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {


        Group gp=new Group();
        Ellipse ell=new Ellipse(100,400,50,50);
        ell.setFill(Color.GRAY);
        Label lbl=new Label("Oval");
//        Line l1=new Line(100,451,400,450);
        Line l1=new Line(400,450,100,451);
        l1.setStroke(Color.BLACK);l1.setStrokeWidth(3);
        Line l2=new Line(400,450,100,480);
        l2.setStrokeWidth(3);l2.setStroke(Color.BLACK);
//        Line l3=new Line(100,480,400,500);
        Line l3=new Line(400,500,100,480);
        l3.setStroke(Color.BLACK);l3.setStrokeWidth(3);
        Line l4=new Line(400,500,100,520);
        l4.setStroke(Color.BLACK);l4.setStrokeWidth(3);
//        Line l5=new Line(100,520,400,540);
        Line l5=new Line(400,540,100,520);
        l5.setStroke(Color.BLACK);l5.setStrokeWidth(3);
        Line l6=new Line(400,540,100,550);
        l6.setStroke(Color.BLACK);l6.setStrokeWidth(3);
//        Line l7=new Line(100,550,400,590);
        Line l7=new Line(400,590,100,550);
        l7.setStroke(Color.BLACK);l7.setStrokeWidth(3);
        Line l8=new Line(400,590,100,600);
        l8.setStroke(Color.BLACK);l8.setStrokeWidth(3);
//        Line l9=new Line(100,600,400,640);
        Line l9=new Line(400,640,100,600);
        l9.setStroke(Color.BLACK);l9.setStrokeWidth(3);
        Line l10=new Line(400,640,100,640);
        l10.setStroke(Color.BLACK);l10.setStrokeWidth(3);
//        Line l11=new Line(100,640,400,670);
        Line l11=new Line(400,670,100,640);
        l11.setStroke(Color.BLACK);l11.setStrokeWidth(3);
        Line l12=new Line(400,670,100,690);
        l12.setStroke(Color.BLACK);l12.setStrokeWidth(3);
//        Line l13=new Line(100,690,400,720);
        Line l13=new Line(400,720,100,690);
        l12.setStroke(Color.BLACK);l12.setStrokeWidth(3);



        gp.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);

        List<Line> liness;
        liness= Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        ArrayList<Line> lines=new ArrayList<Line> (liness);

        PauseTransition wait=new PauseTransition(Duration.millis(1000));
        wait.play();
        increaseSpringSize(lines);



        Scene sc=new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setTitle("250");
        primaryStage.show();

    }
}
