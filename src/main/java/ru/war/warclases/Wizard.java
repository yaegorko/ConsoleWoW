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
        int num = random.nextInt(2);
        if (num == 0) {
            buff(targetAlly);
        } else if (num == 1) {
            rangeAttack(targetEnemy);
        } else {
            throw new WrongRandomException();
        }
    }

    public void buff(Solider target) {
        System.out.println(String.format("%s Накладываю улучшение на %s!", this.toString(), target.toString()));
        target.setBlesed(true);
    }
}
