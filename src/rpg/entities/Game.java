package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.witches.EvilWitch;

import javax.swing.*;

public class Game {
    /**
     * Nombres de los pesonajes
     */
    private Player player;
    private Enemy enemy;

    public Game() {
        this.enemy = new EvilWitch();
        this.player = new Player("Hero");
    }

    public void startGame() {
        /**
         *	Funcion que inicia el juego
         */
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        /**
         *	Funcion que se ejecuta mientras alguno de los personajes muera
         */
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, "Derrotaste al anemigo");
        } else {
            JOptionPane.showMessageDialog(null, "Fin del juego");
        }
    }
}



