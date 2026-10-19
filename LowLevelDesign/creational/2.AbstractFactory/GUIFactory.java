package creational.abstract_factory.gui_factory;

import creational.abstract_factory.button.*;
import creational.abstract_factory.checkbox.*;

public interface GUIFactory
{
    public Button createButton();
    public CheckBox createCheckbox();
}