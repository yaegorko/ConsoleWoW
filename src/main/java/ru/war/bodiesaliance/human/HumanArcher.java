package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

public class HumanArcher extends Archer implements Human {


    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 5 " + target.toString());
    }


    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 3 " + target.toString());
    }
}
