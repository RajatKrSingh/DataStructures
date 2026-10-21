package structural.adapter.adapter;

import structural.adapter.peg.*;

public class SquarePegAdapter extends RoundPeg
{
    private SquarePeg squarepeg;
    public SquarePegAdapter(SquarePeg squarepeg)
    {
        this.squarepeg = squarepeg;
    }

    @Override
    public int getRadius()
    {
        return (int)(Math.sqrt(2) * this.squarepeg.getLength());
    }
}