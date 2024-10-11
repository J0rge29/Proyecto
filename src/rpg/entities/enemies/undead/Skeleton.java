package rpg.entities.enemies.undead;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.utils.Randomize;

public class Skeleton extends Enemy {

    public Skeleton() {
        super();
        this.name = "Skeleton";
        this.stats.put(Stats.MAX_HP, 45);
        this.stats.put(Stats.HP, 45);
        this.stats.put(Stats.ATTACK, 8);
        this.stats.put(Stats.DEFENSE, 4);
    }

    @Override
    public void attack(GameCharacter enemy) {
        int attack = Randomize.getRandomInt(1, 3);
        switch (attack) {
            case 1:
                boneStrike(enemy);
                break;
            case 2:
                hauntingScream(enemy);
                break;
            default:
                super.attack(enemy);
                break;
        }
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
