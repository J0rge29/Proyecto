package rpg.items.misc;

import rpg.items.Item;
import rpg.enums.ItemType;

public class HealthPotion extends Item {

    @Override
    protected void initItem() {
        this.name = "Health Potion";
        this.description = "Restores 50 health points.";
        this.price = 10;
        this.type = ItemType.MISC;
    }

    public void use() {
        System.out.println("You used a Health Potion and restored 50 health points!");
        // Lógica para restaurar la salud en el juego
    }
}

