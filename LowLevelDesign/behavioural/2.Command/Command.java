package behavioural.command.command;

import behavioural.command.editor.*;

public abstract class Command
{
    Editor editor;
    public String backup, clipboard;
    public Command(Editor editor)
    {
        this.editor = editor;
        this.backup = "";
        this.clipboard = "";
    }

    public void backup()
    {
        this.backup = editor.textbox;
        this.clipboard = editor.clipboard;
    }
    
    public abstract void execute();

    public void undo()
    {
        editor.textbox = this.backup;
        editor.clipboard = this.clipboard;
    }
}