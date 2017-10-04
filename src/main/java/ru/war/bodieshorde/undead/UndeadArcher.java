package ru.war.bodieshorde.undead;

import ru.war.races.Undead;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

public class UndeadArcher extends Archer implements Undead {

    public void rangeAttack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 4 " + target.toString());
    }

    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 2 " + target.toString());
    }
}
