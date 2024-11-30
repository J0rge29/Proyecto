package rpg.items.weapons;

import rpg.enums.ItemType;
import rpg.enums.WeaponType;
import rpg.items.Equipment;

import java.util.HashMap;

public abstract class Weapon extends Equipment {
    protected WeaponType weaponType;

    public Weapon(String name, String description, int price, WeaponType weaponType) {
        super(name, description, price, ItemType.WEAPON);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}