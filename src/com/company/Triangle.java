package com.company;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.InputMismatchException;

/**
 * Created by Rohan D'Souza on 1/7/2016.
 */
public class Triangle{
    private TriangleComponent side1;
    private TriangleComponent side2 = null;
    private TriangleComponent angle = null;
    private String type;

    /**
     * No matter what type (String or TriangleComponent) is
     * the parameter it is converted to TriangleComponent and
     * is assigned to its corresponding instance field.
     *
     * the String should be "<alpha> <value>"
     * alpha and value is defined in TriangleComponent.
     *
     * @param side1 The first side of the right angle triangle
     * @param toDecide The second side or first angel (hence "toDecide")
     * @param type : "SA" or "SS" determines the type of the right angle triangle
     */
    public Triangle (String side1, String toDecide, String type) {
        this.type = type;
        this.side1 = toTriangleComponent(side1);
        if (Character.isUpperCase(toDecide.charAt(0))){
            this.angle = toTriangleComponent(toDecide);
        } else {this.side2 = toTriangleComponent(toDecide);}
    }
    public Triangle (TriangleComponent side1, TriangleComponent toDecide,  String type) {
        this.type = type;
        this.side1 = side1;
        if (Character.isUpperCase(toDecide.getAlpha().charAt(0))) {this.angle = toDecide;}
        else {this.side2 = toDecide;}
    }

    public static TriangleComponent toTriangleComponent (String thing) { //thing "A 65"
        return new TriangleComponent(thing.substring(0,1), Integer.parseInt(thing.substring(2)));
    }

    public TriangleComponent getSide1 () {return side1;}
    public TriangleComponent getSide2 () {return side2;}
    public TriangleComponent getAngle () {return angle;}
    public String getType () {return type;}

    

    public String solve () {
        if ()
        return null;
    }
    /*public String decodeAlpha (String toDecode) {

    }*/

    @Override
    public String toString() {
        return "\n" +
                "         C\n" +
                "        /|\n" +
                "       / |\n" +
                "    b /  | a\n" +
                "     /   |\n" +
                "  A /____| B\n" +
                "      c";
    }
}