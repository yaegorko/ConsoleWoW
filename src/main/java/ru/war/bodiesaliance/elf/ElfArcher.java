package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;


public class ElfArcher extends Archer implements Elf {

    public void rangeAttack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Cтреляю из лука по %s не на 7, а на 3!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 3);
        } else {
            System.out.println(String.format("%s Стреляю из лука по %s на 7!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 7);
        }
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Элуны! Я благословлен! Атакую еще раз!");
            rangeAttack(target);
        }
        this.setCursed(false);
    }

    public void attack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Атакую по %s не на 3, а на 1!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 1);
        } else {
            System.out.println(String.format("%s Атакую противника %s на 3!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 3);
        }
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Элуны! Я благословлен! Атакую еще раз!");
            attack(target);
        }
        this.setCursed(false);
    }
}
