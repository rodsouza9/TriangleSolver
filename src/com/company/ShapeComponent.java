package com.company;

import java.util.*;

/**
 * Created by Rohan D'Souza on 1/24/2016.
 */

/**
 * <p>"Component" is defined as a representation of one angle or side of any polygon. Every component is made by two things.
 * <ol style="list-style-type:none">
 *     <li><code>alpha</code>: the letter representation of an angle or side. (helps identify position)</li>
 *     <li><code>value</code>: the numerical value of the side or angle.</li>
 * </ol>
 * All sides are represented by a lower case letter.
 * All angles are represented</p>
 *
 * <p>A <tt>ShapeComponent</tt> can be used to represent any component of any polygon.</p>
 *
 * @author  Rohan D'Souza
 * @see     Triangle
 */
public class ShapeComponent implements Component{

    /**
     * String <tt>alpha</tt> should have a length of 1 at all times. It represent the location of the component.
     */
    private String alpha;
    private int value;

    /**
     * Default constructor: constructs a triangle component with no location and a value of 0;
     */
    public ShapeComponent() {
        alpha = null;
        value = 0;
    }

    /**
     * @param alpha the alphabetical location of the component.
     * @param type specifies weather the component is an angle or a side. Can be only "a" or "s". a - angle, s - side.
     * @throws InputMismatchException if the length of <tt>alpha</tt> is not 1 or if the <tt>type</tt> does not specify a or s.
     */
    public ShapeComponent(String alpha, String type) throws InputMismatchException{
        type=type.toLowerCase();
        if (alpha.length()!=1)
            throw new InputMismatchException();
        else if (type.equals("a")) //is an angle
            this.alpha = alpha.toUpperCase();
        else if (type.equals("s")) // is a side
            this.alpha = alpha.toLowerCase();
        else throw new InputMismatchException();
        value = 0;
    }

    public ShapeComponent(String alpha, int value, String type) throws InputMismatchException{
        type=type.toLowerCase();
        if (type.equals("a")) //is an angle
            this.alpha = alpha.toUpperCase();
        else if (type.equals("s")) // is a side
            this.alpha = alpha.toLowerCase();
        else throw new InputMismatchException();
        this.value = value;
    }

    public ShapeComponent(String alpha) {
        this.alpha = alpha;
        value = 0;
    }

    public ShapeComponent(String alpha, int value) {
        this.alpha = alpha;
        this.value = value;
    }

    public ShapeComponent(ShapeComponent component) {
        alpha = component.getAlpha();
        value = component.getValue();
    }


    public boolean isValid() {
        return Character.isAlphabetic(alpha.charAt(0)) && value > 0;
    }


    public String getAlpha () {return alpha;}
    public int getValue () {return value;}
    //VVVV That method needs to be changed
    //Issue: cannot reach subclass either move it down to subclass or figure out how to access lower class
    //Update: Or wait it might be fine
    public void setValue (int value){this.value = value;}
    public boolean isAngle() {
        return Character.isUpperCase(this.getAlpha().charAt(0));
    }
    public boolean isSide() {
        return Character.isLowerCase(this.getAlpha().charAt(0));
    }

    @Override
    public String toString(){
        return alpha + "= " + value;
    }

    /*public static boolean isAngle(ShapeComponent component) {
        return Character.isUpperCase(component.getAlpha().charAt(0));
    }
    public static boolean isSide(ShapeComponent component) {
        return Character.isLowerCase((component.getAlpha().charAt(0)));
    }*/

}
