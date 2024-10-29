package rpg.items;

import rpg.enums.ItemType;

public abstract class Item {

    protected String name;
    protected String description;
    protected int price;
    protected ItemType type;

    public Item() {

        initItem();
    }

    protected abstract void initItem();
}