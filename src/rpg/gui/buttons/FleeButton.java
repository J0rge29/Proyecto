package rpg.gui.buttons;

import rpg.gui.MainWindow;
import rpg.gui.buttons.events.FleeEvent;

import javax.swing.*;
import java.awt.event.ActionListener;

import java.awt.*;

public class FleeButton extends UserButton {

    public FleeButton(MainWindow game) {
        super("Huir");
            addActionListener(new FleeEvent(game));

    }
}
