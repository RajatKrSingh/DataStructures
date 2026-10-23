package behavioural.command.command;

import behavioural.command.editor.*;

public class CutCommand extends Command
{
    public CutCommand(Editor editor)
    {
        super(editor);
    }

    @Override
    public void execute()
    {
        backup();
        editor.clipboard = editor.textbox;
        editor.textbox = "";
    }
}