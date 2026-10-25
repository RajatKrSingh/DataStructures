package behavioural.memento.command;

import behavioural.memento.editor.Editor;

public class CutCommand implements Command
{
    Editor editor;
    public CutCommand(Editor editor)
    {
        this.editor = editor;
    }

    @Override
    public void execute()
    {
        editor.clipboard = editor.textbox;
        editor.textbox = "";
    }
}