package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class HumanWizard extends Wizard implements Human{


    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Кастую на 4 " + target.toString());
    }


    public void cast(Solider target) {

        System.out.println(getClass().getName() + " Накладываю бафф " + target.toString());
    }
}
