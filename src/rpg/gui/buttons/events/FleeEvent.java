package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FleeEvent implements ActionListener {
    private final MainWindow game;

    public FleeEvent(MainWindow game) {

        this.game = game;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Enemy enemy = this.game.getEnemy();
        Player player = this.game.getPlayer();
        if (enemy != null) {
            this.game.appendText(String.valueOf(player.tryToFlee()));
            this.game.appendText(enemy.attack(player));
            //this.game.checkImage();
        }
    }

}
