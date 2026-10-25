package behavioural.memento.memento;

import behavioural.memento.command.*;
import java.util.*;

public class History
{
    Stack<HistoryPair> history;

    public History()
    {
        history = new Stack<>();
    }

    private class HistoryPair
    {
        private Command command;
        private Memento memento;
        
        public HistoryPair(Command command, Memento memento)
        {
            this.command = command;
            this.memento = memento;
        }
    }
    public void push(Command command, Memento memento)
    {
        history.push(new HistoryPair(command, memento));
    }

    public void undo()
    {
        if(history.size()>0)
        {
            HistoryPair popped_ele = history.pop();
            popped_ele.memento.restore();
        }
    }
}