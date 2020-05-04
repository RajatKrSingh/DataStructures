package LeetCode;

public class ListNodeQueue implements Comparable<ListNodeQueue>
{
    int val;
    ListNode node;
    public ListNodeQueue(int val ,ListNode node)
    {
        this.val = val;
        this.node = node;
    }

    @Override
    public int compareTo(ListNodeQueue o)
    {
        return this.val-o.val;
    }
}
