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

//import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class woof extends Application {
    int lines=11;
    Stack<Line> poppedLines=new Stack<>();
    public static void main(String[] args) {
        launch(args);
    }

    void increaseSpringSize(ArrayList<Line> lineList)
    {
        Double height=50.0/13;


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
//        Line line0 = new Line(50, 100, 50, 535);
//        line0.setStrokeWidth(3);
//        Line line1 = new Line(50, 535, 350, 535);
//        line1.setStrokeWidth(3);
//        Line line2 = new Line(350, 535, 350, 200);
//        line2.setStrokeWidth(3);
//        Line line3 = new Line(50, 100, 350, 100);
//        line3.setStrokeWidth(3);
//        Line line4 = new Line(50, 157, 160, 100);
//        line4.setStrokeWidth(3);

        Line hold = new Line(55, 499, 345, 499);
        hold.setStrokeWidth(3);hold.setStroke(Color.RED);
        Line spring0 = new Line(200, 499, 55, 504);
        spring0.setStrokeWidth(2);spring0.setStroke(Color.BLUE);
        Line spring1 = new Line(55, 504, 345, 509);
        spring1.setStrokeWidth(2);spring1.setStroke(Color.ORANGE);
        Line spring2 = new Line(345, 509, 55, 514);
        spring2.setStrokeWidth(2);spring2.setStroke(Color.GREEN);
        Line spring3 = new Line(55, 514, 345, 519);
        spring3.setStrokeWidth(2);spring3.setStroke(Color.INDIANRED);
        Line spring4 = new Line(345, 519, 55, 524);
        spring4.setStrokeWidth(2);spring4.setStroke(Color.YELLOW);
        Line spring5 = new Line(55, 524, 345, 529);
        spring5.setStrokeWidth(2);spring5.setStroke(Color.BROWN);
        Line base = new Line(345, 529, 200, 534);
        base.setStrokeWidth(2);base.setStroke(Color.VIOLET);

        gp.getChildren().addAll(hold,spring0,spring1,spring2,spring3,spring4,spring5,base);
        List<Line> liness;
        liness= Arrays.asList(hold,spring0,spring1,spring2,spring3,spring4,spring5,base);








//        gp.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
//        gp.getChildren().addAll(line0,line1,line2,line3,line4);


//        List<Line> liness;
//        liness= Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
//        liness= Arrays.asList(line0,line1,line2,line3,line4);
        ArrayList<Line> lines=new ArrayList<Line> (liness);

        PauseTransition wait=new PauseTransition(Duration.millis(1000));
        wait.play();
        increaseSpringSize(lines);
        increaseSpringSize(lines);
        increaseSpringSize(lines);
        increaseSpringSize(lines);
        increaseSpringSize(lines);







        Scene sc=new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.setTitle("250");
        primaryStage.show();

    }
}
