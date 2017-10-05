package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

/**
 * Эльф Воин.
 */
public class ElfWarrior extends Warrior implements Elf {

    /**
     * Мили атака. Может быть двойной если благославлен! Урон может быть снижен если проклят Некромантом.
     * @param target цель враг.
     */
    public void attack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Атакую мечом по %s не на 15, а на 7!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 7);
        } else {
            System.out.println(String.format("%s Атакую мечом %s на 15!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 15);
        }
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Элуны! Я благословлен! Атакую еще раз!");
            attack(target);
        }
        this.setCursed(false);
    }
}
