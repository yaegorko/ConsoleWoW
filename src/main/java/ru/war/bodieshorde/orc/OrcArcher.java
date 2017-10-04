package ru.war.bodieshorde.orc;

import ru.war.races.Orc;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

public class OrcArcher extends Archer implements Orc {

    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 3" + target.toString());
    }


    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 2 " + target.toString());
    }
}
