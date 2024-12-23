package rpg.items.weapons;

import rpg.items.Equipment;
import rpg.enums.ItemType;
import rpg.enums.Stats;

import java.util.HashMap;

public class ShortSword extends Equipment {
    protected ItemType type;

    protected void initItem() {
        this.name = "Espada Corta";
        this.description = "Espada basica. Ideal para ataques rapidos.";
        this.price = 75;
        this.type = ItemType.WEAPON;
        this.stats = new HashMap<>();
        this.stats.put(Stats.ATTACK, 10); // Aumenta ataque en 10 puntos
    }
}

