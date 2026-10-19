package creational.abstract_factory.runner;

import creational.abstract_factory.button.*;
import creational.abstract_factory.checkbox.*;
import creational.abstract_factory.gui_factory.*;

public class Runner
{
    public static void main(String args[])
    {
        GUIFactory myguiFactory;
        Button myButton;
        CheckBox myCheckbox;

        // Create Windows GUI
        System.out.println("*".repeat(10)+" Creation Windows GUI "+"*".repeat(10));
        myguiFactory = new WindowsGUIFactory();
        myButton = myguiFactory.createButton();
        myCheckbox = myguiFactory.createCheckbox();
        myButton.render();
        myCheckbox.render();

        // Create MA=acOS GUI
        System.out.println("*".repeat(10)+" Creating MacOS GUI "+ "*".repeat(10));
        myguiFactory = new MacOSGUIFactory();
        myButton = myguiFactory.createButton();
        myCheckbox = myguiFactory.createCheckbox();
        myButton.render();
        myCheckbox.render();
        
    }
}