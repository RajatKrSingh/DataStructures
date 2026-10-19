package creational.abstract_factory.gui_factory;
import creational.abstract_factory.button.*;
import creational.abstract_factory.checkbox.*;

public class WindowsGUIFactory implements GUIFactory
{
    public Button createButton()
    {
        return new WindowsButton();
    }

    public CheckBox createCheckbox()
    {
        return new WindowsCheckBox();
    }
}