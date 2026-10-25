package behavioural.memento.command;

import behavioural.memento.editor.Editor;

public class CopyCommand implements Command
{
    private Editor editor;

    public CopyCommand(Editor editor)
    {
        this.editor = editor;
    }

    @Override
    public void execute()
    {
        editor.clipboard = editor.textbox;
    }
}