package rpg.gui.labels;

import javax.swing.*;
import rpg.gui.ui.NameLabelUI;




public class NameLabel extends JLabel {


    public NameLabel(String name) {
        super(name);
        setUI(new NameLabelUI());
    }

}
