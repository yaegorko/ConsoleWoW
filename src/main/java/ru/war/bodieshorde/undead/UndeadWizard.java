package ru.war.bodieshorde.undead;

import ru.war.races.Undead;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class UndeadWizard extends Wizard implements Undead{


    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Каст на 5! " + target.toString());
    }


    public void cast(Solider target) {
        System.out.println(getClass().getName() + " Debuff " + target.toString());
    }
}
