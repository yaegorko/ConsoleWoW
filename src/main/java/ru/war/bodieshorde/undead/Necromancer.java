package ru.war.bodieshorde.undead;

import ru.war.exceptions.WrongRandomException;
import ru.war.races.Undead;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

import java.util.Random;

/**
 * Некромант.
 */
public class Necromancer extends Wizard implements Undead {

    /**
     * Дистанционная атака.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Атакую магией %s на 5!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 5);
    }

    /**
     * Проклятие. Снижает урон от атак на 1 ход.
     * @param target враг.
     */
    public void curse(Solider target) {
        System.out.println(String.format("%s Насылаю недуг на %s", this.toString(), target.toString()));
        target.setCursed(true);
    }

    /**
     * У некроманта только цели враги.
     * @param targetEnemy цель враг.
     * @param targetAlly цель союзник. Не используется.
     */
    @Override
    public void chooseAction(Solider targetEnemy, Solider targetAlly) {
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 1) {
            curse(targetEnemy);
        } else if (num == 0) {
            rangeAttack(targetEnemy);
        } else {
            throw new WrongRandomException();
        }
    }
}
