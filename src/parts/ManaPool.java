package parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManaPool {

    List<Mana> pool;

    public ManaPool(int mana, int sides) {
        pool = new ArrayList<>();
        addMana(mana, sides);
    }

    public void rollAll() {
        for(var mana : pool) {
            mana.roll();
        }

    }

    public void removeMana(int manaToRemove) {
        pool.remove(manaToRemove);
    }

    public void addMana(int amount, int sidesOfDie) {
        for (int i = 0; i < amount; i++) {
            pool.add(new Mana(sidesOfDie));
        }

    }

    public List<Mana> getPool() {
        return pool;
    }

    public List<Integer> getPoolValues() {
        List<Integer> poolValues = new ArrayList<>();

        for(var mana : pool) {
            poolValues.add(mana.getValue());
        }

        return poolValues;
    }

    public Mana getMana(int index) {
        return pool.get(index);
    }

    @Override
    public String toString() {
        String out = "";

        for (var mana : pool) {
            out += mana + "\t";
        }

        return out;
    }
}
