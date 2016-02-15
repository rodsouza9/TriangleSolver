package com.company;

/**
 * Created by Rohan D'Souza on 2/6/2016.
 */
public class TriangleComponent extends ShapeComponent {
    public TriangleComponent()                                                                               {super();}
    public TriangleComponent(String alpha, String type)             throws ComponentMismatchException {super(alpha,type);}
    public TriangleComponent(String alpha, int value, String type)  throws ComponentMismatchException {super(alpha, value, type);}
    public TriangleComponent(String alpha) throws ComponentMismatchException {
        if (checkAlpha(alpha)) {
            this.alpha = alpha;
            value = 0;
        }
        else if (alpha.equals("B"))
            throw new ComponentMismatchException("B is already defined as 90 degrees");
        else
            throw new ComponentMismatchException("alpha does not match options of a Triangle");
    }
    private static boolean checkAlpha(String alpha) {
        return alpha.equals("a") || alpha.equals("b") || alpha.equals("c") ||
                alpha.equals("A") || alpha.equals("C");
    }
    public TriangleComponent(String alpha, int value) throws ComponentMismatchException {
        if (checkAlpha(alpha)) {
            this.alpha = alpha;
            this.value = value;
        }
        else if (alpha.equals("B"))
            throw new ComponentMismatchException("B is already defined as 90 degrees");
        else
            throw new ComponentMismatchException("alpha does not match options of a Triangle");
    }

    public boolean isHyp() {
        return super.getAlpha().equals("b");
    }
    public boolean isAdj(TriangleComponent angle) throws ComponentMismatchException {
        if (this.isSide() && angle.isAngle()) {
            if (alpha.equals("c") && angle.getAlpha().equals("A")) {
                return true;
            }
            else if (alpha.equals("a") && angle.getAlpha().equals("C")) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (!this.isSide()) {
            throw new ComponentMismatchException("this is not a side.");
        }
        else if (!angle.isAngle()) {
            throw new ComponentMismatchException("alpha is not an angle");
        }
        else
            throw  new ComponentMismatchException("Both this and alpha were not sides and angles, respectively.");
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