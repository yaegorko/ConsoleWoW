package ru.war.warclases;

import ru.war.exceptions.WrongRandomException;

import java.util.Random;

public abstract class Wizard extends Solider {

    public void attack() {
        chooseAction();
    }

    public void rangeAttack() {

    }

    public void chooseAction() {
        Random random = new Random();
        int num = random.nextInt(2) + 1;
        if (num == 1) {
            cast();
        } else if (num == 2) {
            rangeAttack();
        } else {
            throw new WrongRandomException();
        }
    }

    public void cast() {

    }
}
