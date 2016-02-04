package com.company;

import java.util.*;

/**
 * Created by Rohan D'Souza on 1/24/2016.
 */
public class TriangleComponent{
    private String alpha;
    private int value;

    public TriangleComponent() {
        alpha = null;
        value = 0;
    }
    public TriangleComponent(String alpha) {
        this.alpha = alpha.toLowerCase();
        value = 0;
    }
    public TriangleComponent (String alpha, int value) {
        this.alpha = alpha.toLowerCase();
        this.value = value;
    }
    public void setValue (int value){this.value = value;}

    public String getAlpha () {return alpha;}
    public int getValue () {return value;}

}
