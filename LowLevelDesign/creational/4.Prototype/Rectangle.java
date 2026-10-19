package creational.prototype.shape;

public class Rectangle extends Shape
{
    private int length, width;

    public Rectangle(int x, int y, String color, int length, int width)
    {
        super(x, y, color);
        this.length = length;
        this.width = width;
    }

    public Rectangle(Rectangle shape)
    {
        super(shape);
        this.length = shape.length;
        this.width = shape.width;
    }
    public Shape clone()
    {
        Shape copiedShape =  new Rectangle(this);
        copiedShape.setCloneColor(this);
        return copiedShape;
    }
    public void printAttributes()
    {
        super.printAttributes();
        System.out.println("Length: "+this.length+"\nWidth: "+this.width);
    }
}