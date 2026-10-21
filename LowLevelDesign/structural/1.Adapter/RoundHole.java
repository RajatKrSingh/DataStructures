package structural.adapter.hole;

import structural.adapter.peg.*;

public class RoundHole
{
    private int radius;
    public RoundHole(int radius)
    {
        this.radius = radius;
    }

    public int getRadius()
    {
        return this.radius;
    }

    public boolean checkFits(RoundPeg peg)
    {
        return (peg.getRadius() <= this.radius);
    }
}