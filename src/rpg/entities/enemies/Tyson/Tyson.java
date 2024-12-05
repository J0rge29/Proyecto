
package rpg.entities.enemies.Tyson;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.enums.EnemyType;

import javax.swing.*;


/**
 * Clase base para el enemigo. El enemigo se llama Tyson.
 */
public class Tyson extends Enemy {

    /**
     * Constructor de la clase Tyson.
     */

    public Tyson () {
        super("Tyson");
        this.stats.put(Stats.MAX_HP, 150); // Vida máxima de Tyson
        this.stats.put(Stats.HP, 150); // Vida actual de Tyson
        this.stats.put(Stats.ATTACK, 8); // Ataque de Tyson
        this.stats.put(Stats.DEFENSE, 9); // Defensa de Tyson
    }

    /**
     * Método que realiza el ataque 'golpe' de Tyson.
     */
    protected void golpeCallejero(GameCharacter enemy) {
        int damage = 2;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage); // Aplica el daño al enemigo
        System.out.println(this.name + " realiza un golpe callejero a " + enemy.getName() + " causando " + damage + " de daño.");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " de vida restante.");
    }

    /**
     * Método que realiza el ataque 'Empujón'.
     */
    protected void empujon(GameCharacter enemy) {
        int damage = (int) (this.stats.get(Stats.ATTACK) * 0.75); // Daño reducido para el empujón
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage); // Aplica el daño al enemigo
        System.out.println(this.name + " empuja a " + enemy.getName() + " causando " + damage + " de daño.");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " de vida restante.");
    }

    @Override
    public ImageIcon getSprite() {
        return null;
    }

    @Override
    public void getLoot() {

    }

    @Override
    protected void initCharacter() {

    }

    /**
     * Método que define el ataque del enemigo Luiyi. Alterna entre 'Golpe Callejero' y 'Empujón'.
     */
    @Override
    public String attack(GameCharacter enemy) {
        if (Math.random() < 0.5) {
            golpeCallejero(enemy); // 50% de probabilidad de usar Golpe Callejero
        } else {
            empujon(enemy); // 50% de probabilidad de usar Empujón
            // }
        }

        return "";
    }

}
