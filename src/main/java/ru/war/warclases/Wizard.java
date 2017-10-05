package ru.war.warclases;

import ru.war.exceptions.WrongRandomException;

import java.util.Random;

/**
 * Прототип классов для магов.
 */
public abstract class Wizard extends Solider {

    /**
     * Ближняя атака. У магов отсутствует.
     * На всякий случай перекидываем на выбор действия для магов.
     */
    void attack() {
        chooseAction(this.getTarget());
    }

    /**
     * Дистанционная атака магов.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {

    }

    /**
     * Выбор случайного действия для магов.
     * @param targetEnemy цель враг.
     * @param targetAlly цель союзник.
     */
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

    /**
     * Метод увеличивающий дамаг в 2 раза. Для магов Эльфов, Людей, Орков.
     * Должен еще давать приоритет в ходе ( пока не реализовано)
     * @param target союзник.
     */
    public void buff(Solider target) {
        System.out.println(String.format("%s Накладываю улучшение на %s!", this.toString(), target.toString()));
        target.setBlesed(true);
    }
}
