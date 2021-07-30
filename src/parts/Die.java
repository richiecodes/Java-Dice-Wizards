package parts;

import java.util.Random;

public class Die {

    private int sides;
    private int value;
    Random rand;

    public Die(int sides) {
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
}
