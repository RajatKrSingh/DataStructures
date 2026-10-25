package behavioural.memento.runner;

import behavioural.memento.editor.*;

public class Runner
{
    public static void main(String args[])
    {
        Editor editor = new Editor();
        System.out.println("*".repeat(15)+"EDITOR PALETTE"+"*".repeat(15));
        editor.setText("Rajat");
        editor.printText();
        editor.cutCommand();
        editor.printText();
        editor.pasteCommand();
        editor.printText();
        editor.setText("Jungle");
        editor.copyCommand();
        editor.printText();
        editor.pasteCommand();
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();
    }
}