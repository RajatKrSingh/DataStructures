package behavioural.command.command;

import java.util.*;

public class CommandHistory
{
    Stack<Command> stack;
    public CommandHistory()
    {
        stack = new Stack<>();
    }

    public void add(Command ele)
    {
        stack.push(ele);
    }

    public Command pop()
    {
        return stack.pop();
    }
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
}