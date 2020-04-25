package LeetCode;
import java.util.LinkedHashSet;

public class NQueensHashval {
    public LinkedHashSet<Integer>[] queen_configuration;
    public int val;

    public NQueensHashval(int val)
    {
        this.val = val;
        queen_configuration = new LinkedHashSet[Math.max(1,val)];
        for(int iterator_i=0;iterator_i<Math.max(val,1);iterator_i++)
            queen_configuration[iterator_i] = new LinkedHashSet<>();
    }
}
