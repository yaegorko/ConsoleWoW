package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;


public class ElfArcher extends Archer implements Elf {

    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Стреляю из лука по %s на 7!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 7);
    }


    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую противника %s на 3!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 3);

    }
}
