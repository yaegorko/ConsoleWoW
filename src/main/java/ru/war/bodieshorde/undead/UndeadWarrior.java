package ru.war.bodieshorde.undead;

import ru.war.races.Undead;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

/**
 * Зомби. Нежить.
 */
public class UndeadWarrior extends Warrior implements Undead {
    /**
     * Мили атака.
     * @param target цель враг.
     */
    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую копьем %s на 18!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 18);
    }
}
