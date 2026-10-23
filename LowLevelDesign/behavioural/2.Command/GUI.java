package behavioural.command.gui;

import behavioural.command.command.*;
import behavioural.command.editor.*;

public class GUI
{
    private Editor editor;
    private CommandHistory command_history;
    public GUI()
    {
        this.editor = new Editor();
        command_history = new CommandHistory();
    }

    public void setText(String text)
    {
        System.out.println("Setting text to: "+text);
        editor.textbox = text;
    }

    public void printText()
    {
        System.out.println(editor.textbox+":".repeat(15)+"   "+editor.clipboard);
    }

    public void cutCommand()
    {

        System.out.println("Performing CUT operation");
        Command cut_command = new CutCommand(editor);
        cut_command.execute();
        command_history.add(cut_command);
    }

    public void copyCommand()
    {
        System.out.println("Performing COPY operation");
        Command copy_command = new CopyCommand(editor);
        copy_command.execute();
        command_history.add(copy_command);
    }

    public void pasteCommand()
    {
        System.out.println("Performing PASTE operation");
        Command paste_command = new PasteCommand(editor);
        paste_command.execute();
        command_history.add(paste_command);
    }

    public void undo()
    {
        System.out.println("Performing UNDO operation");
        if(!command_history.isEmpty())
        {
            Command popped_command = command_history.pop();
            popped_command.undo();
            return;
        }
        System.out.println("Command Stack is empty");

    }
}