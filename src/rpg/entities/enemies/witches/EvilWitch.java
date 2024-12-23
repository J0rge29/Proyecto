package rpg.entities.enemies.witches;
import rpg.utils.cache.ImageCache;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.enums.EnemyType;

import javax.swing.*;

public class EvilWitch extends Enemy {

    /**
     * Constructor de la clase EvilWitch
     */

    public EvilWitch() {
        super("Evil Witch");
        ImageCache.addImage("evil_witch", "enemies/Witch.jpg");
    }

    protected void initCharacter(){
        this.stats.put(Stats.MAX_HP, 40);
        this.stats.put(Stats.HP, 40);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 4);
    }

    /**
     * metodo para hacer el ataque "lanza un poderoso hechizo"
     * @param enemy El personaje enemigo recibirá el ataque
     */

    protected void castPowerfulSpell(GameCharacter enemy) {
        int damage = (int) (this.stats.get(Stats.ATTACK) * 0.8);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " lanza un poderoso hechizo " + enemy.getName() + " provocando " + damage + " de daño!");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restante.");
    }
    protected void witchType(){
        this.type = EnemyType.SECRET;
    }
    /**
     * Metodo para hacer el ataque "lanza un hechizo debil"
     * @param enemy El personaje enemigo recibirá el ataque
     */
    protected void castSpell(GameCharacter enemy) {

        int damage = 6;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " lanza un hechizo débil " + enemy.getName() + " provocando " + damage + " de daño!");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restante.");
    }

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("evil_witch");
    }

    @Override
    public void getLoot() {

    }



    @Override
    public String attack(GameCharacter enemy) {
        if (Math.random() < 0.5) {
            castPowerfulSpell(enemy);
        } else {
            castSpell(enemy);
        }
        return "";
    }
}
