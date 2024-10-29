package rpg.items.armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

import java.util.HashMap;

public abstract class Armor extends Equipment {
    protected ArmorType armorType;
    protected ItemType type;
    protected int durability;
    protected HashMap<String, Integer> elementalResistance;

    public Armor(String name, String description, int price, ArmorType armorType, int durability){
        this.name = "leather armor";
        this.description = "ideal para ataques cuerpo a cuerpo";
        this.price = 50;
        this.armorType= ArmorType.HELMET;
        this.durability = durability;
        this.elementalResistance = new HashMap<>();
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void addElementalResistance(String element, int resistanceValue) {
        elementalResistance.put(element, resistanceValue);
    }

    public int getElementalResistance(String element) {
        return elementalResistance.getOrDefault(element, 0);
    }

    public void reduceDurability(int amount) {
        this.durability -= amount;
        if (this.durability < 0) {
            this.durability = 0;
        }
    }

    public boolean isBroken() {
        return this.durability == 0;
    }
}

