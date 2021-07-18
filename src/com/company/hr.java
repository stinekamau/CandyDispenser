package com.company;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hr extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    void increaseSpringSize(ArrayList<Line> arr)
    {
        Double height=50.0/13;

//        arr.get(0).setStartY(arr.get(0).getStartY()+height);
//        arr.get(0).setEndY(arr.get(0).getEndY()+height);

        for(int i=0;i<arr.size();i++)
        {
            arr.get(i).setStartY(arr.get(i).getStartY()+height*9);
            arr.get(i).setEndY(arr.get(i).getEndY()+height);
        }



//        ArrayList<Double> temp=new ArrayList<>();
//        temp.add(0.0);  temp.add(0.0);
//
//        System.out.println("Initialized the method data");
//        temp.set(0,arr.get(0).getStartY());
//        temp.set(1,arr.get(0).getEndY());
//
//        arr.get(0).setStartY(arr.get(0).getStartY()-height);
//        arr.get(0).setEndY(arr.get(0).getEndY()-height);
//
//
//        for(int u=1;u<12;u++)
//        {
//            arr.get(u).setStartY(temp.get(0));
//            arr.get(u).setEndY(temp.get(1));
//
//            temp.set(0,arr.get(u).getStartY());
//            temp.set(1,arr.get(u).getEndY());
//            System.out.println(temp.toString());
//
//
//        }
//        System.out.println(temp.toString());




    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {


        Group gp=new Group();
        Ellipse ell=new Ellipse(100,400,50,50);
        ell.setFill(Color.GRAY);
////        Line l1=new Line(100,451,400,450);
//        Line l1=new Line(400,450,100,451);
//        l1.setStroke(Color.BLACK);l1.setStrokeWidth(3);
//        Line l2=new Line(400,450,100,480);
//        l2.setStrokeWidth(3);l2.setStroke(Color.BLACK);
////        Line l3=new Line(100,480,400,500);
//        Line l3=new Line(400,480,100,480);
//        l3.setStroke(Color.BLACK);l3.setStrokeWidth(3);
//        Line l4=new Line(400,500,100,520);
//        l4.setStroke(Color.BLACK);l4.setStrokeWidth(3);
////        Line l5=new Line(100,520,400,540);
//        Line l5=new Line(400,540,100,520);
//        l5.setStroke(Color.BLACK);l5.setStrokeWidth(3);
//        Line l6=new Line(400,540,100,550);
//        l6.setStroke(Color.BLACK);l6.setStrokeWidth(3);
////        Line l7=new Line(100,550,400,590);
//        Line l7=new Line(400,590,100,550);
//        l7.setStroke(Color.BLACK);l7.setStrokeWidth(3);
//        Line l8=new Line(400,590,100,600);
//        l8.setStroke(Color.BLACK);l8.setStrokeWidth(3);
////        Line l9=new Line(100,600,400,640);
//        Line l9=new Line(400,640,100,600);
//        l9.setStroke(Color.BLACK);l9.setStrokeWidth(3);
//        Line l10=new Line(400,640,100,640);
//        l10.setStroke(Color.BLACK);l10.setStrokeWidth(3);
////        Line l11=new Line(100,640,400,670);
//        Line l11=new Line(400,670,100,640);
//        l11.setStroke(Color.BLACK);l11.setStrokeWidth(3);
//        Line l12=new Line(400,670,100,690);
//        l12.setStroke(Color.BLACK);l12.setStrokeWidth(3);
////        Line l13=new Line(100,690,400,720);
//        Line l13=new Line(400,720,100,690);
//        l13.setStroke(Color.BLACK);l12.setStrokeWidth(3);
        Line l0 = new Line(50, 100, 50, 535);
        l0.setStrokeWidth(3);
        Line l1 = new Line(50, 535, 350, 535);
        l1.setStrokeWidth(3);
        Line l2 = new Line(350, 535, 350, 200);
        l2.setStrokeWidth(3);
        Line l3 = new Line(50, 100, 350, 100);
        l3.setStrokeWidth(3);
        Line l4 = new Line(50, 157, 160, 100);
        l4.setStrokeWidth(3);


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


//        gp.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        gp.getChildren().addAll(hold,spring0,spring0,spring1,spring2,spring3,spring4,spring5,base);

        List<Line> liness;
//        liness= Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        liness= Arrays.asList(hold,spring0,spring0,spring1,spring2,spring3,spring4,spring5,base);

        ArrayList<Line> lines=new ArrayList<Line> (liness);

        PauseTransition wait=new PauseTransition(Duration.millis(1000));
        wait.play();
//        increaseSpringSize(lines);



        Scene sc=new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setTitle("250");
        primaryStage.show();

    }
}
