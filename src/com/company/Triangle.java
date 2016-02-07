package com.company;

import com.sun.javafx.geom.transform.Identity;

import java.util.AbstractList;

/**
 * Created by Rohan D'Souza on 1/7/2016.
 */
public class Triangle {
    private TriangleComponent side1;
    private TriangleComponent side2 = null;
    private TriangleComponent angle = null;
    private String type;

    /** This is the triangle configuration
     *         C
     *        /|
     *       / |
     *    b /  | a
     *     /   |
     *  A /____|B
     *      c
     * a,c,hyp are the three sides,
     * A,B,C are the three angles.
     *
     */
    private int a;
    private int c;
    private double hyp;
    private double A;
    private final double B = 90;
    private double C;

    final static String degreeSi = "\\u00b0";
    final static String angleSi = "\u2220";

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
        this.type = type.toUpperCase();
        this.side1 = toTriangleComponent(side1);
        if (Character.isUpperCase(toDecide.charAt(0))){
            this.angle = toTriangleComponent(toDecide);
        } else {this.side2 = toTriangleComponent(toDecide);}
    }
    public Triangle (TriangleComponent side1, TriangleComponent toDecide, String type) {
        this.type = type.toUpperCase();
        this.side1 = side1;
        if (Character.isUpperCase(toDecide.getAlpha().charAt(0))) {this.angle = toDecide;}
        else {this.side2 = toDecide;}
    }
    public static TriangleComponent toTriangleComponent (String thing) { //thing "A 65"
        return new TriangleComponent(thing.substring(0,1), Integer.parseInt(thing.substring(2)));
    }

    public TriangleComponent getSide1() {return side1;}
    public TriangleComponent getSide2() {return side2;}
    public TriangleComponent getAngle() {return angle;}
    public String getType() {return type;}

    public boolean isSS() {return type.equals("SS");}
    public boolean isSA() {return type.equals("SA");}
    public boolean isBothLegs() {
        return ((side1.getAlpha().equals("a") || side1.getAlpha().equals("c"))
                &&
                (side2.getAlpha().equals("a") || side2.getAlpha().equals("c")));
    }

    /**
     * @return a String with all sided and angles listed with values;
     * Triangle Possibilities
     *  SS
     *      *Both sides are legs    >> solveSSbothLegs()
     *      *one leg, one hyp       >> solveSSlegHyp()
     *  SA
     *      *angle, adjacent side
     *      *angle, opposite side
     *      *angle, hypotenuse
     *
     */
    public String solve () {
        if (isSS() && isBothLegs()) {
            solveSSbothLegs();
            return toStringStats();
        }
        else if (isSS()) {
            //solveSSlegHyp();
            return toStringStats();
        }
        return null;
    }

    public void solveSSbothLegs() {
        if (side1.getAlpha().equals("a")) {
            a = side1.getValue();
            c = side2.getValue();
        }
        else {
            a = side2.getValue();
            c = side1.getValue();
        }
        hyp = (double) Math.sqrt(a*a + c*c);
        A = Math.asin(a/hyp);
        C = 90-A;
    }

    public String toStringStats () {
        return  "Sides: a= " +a+ ", b= " +hyp+ ", c= " +c
                +"\n"+
                "Angles "+angleSi+"A= " +A+degreeSi+ ", "+angleSi+"B= " +B+degreeSi+ ", "+angleSi+"C= " +C+degreeSi;
    }

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