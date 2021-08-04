package parts;

import java.util.Random;

public class Mana {

    private int sides;
    private int value;
    Random rand;

    public Mana(int sides) {
        this.sides = sides;
        rand = new Random();

        this.value = rand.nextInt(sides) + 1;
    }

    public void roll() {
        this.value = rand.nextInt(sides) + 1;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "/```\\\n" +
                "| " + getValue() + " |\n" +
                "\\,,,/";
    }
}
