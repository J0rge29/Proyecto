package rpg.entities.enemies.witches;

import rpg.utils.Randomize;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.enums.EnemyType;
import rpg.exceptions.EnemyDeathException;

public class EvilWitch extends Enemy {


    public EvilWitch() {

        super("Evil Witch");
        ImageCache.addImage("evil_witch", "enemies/goblins/evil_witch.png");
    }

    @Override
    public void getLoot() {
        System.out.println("La bruja malvada deja caer una gran bolsa de monedas.");
    }

    /**
     * Constructor de la clase EvilWitch
     */

    protected void initCharacter() {
        this.type = EnemyType.SECRET;
        this.stats.put(Stats.MAX_HP, 35);
        this.stats.put(Stats.HP, 35);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 2);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 10);
    }

    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = castPowerfulSpell(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            La bruja malvada lanza un poderoso hechizo y te hace 10 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = castSpell(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            La bruja malvada  te lanza un hechizco común y te hace 5 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter) this).attack(enemy);
                break;
        }
        return message;
    }

    /**
     * metodo para hacer el ataque "lanza un poderoso hechizo"
     *
     * @param enemy El personaje enemigo recibirá el ataque
     */

    protected String castPowerfulSpell(GameCharacter enemy) throws EnemyDeathException{
        int damage = 10;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza un poderoso hehcizo a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    /**
     * Metodo para hacer el ataque "lanza un hechizo debil"
     *
     * @param enemy El personaje enemigo recibirá el ataque
     */
    protected String castSpell(GameCharacter enemy) throws EnemyDeathException{
        int damage = 5;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza un hechizo debil a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;

    }
    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("evil_witch");
    }

}
