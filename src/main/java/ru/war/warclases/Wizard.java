package ru.war.warclases;

import ru.war.exceptions.WrongRandomException;

import java.util.Random;

public abstract class Wizard extends Solider {

    void attack() {
        chooseAction(target);
    }

    public void rangeAttack(Solider target) {

    }

    public void chooseAction(Solider targetEnemy, Solider targetAlly) {
        Random random = new Random();
        int num = random.nextInt(1);
        if (num == 0) {
            cast(targetAlly);
        } else if (num == 1) {
            rangeAttack(targetEnemy);
        } else {
            throw new WrongRandomException();
        }
    }

    public void cast(Solider target) {
        System.out.println(String.format("%s Накладываю улучшение магией %s на 10!", this.toString(), target.toString()));
        target.setBlesed(true);
    }
}
