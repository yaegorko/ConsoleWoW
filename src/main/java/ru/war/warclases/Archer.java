package ru.war.warclases;

import ru.war.exceptions.WrongRandomException;

import java.util.Random;

/**
 * Прототип для всех лучников.
 */
public abstract class Archer extends Solider {

    /**
     * Переопределяем выбор действий для лучников.
     * @param target враг.
     */
    public void chooseAction(Solider target) {
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0) {
            attack(target);
        } else if (num == 1) {
            rangeAttack(target);
        } else {
            throw new WrongRandomException();
        }
    }

    /**
     * Нет у лучников.
     */
    public void cast() {
        chooseAction(this.getTarget());
    }

    /**
     * Дистанционная атака.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {

    }

    /**
     * Мили атака.
     * @param target враг.
     */
    public void attack(Solider target) {

    }
}
