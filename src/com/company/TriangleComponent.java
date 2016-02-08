package com.company;

import javafx.scene.shape.Shape;

import java.util.InputMismatchException;

/**
 * Created by Rohan D'Souza on 2/6/2016.
 */
public class TriangleComponent extends ShapeComponent {
    public TriangleComponent()                                                                      {super();}
    public TriangleComponent(String alpha)                                                          {super(alpha);}
    public TriangleComponent(String alpha, int value)                                               {super(alpha, value);}
    public TriangleComponent(TriangleComponent component)                                           {super(component);}
    public TriangleComponent(String alpha, String type)             throws InputMismatchException   {super(alpha,type);}
    public TriangleComponent(String alpha, int value, String type)  throws InputMismatchException   {super(alpha, value, type);}


    public boolean isHyp() {
        return super.getAlpha().equals("b");
    }

    public void thing() {
        this.getAlpha()
    }

    @Override
    public boolean isValid() {

        return  super.getValue()>0
                &&
               (super.getAlpha().toLowerCase().equals("a") ||
                super.getAlpha().toLowerCase().equals("b") ||
                super.getAlpha().toLowerCase().equals("c")  );
    }
}

//Figure out how weather to put the ShapeComponent >> setValue() subclass or how to do it in the class itself