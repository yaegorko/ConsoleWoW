package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class HumanWarrior extends Warrior implements Human {


    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую мечом %s на 18!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 18);
    }
}
