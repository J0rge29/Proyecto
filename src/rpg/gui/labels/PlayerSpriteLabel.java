package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel {

    public PlayerSpriteLabel() {

        super();
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("playerSprite", "player/Player.jpg");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        //setPreferredSize(new Dimension(icon.getIconWidth(),
               // icon.getIconHeight()));
        setIcon(icon);
    }
    private Dimension getMinDimension() {

        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 184) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }

}
