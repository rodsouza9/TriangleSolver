package com.company;

import javafx.scene.shape.Shape;

import java.util.InputMismatchException;

/**
 * Created by Rohan D'Souza on 2/6/2016.
 */
public class TriangleComponent extends ShapeComponent {
    public TriangleComponent()                                                                      {super();}
    public TriangleComponent(TriangleComponent component)                                           {super(component);}
    public TriangleComponent(String alpha, String type)             throws ComponentAlphaMismatchException   {super(alpha,type);}
    public TriangleComponent(String alpha, int value, String type)  throws ComponentAlphaMismatchException   {super(alpha, value, type);}



    //you have to add ComponentAlphaMismatchException an the two constructors bellow if the alpha doesnt match side names.
    public TriangleComponent(String alpha) throws ComponentAlphaMismatchException{
        super((alpha.equals("test")) ? alpha : throw new ComponentAlphaMismatchException());
    }
    public TriangleComponent(String alpha, int value){
        super(alpha, value);
    }

    public boolean isHyp() {
        return super.getAlpha().equals("b");
    }
    public boolean isAdj(TriangleComponent angle) throws ComponentAlphaMismatchException {
        if (this.isSide() && angle.isAngle()) {

        }
        else if (!this.isSide()) {
            throw new ComponentAlphaMismatchException("this is not a side.");
        }
        else if (!angle.isAngle()) {
            throw new ComponentAlphaMismatchException("alpha is not an angle");
        }
        //else if
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