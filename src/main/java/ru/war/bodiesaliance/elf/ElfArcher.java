package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;


public class ElfArcher extends Archer implements Elf {

    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Стреляю на 7 по " + target.toString());
        target.setHealth(target.getHealth() - 7);
        System.out.println("У " + target.toString() + "осталось:" + target.getHealth());
    }


    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Бъю на 3 по " + target.toString());
        target.setHealth(target.getHealth() - 3);

    }
}
