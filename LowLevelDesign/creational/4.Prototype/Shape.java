package creational.prototype.shape;

public abstract class Shape
{
    private int x, y;
    private String color;

    public Shape(int x, int y, String color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Shape(Shape shape)
    {
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    public void setCloneColor(Shape shape)
    {
        this.color = "clone_"+shape.color;
    }

    public void printAttributes()
    {
        System.out.println("Color: "+ this.color);
    }
    public abstract Shape clone();
}