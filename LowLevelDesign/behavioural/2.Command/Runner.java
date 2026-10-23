package behavioural.command.runner;

import behavioural.command.gui.*;

public class Runner
{
    public static void main(String args[])
    {
        GUI gui_screen = new GUI();
        System.out.println("*".repeat(15)+"EDITOR PALETTE"+"*".repeat(15));
        gui_screen.setText("Rajat");
        gui_screen.printText();
        gui_screen.cutCommand();
        gui_screen.printText();
        gui_screen.pasteCommand();
        gui_screen.printText();
        gui_screen.setText("Jungle");
        gui_screen.copyCommand();
        gui_screen.printText();
        gui_screen.pasteCommand();
        gui_screen.printText();
        gui_screen.undo();
        gui_screen.printText();
        gui_screen.undo();
        gui_screen.printText();
        gui_screen.undo();
        gui_screen.printText();
        gui_screen.undo();
        gui_screen.printText();
    }
}