package behavioural.memento.editor;

import behavioural.memento.memento.*;
import behavioural.memento.command.*;

public class Editor
{
    public String textbox, clipboard;
    private History history;
    public Editor()
    {
        this.textbox = "";
        this.clipboard = "";
        history = new History();
    }

    public String backup()
    {
        return this.textbox;
    }

    public void setText(String text)
    {
        System.out.println("Setting text to: " + text);
        this.textbox = text;
    }

    public void printText()
    {
        System.out.println(this.textbox+ "  ->  "+ this.clipboard);
    }

    public void restore(String backup)
    {
        this.textbox = backup;
    }

    public void copyCommand()
    {
        System.out.println("Performing Copy Command");
        Command cmd = new CopyCommand(this);
        history.push(cmd, new Memento(this));
        cmd.execute();
    }

    public void cutCommand()
    {
        System.out.println("Performing Cut Command");
        Command cmd = new CutCommand(this);
        history.push(cmd, new Memento(this));
        cmd.execute();
    }

    public void pasteCommand()
    {
        System.out.println("Performing Paste Command");
        Command cmd = new PasteCommand(this);
        history.push(cmd, new Memento(this));
        cmd.execute();
    }

    public void undo()
    {
        System.out.println("Performing undo operation");
        history.undo();
    }
}