package creational.prototype.shape;

public class Circle extends Shape
{
    private int radius;
    
    public Circle(int x, int y, String color, int radius)
    {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle shape)
    {
        super(shape);
        this.radius = shape.radius;
    }
    public Shape clone()
    {
        Shape copiedShape = new Circle(this);
        copiedShape.setCloneColor(this);
        return copiedShape;
    }
    public void printAttributes()
    {
        super.printAttributes();
        System.out.println("Radius: "+this.radius);
    }
}