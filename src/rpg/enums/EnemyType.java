package rpg.enums;

public enum EnemyType {
    BASIC("basico"),
    MEDIUM("medio"),
    BOSS("jefe"),
    SECRET("secreto");

    private String nombre;

    EnemyType(String nombre) {
        this.nombre = nombre;
    }

    protected String getNombre() {
        return nombre;
    }
}
