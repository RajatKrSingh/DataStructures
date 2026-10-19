package creational.prototype.runner;

import creational.prototype.shape.*;

public class Runner
{
    public static void main(String args[])
    {
        Shape baseShape = new Rectangle(5, 5, "red", 10, 15);
        System.out.println("*".repeat(10)+"Creating clone of Rectangle");
        Rectangle rectangleCopy = (Rectangle)baseShape.clone();
        rectangleCopy.printAttributes();

        System.out.println("*".repeat(10)+"Creating clone of Circle");
        baseShape = new Circle(10,10, "yellow", 10);
        Circle circleCopy = (Circle)baseShape.clone();
        circleCopy.printAttributes();
    }
}