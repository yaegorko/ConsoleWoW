package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

public class HumanArcher extends Archer implements Human {


    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Стреляю из арбалета по %s на 7!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 5);
    }


    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую %s на 3!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 3);
    }
}
