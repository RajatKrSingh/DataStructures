package behavioural.command.command;

import behavioural.command.editor.*;

public class CopyCommand extends Command
{
    public CopyCommand(Editor editor)
    {
        super(editor);
    }

    @Override
    public void execute()
    {
        backup();
        editor.clipboard = editor.textbox;
    }
}