package ru.war.bodieshorde.undead;

import ru.war.races.Undead;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

/**
 * Охотник. Нежить.
 */
public class Hunter extends Archer implements Undead {
    /**
     * Дистанционная атака.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Стреляю из лука по %s на 4!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 4);
    }

    /**
     * Мили атака.
     * @param target враг.
     */
    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую %s на 2!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 2);
    }
}
