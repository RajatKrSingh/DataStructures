package behavioural.command.command;

import behavioural.command.editor.*;

public class PasteCommand extends Command
{
    public PasteCommand(Editor editor)
    {
        super(editor);
    }

    @Override
    public void execute()
    {
        backup();
        editor.textbox = editor.clipboard;
    }
}