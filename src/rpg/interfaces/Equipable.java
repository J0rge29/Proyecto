package rpg.interfaces;
import rpg.items.Item;
import java.util.ArrayList;
import java.util.List;
import rpg.inventory.Inventory;

public abstract class Equipable extends Item{
    // List to store equipped items
    private List<String> equippedItems;

    void CharacterInventory() {
        // Initialize the list to hold equipped items
        equippedItems = new ArrayList<>();
    }

    void equip(){
        if (!equippedItems.contains(name)) {
            equippedItems.add(name);
            System.out.println(name + " has been equipped.");
        } else {
            System.out.println(name + " is already equipped.");
        }
    }
    void unequip(){
        if (equippedItems.contains(name)) {
            equippedItems.remove(name);
            System.out.println(name + " has been unequipped.");
        } else {
            System.out.println(name + " is not equipped.");
        }
    }
}
