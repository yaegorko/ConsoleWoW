package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class HumanWizard extends Wizard implements Human{


    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Атакую магией %s на 4!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 4);
    }


    public void cast(Solider target) {
        System.out.println(toString() + " Накладываю бафф " + target.toString());
        target.setBlesed(true);
    }
}
