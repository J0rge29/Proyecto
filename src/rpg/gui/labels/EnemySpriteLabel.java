package rpg.gui.labels;

import javax.swing.*;
import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;
import java.awt.*;


public class EnemySpriteLabel extends JLabel {

    ImageIcon icon;
    Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {

        this.enemy = enemy;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    public void initComponents() {

        icon = enemy.getSprite();
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
    }

    private Dimension getMinDimension() {

        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 184) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(150, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }


}
