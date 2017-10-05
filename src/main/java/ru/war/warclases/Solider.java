package ru.war.warclases;

public abstract class Solider {

    int health = 100;

    boolean isBlesed = false;

    boolean isCursed = false;

    public boolean isFatigue() {
        return fatigue;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    boolean fatigue = false;

    Solider target;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isBlesed() {
        return isBlesed;
    }

    public void setBlesed(boolean blesed) {
        isBlesed = blesed;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    public Solider getTarget() {
        return target;
    }

    public void setTarget(Solider target) {
        this.target = target;
    }

    public void chooseAction(Solider targetEnemy, Solider targetAlly) {

    }

    public void chooseAction(Solider targetEnemy) {

    }

    void attack() {

    }

    void rangeAttack() {

    }

    void cast() {

    }

    public String toString() {
        int n = getClass().getTypeName().lastIndexOf('.');
        String s = getClass().getTypeName().substring(n + 1) + " (" + getHealth() + " HP)";
        return s;
    }
}
