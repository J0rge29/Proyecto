package rpg.exceptions;

public class InventoryFullException  extends Exception {

    public InventoryFullException() {

        super("El inventario está lleno");
    }

}
