package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;

import java.util.HashMap;

public abstract class Equipment extends Item implements Equipable {

    protected HashMap<Stats, Integer> stats;

    @Override
    public void equip(Player player) {

    }

    @Override
    public void unequip(Player player) {

    }
}

