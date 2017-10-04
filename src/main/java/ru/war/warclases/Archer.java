package ru.war.warclases;

import ru.war.exceptions.WrongRandomException;

import java.util.Random;

public abstract class Archer extends Solider {

    public void chooseAction(Solider target) {
        Random random = new Random();
        int num = random.nextInt(2) + 1;
        if (num == 1) {
            attack(target);
        } else if (num == 2) {
            rangeAttack(target);
        } else {
            throw new WrongRandomException();
        }
    }

    public void cast() {
        chooseAction(target);
    }

    public void rangeAttack(Solider target) {

    }

    public void attack(Solider target) {

    }
}
