package rpg.entities;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;

import javax.swing.*;
import java.util.HashMap;

public class GameCharacter {



    protected String name;

    protected HashMap<Stats, Integer> stats;

    protected EnemyType type;

    public GameCharacter(String name) {

        this.name = name;
        this.stats = new HashMap<>();
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {

        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK)
                - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage > 0) {

            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, newHP);
            message += String.format("""
                            %s attacks %s for %d damage!
                            %s has %d HP left.
                            """, this.name, enemyName, damage,
                    enemyName, newHP);
        } else {
            message += String.format("""
                    %s attacks %s but does no damage!
                    %s has %d HP left.
                    """, this.name, enemyName, enemyName, newHP);
        }
        System.out.println(message);
    }

    public void getEnemyType(GameCharacter enemy) {
        int type = Randomize.getRandomInt(1, 4);
        switch (type) {
            case 1:
                this.type = EnemyType.BASIC;
                break;
            case 2:
                this.type = EnemyType.MEDIUM;
                break;
            case 3:
                this.type = EnemyType.BOSS;
            default:
                this.type = EnemyType.SECRET;
                break;
        }
    }

    public String getName() {
        return String.format("%s el Intrépido", name);
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }









}