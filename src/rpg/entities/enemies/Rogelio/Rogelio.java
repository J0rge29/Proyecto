package rpg.entities.enemies.Rogelio;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.enums.EnemyType;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;


/**
     * Clase base para el enemigo Rogelio.
     */
    public class Rogelio extends Enemy {

        /**
         * Constructor de la clase Rogelio.
         */
        public Rogelio() {
            super("Rogelio");
            ImageCache.addImage("Rogelio", "enemies/goblins/evil_witch.png");
        }

        @Override
        public void getLoot() {
            System.out.println("Rogelio deja caer una gran bolsa de monedas.");
        }

        public void initCharacter(){
            this.type = EnemyType.SECRET;
            this.stats.put(Stats.MAX_HP, 30); // Vida máxima de Rogelio
            this.stats.put(Stats.HP, 30); // Vida actual de Rogelio
            this.stats.put(Stats.ATTACK, 7); // Ataque de Rogelio
            this.stats.put(Stats.DEFENSE, 4); // Defensa de Rogelio
        }
    /**
     * Método que define el ataque del enemigo Kevin. Alterna entre 'Lanzamiento de Piedra' y 'Bola de Fuego'.
     *
     * @param enemy El personaje enemigo que recibirá el ataque.
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
                    message = lanzamientoDePiedra(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Rogelio lanza una piedra y te hace 20 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = bolaDeBasura(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Rogelio  te lanza una bola de basura y te hace 15 de daño.
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
         * Método que realiza el ataque 'Lanzamiento de piedra' de Rogelio.
         *
         * @param enemy El personaje enemigo que recibirá el ataque.
         */
        protected String lanzamientoDePiedra(GameCharacter enemy) throws EnemyDeathException {
            int damage = 20;
            int newHP = reduceHP(enemy, damage);
            String enemyName = enemy.getName();
            String message = String.format("""
                ¡%s lanza una una piedra gigante a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
            return message;
        }

        /**
         * Método que realiza el ataque 'Bola de fuego
         *
         * @param enemy El personaje enemigo que recibirá el ataque.
         */
        protected String bolaDeBasura(GameCharacter enemy) throws EnemyDeathException{
            int damage = 15;
            int newHP = reduceHP(enemy, damage);
            String enemyName = enemy.getName();
            String message = String.format("""
                ¡%s lanza una bola de basura a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
            return message;
        }
        @Override
        public ImageIcon getSprite() {

        return ImageCache.getImageIcon("Rogelio");
        }

    }















