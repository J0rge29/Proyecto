
package rpg.entities.enemies.Tyson;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.enums.EnemyType;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;


/**
 * Clase base para el enemigo. El enemigo se llama Tyson.
 */
public class Tyson extends Enemy {

    /**
     * Constructor de la clase Tyson.
     */

    public Tyson () {

        super("Tyson");
        ImageCache.addImage("Tyson", "enemies/goblins/evil_witch.png");
    }

    @Override
    public void getLoot() {
        System.out.println("Tyson deja caer una tesoro lleno de monedas.");
    }

    protected void initCharacter(){
        this.type = EnemyType.BOSS;
        this.stats.put(Stats.MAX_HP, 150); // Vida máxima de Tyson
        this.stats.put(Stats.HP, 150); // Vida actual de Tyson
        this.stats.put(Stats.ATTACK, 8); // Ataque de Tyson
        this.stats.put(Stats.DEFENSE, 9); // Defensa de Tyson
    }
    /**
     * Método que define el ataque del enemigo Luiyi. Alterna entre 'Golpe Callejero' y 'Empujón'.
     */

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
                    message = golpeCallejero(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Tyson realiza un golpe callejero y te hace 10 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = empujon(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Tyson  te da un fuerte empujón y te hace 30 de daño.
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
     * Método que realiza el ataque 'golpe' de Tyson.
     */
    protected String golpeCallejero(GameCharacter enemy) throws EnemyDeathException {
        int damage = 10;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s realiza un golpe callejero a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    /**
     * Método que realiza el ataque 'Empujón'.
     */
    protected String empujon(GameCharacter enemy) throws EnemyDeathException{
        int damage = 30;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s empuja a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }
    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("Tyson");
    }

}
