package ru.war.warclases;

/**
 * Прототип классов воинов ближнего боя.
 */
public abstract class Warrior extends Solider {

    /**
     * Дистанционная атака. У воинов нет.
     */
    public void rangeAttack() {
        chooseAction(this.getTarget());
    }

    /**
     * Баффы дебаффы. Тут нет.
     */
    public void cast() {
        chooseAction(this.getTarget());
    }

    /**
     * Выбор действия.
     * Тут только ближний бой.
     * @param target цель враг.
     */
    public void chooseAction(Solider target) {
        attack(target);
    }

    /**
     * Ближний бой. Переопределяем потом у каждого война.
     * @param target цель враг.
     */
    public void attack(Solider target) {

    }
}
