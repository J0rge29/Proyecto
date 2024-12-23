package rpg.entities.enemies.undead;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import rpg.enums.EnemyType;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Skeleton extends Enemy {

    public Skeleton() {
        super("Skeleton");
        ImageCache.addImage("Skeleton", "enemies/Skeleton.jpg");
    }

    @Override
    protected void initCharacter() {

        this.stats.put(Stats.MAX_HP, 45);
        this.stats.put(Stats.HP, 45);
        this.stats.put(Stats.ATTACK, 8);
        this.stats.put(Stats.DEFENSE, 4);
    }

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Skeleton");
    }

    @Override
    public void getLoot() {

    }


    @Override
    public String attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 3);
        switch (attack) {
            case 1:
                boneStrike(enemy);
                break;
            case 2:
                boneStrike(enemy);
            default:
                hauntingScream(enemy);
                break;
        }
        return "";
    }

    protected void SkeletonType() {
        this.type = EnemyType.MEDIUM;
    }

    protected void boneStrike(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " strikes " + enemy.getName() + " with a bone for "
                + damage + " damage!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void hauntingScream(GameCharacter enemy) {
        int damage = 2;
        int defenseReduction = 1;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        enemy.getStats().put(Stats.DEFENSE, Math.max(0, enemy.getStats().get(Stats.DEFENSE) - defenseReduction));
        System.out.println(this.name + " lets out a haunting scream, dealing " + damage + " damage and reducing "
                + enemy.getName() + "'s defense by " + defenseReduction + "!");
        System.out.println(enemy.getName() + " has " + enemy.getStats().get(Stats.HP) + " HP and "
                + enemy.getStats().get(Stats.DEFENSE) + " defense left.");
    }
}
