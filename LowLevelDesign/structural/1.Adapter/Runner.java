package structural.adapter.runner;

import structural.adapter.peg.*;
import structural.adapter.hole.*;
import structural.adapter.adapter.*;

public class Runner
{
    public static void main(String args[])
    {
        RoundHole rhole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(4);

        System.out.println("Does the round hole fit outside the round peg: "+ rhole.checkFits(rpeg));

        SquarePeg sq_peg1 = new SquarePeg(2);
        SquarePeg sq_peg2 = new SquarePeg(10);

        SquarePegAdapter sq_adapter_1 = new SquarePegAdapter(sq_peg1);
        SquarePegAdapter sq_adapter_2 = new SquarePegAdapter(sq_peg2);

        System.out.println("Does the round hole fit outside the small square peg: "+ rhole.checkFits(sq_adapter_1));
        System.out.println("Does the round hole fit outside the big square peg: "+ rhole.checkFits(sq_adapter_2));
    }
}