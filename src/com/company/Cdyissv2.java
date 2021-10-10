package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class Cdyissv2 extends Application {
    int lines=11;
//    Stack<Line> poppedLines=new Stack<>();
    List<Color> reqcol=Arrays.asList(Color.RED,Color.GREEN,Color.WHITE,Color.BLUE,Color.BLACK);
    List<String> reqc=Arrays.asList("Red","Green","White","Blue","Black");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Initialize the stack
        Stack<Ellipse> stack=new Stack<>();

        //Initalize the containers
        Group widgets=new Group();
        VBox cont=new VBox();
        HBox lowerPanel=new HBox();
        BorderPane mjr=new BorderPane();
        VBox display=new VBox();

        lowerPanel.setSpacing(10);

        //create the necessary buttons
        Button size=new Button("size()");
        size.setPrefSize(70,30);
        Button pop=new Button("Pop()");
        pop.setPrefSize(70,30);
        Button push=new Button("Push()");
        push.setPrefSize(70,30);
        Button top=new Button("Top()");
        top.setPrefSize(70,30);
        Button empty=new Button("IsEmpty()");
        empty.setPrefSize(70,30);

        Label tgt=new Label();
        Label empt=new Label();
        empt.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.ITALIC,30));

        tgt.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD,FontPosture.ITALIC,30));
        display.getChildren().addAll(tgt,empt);
        lowerPanel.getChildren().addAll(size,pop,push,top,empty);
        Rectangle topRect=new Rectangle(100,180
                ,300,400);
        topRect.setFill(Color.DARKCYAN);

        Rectangle bottomRect=new Rectangle(100,431,300,170);
        bottomRect.setFill(Color.DARKCYAN);

        //set the lines and the corresponding strokes
        Line l1=new Line(100,451,400,450);
        l1.setStroke(Color.WHITE);l1.setStrokeWidth(3);
        Line l2=new Line(400,450,100,480);
        l2.setStrokeWidth(3);l2.setStroke(Color.WHITE);
        Line l3=new Line(100,480,400,500);
        l3.setStroke(Color.WHITE);l3.setStrokeWidth(3);
        Line l4=new Line(400,500,100,520);
        l4.setStroke(Color.WHITE);l4.setStrokeWidth(3);
        Line l5=new Line(100,520,400,540);
        l5.setStroke(Color.WHITE);l5.setStrokeWidth(3);
        Line l6=new Line(400,540,100,550);
        l6.setStroke(Color.WHITE);l6.setStrokeWidth(3);
        Line l7=new Line(100,550,400,590);
        l7.setStroke(Color.WHITE);l7.setStrokeWidth(3);
        Line l8=new Line(400,590,100,600);
        l8.setStroke(Color.WHITE);l8.setStrokeWidth(3);
        Line l9=new Line(100,600,400,640);
        l9.setStroke(Color.WHITE);l9.setStrokeWidth(3);
        Line l10=new Line(400,640,100,640);
        l10.setStroke(Color.WHITE);l10.setStrokeWidth(3);
        Line l11=new Line(100,640,400,670);
        l11.setStroke(Color.WHITE);l11.setStrokeWidth(3);
        Line l12=new Line(400,670,100,690);
        l12.setStroke(Color.WHITE);l12.setStrokeWidth(3);
        Line l13=new Line(100,690,400,720);
        l12.setStroke(Color.WHITE);l12.setStrokeWidth(3);

        List<Line> ln;
        ln= Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        ArrayList<Line> lines=new ArrayList<>(ln);
        l1.setFill(Color.RED);
        widgets.getChildren().add(topRect);
        widgets.getChildren().add(bottomRect);
        widgets.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        ArrayList<Ellipse> ovalist=createEllipse();
        ArrayList<ArrayList<Double>> tp=new ArrayList<>();

        for(Ellipse el: ovalist)
        {
            ArrayList<Double> tem=new ArrayList<>();
            widgets.getChildren().add(el);
            stack.add(el);
            tem.add(el.getCenterX());
            tem.add(el.getCenterY());
            tp.add(tem);
        }
        Stack<Ellipse> hpop=new Stack<>();

        mjr.setTop(display);
        mjr.setCenter(widgets);
        mjr.setRight(lowerPanel);

        //set the action events of the button
        List<Line> finalLines = lines;
        final int[] count = {-1};

        size.setOnAction(e->
        {
            tgt.setText("Stack Size: "+stack.size());

        });

        empty.setOnAction(e->
        {
            Boolean em=stack.isEmpty();
            empt.setText("Is Empty: "+em);


        });

        top.setOnAction(e->
        {
            if(stack.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.NONE,  "The candy dispenser is empty",
                        ButtonType.CLOSE, ButtonType.OK);
                alert.setAlertType(Alert.AlertType.ERROR);


                alert.show();

            }
            else
            {
                Ellipse temp=stack.peek();
                int colorName=stack.size()-1;

                Alert alert = new Alert(Alert.AlertType.NONE,  "The "+reqc.get(colorName)+" candy  is on Top",
                        ButtonType.CLOSE, ButtonType.OK);
                alert.setAlertType(Alert.AlertType.INFORMATION);


                alert.show();

            }
        });

        push.setOnAction(e->
        {

            if(!hpop.isEmpty())
            {
                fallOvals(stack);
                Ellipse ell=hpop.pop();

                System.out.println("In push Current destination  X: "+ell.getCenterX()+" Y is "+ell.getCenterY());

//                Ellipse orell=tp.get(5-count[0]);
                stack.add(ell);
                Double y=tp.get(3-count[0]).get(1);
                TranslateTransition revfirst=new TranslateTransition(Duration.millis(500),ell);
                TranslateTransition revsecond=new TranslateTransition(Duration.millis(500),ell);
                TranslateTransition revthird=new TranslateTransition(Duration.millis(500),ell);


                revfirst.setByY(-500);
                revsecond.setByX(-400);
                revthird.setByY(200);
                revfirst.setOnFinished(q->
                {
                    revsecond.setOnFinished(w->
                    {
                        revthird.play();
                    });revsecond.play();
                });revfirst.play();
                System.out.println("In push later destination  X: "+ell.getCenterX()+" Y is "+ell.getCenterY());
                FadeTransition ft=new   FadeTransition(Duration.millis(2000),ell);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();
            }
            else
            {
                Alert alert2 = new Alert(Alert.AlertType.NONE,  "The candy dispenser is Full",
                        ButtonType.CLOSE, ButtonType.OK);
                alert2.setAlertType(Alert.AlertType.ERROR);


                alert2.show();
            }
//            fallOvals(stack);
            decreaseSpringSize(lines);



        });

        pop.setOnAction(e->
        {
            if(!stack.isEmpty())
            {
                count[0]++;
                if(count[0]==4)
                    count[0]=-1;

                Ellipse certain=stack.pop();
                System.out.println("Now in the pop value of x i{s "+certain.getCenterX()+" value of y is "+certain.getCenterY());
                TranslateTransition first=new TranslateTransition(Duration.millis(500),certain);
                TranslateTransition second=new TranslateTransition(Duration.millis(500),certain);
                TranslateTransition third=new TranslateTransition(Duration.millis(500),certain);
                first.setByY(-200);
                second.setByX(400);
                third.setByY(500);
                first.setOnFinished(g->{second.setOnFinished(h->{third.play();});second.play();});
                first.play();
                hpop.add(certain);
                riseOvals(stack);
                increaseSpringSize(lines);
                FadeTransition ft=new   FadeTransition(Duration.millis(1300),certain);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.play();
            }else
            {
                Alert alert = new Alert(Alert.AlertType.NONE,  "The candy dispenser is empty",
                        ButtonType.CLOSE, ButtonType.OK);
                alert.setAlertType(Alert.AlertType.ERROR);


                alert.show();
            }

        });


        Scene sc=new Scene(mjr);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Candy Dispenser");
        primaryStage.show();
    }
    ArrayList<Ellipse> createEllipse()
    {
        int v=250;int v1=460;int v2=150;int v3=20;
        ArrayList<Ellipse> ovals=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            v1-=50;
            ovals.add(new Ellipse(v,v1,v2,v3));
            ovals.get(i).setFill(reqcol.get(i));
            ovals.get(i).setStroke(Color.BLACK);
            ovals.get(i).setStrokeWidth(3);

        }
        return ovals;
    }
    void riseOvals(Stack<Ellipse> arr)
    {
        for(Ellipse ert:arr)
        {
            ert.setCenterY(ert.getCenterY()-38.0);

        }

    }

    void fallOvals(Stack<Ellipse> arr)
    {
        for(Ellipse ert:arr)
        {
            ert.setCenterY(ert.getCenterY()+38.0);

        }

    }


    void increaseSpringSize(ArrayList<Line> lineList)
    {



        double begin;
        Line topLine = lineList.get(0);
        topLine.setStartY(topLine.getStartY() - 41);
        topLine.setEndY(topLine.getEndY() - 41);
        begin = topLine.getStartY();

        for (int i = 1; i < lineList.size()-1; i++) {
            Line line = lineList.get(i);
            line.setStartY(begin);
            line.setEndY(begin + lines);
            begin = line.getEndY();
        }
        lines += 6;


        Line bottomLine = lineList.get(lineList.size()-1);
        bottomLine.setStartY(begin);
//
    }
    void decreaseSpringSize(ArrayList<Line> lineList)
    {

        double begin;
        Line topLine = lineList.get(0);
        topLine.setStartY(topLine.getStartY() + 41);
        topLine.setEndY(topLine.getEndY() + 41);
        begin = topLine.getStartY();

        for (int i = 1; i < lineList.size()-1; i++) {
            Line line = lineList.get(i);
            line.setStartY(begin);
            line.setEndY(begin + lines);
            begin = line.getEndY();
        }
        lines -= 6;

        Line base1 = lineList.get(lineList.size()-1);
        base1.setStartY(begin);
    }


}
