package behavioural.memento.command;

import behavioural.memento.editor.Editor;

public class PasteCommand implements Command
{
    Editor editor;
    public PasteCommand(Editor editor)
    {
        this.editor = editor;
    }

    @Override
    public void execute()
    {
        editor.textbox = editor.clipboard;
        editor.clipboard = "";
    }
}