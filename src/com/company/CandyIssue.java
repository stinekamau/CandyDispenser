package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


        Rectangle topRect=new Rectangle(100,140,300,400);
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


        for(Ellipse el: ovalist)
        {
            widgets.getChildren().add(el);
            stack.add(el);
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
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }

//            temp.setFill(Color.RED);


        });

        push.setOnAction(e->
        {

            if(!hpop.isEmpty())
            {
                if(count[0]==5)
                    count[0]=-1;
                count[0]++;


                System.out.println("Value of count is: "+count[0]);
                Ellipse ell=hpop.pop();
                Ellipse orell=ovalist.get(5-count[0]);
//                templist.remove(5-count[0]);




                Path path=new Path();
                path.getElements().add(new MoveTo(700f,500f));
//                path.getElements().add(new CubicCurveTo(100f,30f,180f,30f,orell.getCenterX(),orell.getCenterX()));
                path.getElements().add(new CubicCurveTo(350,0f,180f,30f,450,70));
                Ellipse temp=new Ellipse(orell.getCenterX(),orell.getCenterY(),orell.getRadiusX(),orell.getRadiusY());



//            ell.setRadiusX(orell.getRadiusX());
//            ell.setRadiusY(orell.getRadiusY());
                fallOvals(templist);
                decreaseSpringSize(finalLines);

                //Instantiate the path transition
                PathTransition ptr=new PathTransition();
                ptr.setDuration(Duration.millis(500));
                ptr.setNode(ell);
                ptr.setPath(path);
                ptr.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                ptr.play();

                FadeTransition fd=new FadeTransition();
                fd.setDuration(Duration.millis(10));
                fd.setFromValue(1);fd.setToValue(0.001);
                fd.setNode(ell);
                fd.play();

                temp.setFill(Color.RED);
                temp.setStroke(Color.GREEN);
                temp.setStrokeWidth(3);
                stack.add(temp);
//                hpop.add(temp);

                widgets.getChildren().add(temp);


            }

        });

        pop.setOnAction(e->
        {
            if(!stack.isEmpty())
            {
                Ellipse certain=stack.pop();
                allovals.remove(certain);
                Path path=new Path();
                path.getElements().add(new MoveTo(certain.getCenterX(),certain.getCenterY()));
                path.getElements().add(new CubicCurveTo(250f,0f,300,10f,700f,500f));

                increaseSpringSize(finalLines);

                //Instantiate the path transition
                PathTransition ptr=new PathTransition();
                ptr.setDuration(Duration.millis(3500));
                ptr.setNode(certain);
                ptr.setPath(path);
                ptr.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//            ptr.setCycleCount(50);
                ptr.play();

                FadeTransition fd=new FadeTransition();
                fd.setDuration(Duration.millis(3000));
                fd.setFromValue(1);fd.setToValue(0.001);
                fd.setNode(certain);
                fd.play();

                hpop.add(certain);

                riseOvals(allovals);


            }
        });


        Scene sc=new Scene(mjr);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Candy Dispenser");
        primaryStage.show();


    }
    ArrayList<Ellipse> createEllipse()
    {
        int v=250;int v1=470;int v2=150;int v3=20;
        ArrayList<Ellipse> ovals=new ArrayList<>();
        for(int i=0;i<6;i++)
        {
            v1-=50;
            ovals.add(new Ellipse(v,v1,v2,v3));
            ovals.get(i).setFill(Color.GRAY);
            ovals.get(i).setStroke(Color.GOLD);
            ovals.get(i).setStrokeWidth(3);

        }
        return ovals;


    }
    void riseOvals(LinkedList<Ellipse> arr)
    {

        for(Ellipse ert:arr)
        {
            ert.setCenterY(ert.getCenterY()-38.0);

        }

    }

    void fallOvals(LinkedList<Ellipse> arr)
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
