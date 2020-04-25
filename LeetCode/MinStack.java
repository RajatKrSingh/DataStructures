package LeetCode;

import java.util.Stack;

public class MinStack
{
    Stack<Integer> stck ;
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stck = new Stack();
    }

    public void push(int x) {
        if(x<=min)
        {
            stck.push(min);
            min = x;
        }
        stck.push(x);
    }

    public void pop() {
        if(stck.pop()==min)
            min = stck.pop();
    }

    public int top() {
        return stck.peek();
    }

    public int getMin() {
        return min;
    }
}
