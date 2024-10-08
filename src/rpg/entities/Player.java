package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;

public class Player extends GameCharacter {

    public Player(String name) {
        super(name);
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.DEXTERITY, 5);
        this.stats.put(Stats.LUCK, 5);
        this.stats.put(Stats.ACCURACY, 50);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.CRITICAL_HIT, 5);
        this.stats.put(Stats.CRITICAL_DAMAGE, 10);
    }

    private int calculateDamage(int baseDamage, int defense, int accuracy, int evasion, int criticalHitChance, int criticalDamage) {
        int damage = Math.max(0, baseDamage - defense);
        return damage;
    }

}

