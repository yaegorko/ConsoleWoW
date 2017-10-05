package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class HumanWarrior extends Warrior implements Human {


    public void attack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Атакую мечом по %s не на 18, а на 9!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 9);
        } else {
            System.out.println(String.format("%s Атакую мечом %s на 18!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 18);
            if (this.isBlesed()) {
                this.setBlesed(false);
                System.out.println("Во имя Света! Я благословлен! Атакую еще раз!");
                attack(target);
            }
        }
        this.setCursed(false);
    }
}
