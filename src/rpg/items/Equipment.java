package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;
import java.util.HashMap;

public abstract class Equipment extends Item{

    protected HashMap<Stats, Integer> stats;
}