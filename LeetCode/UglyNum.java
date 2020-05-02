package LeetCode;

public class UglyNum implements Comparable<UglyNum>
{
    int prev_ugly_index, prime ,current_prime_val;
    public UglyNum(int index,int val,int p)
    {
        prev_ugly_index = index;
        current_prime_val = val;
        prime = p;
    }

    @Override
    public int compareTo(UglyNum o)
    {
        return current_prime_val - o.current_prime_val;
    }
}
