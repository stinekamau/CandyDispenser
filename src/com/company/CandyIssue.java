package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.*;

public class CandyIssue extends Application {

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
        empt.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD,FontPosture.ITALIC,30));

        tgt.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD,FontPosture.ITALIC,30));
        display.getChildren().addAll(tgt,empt);
        lowerPanel.getChildren().addAll(size,pop,push,top,empty);
        Rectangle topRect=new Rectangle(100,180,300,400);
        Rectangle bottomRect=new Rectangle(100,431,300,250);
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

        List<Line> lines;
        lines= Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        l1.setFill(Color.RED);
        widgets.getChildren().add(topRect);
        widgets.getChildren().add(bottomRect);
        widgets.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12);
        ArrayList<Ellipse> ovalist=createEllipse();
        LinkedList<Ellipse> templist=new LinkedList<>(ovalist);
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
        LinkedList<Ellipse> allovals=new LinkedList<>(ovalist);
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
            Ellipse temp=stack.peek();
            temp.setFill(Color.BLUE);
            temp.setStroke(Color.PINK);
            PauseTransition wait = new PauseTransition(Duration.millis(1000));
            wait.play();
            wait.setOnFinished(t->
            {
                temp.setFill(Color.GRAY);
                temp.setStroke(Color.GOLD);
            });
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
//                fallOvals(templist);
//                decreaseSpringSize(finalLines);
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
            }
            else
            {
                Alert alert2 = new Alert(AlertType.NONE,  "The candy dispenser is Full",
                        ButtonType.CLOSE, ButtonType.OK);
                alert2.setAlertType(AlertType.ERROR);


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
            }else
            {
                Alert alert = new Alert(AlertType.NONE,  "The candy dispenser is empty",
                        ButtonType.CLOSE, ButtonType.OK);
                alert.setAlertType(AlertType.ERROR);


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
            ovals.get(i).setFill(Color.GRAY);
            ovals.get(i).setStroke(Color.GOLD);
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

    void increaseSpringSize(List<Line> ls)
    {

        for(int i=0;i<ls.size();i++)
        {
            ls.get(i).setEndY(ls.get(i).getEndY()-36.0);
            ls.get(i).setStartY(ls.get(i).getStartY()-36.0);
        }

    }
    void decreaseSpringSize(List<Line> ls)
    {
        for(int i=0;i<ls.size();i++)
        {
            ls.get(i).setEndY(ls.get(i).getEndY()+36.0);
            ls.get(i).setStartY(ls.get(i).getStartY()+36.0);
        }

    }


}
