package creational.abstract_factory.gui_factory;
import creational.abstract_factory.button.*;
import creational.abstract_factory.checkbox.*;

public class MacOSGUIFactory implements GUIFactory
{
    public Button createButton()
    {
        return new MacOSButton();
    }

    public CheckBox createCheckbox()
    {
        return new MacOSCheckbox();
    }
}