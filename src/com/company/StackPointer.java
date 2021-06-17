package com.company;

import com.sun.javafx.scene.control.EmbeddedTextContextMenuContent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

import java.security.spec.ECField;
import java.util.*;

public class StackPointer {
    int popsize;
    private ArrayList<Ellipse> ovals;
    private Stack<Ellipse> pushStack;
    private LinkedList<Ellipse> internal;
    private Stack<Ellipse> popStack;
    int pointer;

    public StackPointer()
    {
        this.popsize=-1;
        ovals=createEllipse();
        popStack=new Stack<>();
        pushStack=new Stack<>();
        internal=new LinkedList<>();
        this.pointer=0;


    }

    public  Ellipse onPop()
    {
//        this.popsize++;
          Ellipse popped=ovals.get(++this.popsize);
          popStack.add(popped);
          return popped;

    }
    public Ellipse onPush()
    {
//        ovals.get();
        this.popsize--;
        return ovals.get(popsize);

    }
    public ArrayList<Ellipse> returnEllipse()
    {
        return  ovals;
    }

    private ArrayList<Ellipse> createEllipse()
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
        Collections.reverse(ovals);
        return ovals;


    }
    public void increaseSpringSize(List<Line> ls)
    {
        increaseSpring(ls);
    }

    public void decreaseSpringSize(List<Line> ls)
    {
        decreaseSpring(ls);
    }

    private void increaseSpring(List<Line> ls)
    {

        for(int i=0;i<ls.size();i++)
        {
            ls.get(i).setEndY(ls.get(i).getEndY()-36.0);
            ls.get(i).setStartY(ls.get(i).getStartY()-36.0);
        }

    }
    private void decreaseSpring(List<Line> ls)
    {
        for(int i=0;i<ls.size();i++)
        {


            ls.get(i).setEndY(ls.get(i).getEndY()+36.0);
            ls.get(i).setStartY(ls.get(i).getStartY()+36.0);

        }

    }
}
