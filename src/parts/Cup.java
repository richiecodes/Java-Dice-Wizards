package parts;

import java.util.ArrayList;
import java.util.List;

public class Cup {

    int diceInCup;
    List<Die> dice;

    public Cup(int diceInCup) {
        this.diceInCup = diceInCup;
        dice = new ArrayList<>();

        addDie(diceInCup, 6);
    }

    public void rollAll() {
        for(var die : dice) {
            die.roll();
        }
    }

    public void removeDie(int dieToRemove) {
        dice.remove(dieToRemove);
    }

    public void addDie(int sidesOfDie) {
        dice.add(new Die(sidesOfDie));
    }

    public void addDie(int count, int sidesOfDie) {
        for (int i = 0; i < count; i++) {
            dice.add(new Die(sidesOfDie));
        }
    }

    @Override
    public String toString() {
        String out = "";

        for (var die : dice) {
            out += "|" + die.getValue() + "|\t";
        }

        return out;
    }
}
