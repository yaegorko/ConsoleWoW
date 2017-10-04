package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class ElfWizard extends Wizard implements Elf {


    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Атакую магией %s на 10!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 10);
    }



}
