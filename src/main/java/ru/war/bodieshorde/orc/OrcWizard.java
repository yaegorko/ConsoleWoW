package ru.war.bodieshorde.orc;

import ru.war.races.Orc;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

public class OrcWizard extends Wizard implements Orc {


    public void cast(Solider target) {
        System.out.println(getClass().getName() + " Каст в " + target.toString());
    }

    public void debuff(Solider target) {
        System.out.println(getClass().getName() + " Debuff v " + target.toString());

    }
}
