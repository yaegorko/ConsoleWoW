package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

/**
 * Эльф Маг.
 */
public class ElfWizard extends Wizard implements Elf {
    /**
     * Дистанционная атака магией. Может быть двойной если благославлен! Урон может быть снижен если проклят Некромантом.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Атакую магией по %s не на 10, а на 5!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 5);
        } else {
            System.out.println(String.format("%s Атакую магией %s на 10!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 10);
        }

        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Элуны! Я благословлен! Атакую еще раз!");
            rangeAttack(target);
        }
        this.setCursed(false);
    }
}
