package LeetCode;

public class Tuple implements Comparable<Tuple>{
    int pos_x,pos_y,val;

    public Tuple (int pos_x,int pos_y,int val)
    {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple obj)
    {
        return this.val - obj.val;
    }
}
