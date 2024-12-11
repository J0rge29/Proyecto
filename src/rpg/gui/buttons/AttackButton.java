package rpg.gui.buttons;

import rpg.gui.MainWindow;
import rpg.gui.buttons.events.AttackEvent;
import rpg.gui.panels.BottomPanel;

public class AttackButton extends UserButton {

    public AttackButton(MainWindow game) {

        super("Atacar");
        // Asignar la acción de atacar al enemigo
        addActionListener(new AttackEvent(game));
    }
}