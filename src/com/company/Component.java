package com.company;

/**
 * Created by Rohan D'Souza on 2/6/2016.
 */
public interface Component {
    boolean isAngle();
    boolean isSide();
    String  getAlpha();
    int     getValue();
    void    setValue(int value);
}