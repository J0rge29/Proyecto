package rpg.entities.enemies.undead;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.enums.EnemyType;
import rpg.exceptions.EnemyDeathException;

public class Skeleton extends Enemy {

    public Skeleton() {

        super("Skeleton");
        ImageCache.addImage("skeleton", "enemies/undead/Skeleton.png");
    }

    @Override
    public void getLoot() {
        System.out.println("El esqueleto deja caer una pequeña bolsa de monedas.");
    }

    public void initCharacter() {
        this.type = EnemyType.MEDIUM;
        this.stats.put(Stats.MAX_HP, 45);
        this.stats.put(Stats.HP, 45);
        this.stats.put(Stats.ATTACK, 8);
        this.stats.put(Stats.DEFENSE, 4);
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
                    message = boneStrike(enemy);
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
                    message = hauntingScream(enemy);
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

    protected String boneStrike(GameCharacter enemy) throws EnemyDeathException {
        int damage = 4;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s ataca con un golpe de hueso a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String hauntingScream(GameCharacter enemy) throws EnemyDeathException{
        int damage = 2;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s muerde salvajemente a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }
    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("skeleton");
    }
}
