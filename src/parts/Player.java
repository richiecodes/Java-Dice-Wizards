package parts;

import java.util.Locale;

public class Player {

    public String name = "";
    public int orbs;
    public ManaPool manaPool;
    public int power;
    String type = "";
    public int manaCost = 3;

    public Player(String name, int initialOrbs, String type) {
        this.name = name.toUpperCase();
        this.orbs = initialOrbs;
        this.type = type;
        manaPool = new ManaPool(6, 6);
        power = manaPool.getPool().size();
    }

    @Override
    public String toString() {
        return name;
    }

    public void displayStats() {
        System.out.printf("\n\t%s %s's turn\nOrbs: %d\nPower: %d\n", type, name, orbs, power);
    }
}
