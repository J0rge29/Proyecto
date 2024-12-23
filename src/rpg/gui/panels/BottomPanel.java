package rpg.gui.panels;

import rpg.gui.MainWindow;
import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;
import rpg.gui.buttons.events.AttackEvent;
import rpg.gui.buttons.AttackButton;

import javax.swing.*;


public class BottomPanel extends Backgroundpanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
                "panels/battlePanel.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }


}
