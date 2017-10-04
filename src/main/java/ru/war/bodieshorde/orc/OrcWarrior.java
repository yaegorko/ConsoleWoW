package ru.war.bodieshorde.orc;

import ru.war.races.Orc;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class OrcWarrior extends Warrior implements Orc{

    public void attack(Solider target) {
        System.out.println(getClass().getName() + " Атака на 20 " + target.toString());
    }
}
