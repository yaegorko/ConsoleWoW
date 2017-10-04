package ru.war.bodieshorde.undead;

import ru.war.races.Undead;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class UndeadWarrior extends Warrior implements Undead {

    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 18 " + target.toString());
    }
}
