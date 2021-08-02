package parts;

public class Player {

    public String name = "";
    public Cup manaPool;
    public int mana;

    public Player(String name, int initalMana) {
        this.name = name;
        manaPool = new Cup(5);
        this.mana = initalMana;
    }

    @Override
    public String toString() {
        return name;
    }
}
