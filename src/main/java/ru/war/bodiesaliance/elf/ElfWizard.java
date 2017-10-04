package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class ElfWizard extends Wizard implements Elf {


    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Пуляю на 10! " + target.toString());;
    }


    public void cast(Solider target) {
        System.out.println(getClass().getName() + " Бафнул! " + target.toString());
    }
}
