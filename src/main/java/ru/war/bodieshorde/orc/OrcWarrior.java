package ru.war.bodieshorde.orc;

import ru.war.races.Orc;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

/**
 * Гоблин.
 */
public class OrcWarrior extends Warrior implements Orc {
    /**
     * Мили атака. Может быть двойной если Waaaaaaaaagh!
     * @param target цель враг.
     */
    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую дубиной %s на 20!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 20);
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Waaaaaaaaagh! Атакую еще раз!");
            attack(target);
        }
    }
}
