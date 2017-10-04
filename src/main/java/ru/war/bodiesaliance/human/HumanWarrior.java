package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class HumanWarrior extends Warrior implements Human {


    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 18 " + target.toString());
    }
}
