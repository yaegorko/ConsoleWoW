package ru.war.warclases;

public abstract class Warrior extends Solider {

    public void rangeAttack() {
        chooseAction(target);
    }


    public void cast() {
        chooseAction(target);
    }


    public void chooseAction(Solider target) {
        attack(target);
    }


    public void attack(Solider target) {

    }
}
