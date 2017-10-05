package ru.war.bodieshorde.orc;

import ru.war.exceptions.WrongRandomException;
import ru.war.races.Orc;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

import java.util.Random;

/**
 * Орк Шаман.
 */
public class OrcWizard extends Wizard implements Orc {

    /**
     * Шаман снимает баффы.
     * @param target враг.
     */
    public void debuff(Solider target) {
        System.out.println(String.format("%s Снимаю улучшение на %s", this.toString(), target.toString()));
        target.setBlesed(false);
    }

    /**
     * Шаман не умеет наносить урон.
     * @param targetEnemy цель враг.
     * @param targetAlly цель союзник.
     */
    @Override
    public void chooseAction(Solider targetEnemy, Solider targetAlly) {
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0) {
            super.buff(targetAlly);
        } else if (num == 1) {
            debuff(targetEnemy);
        } else {
            throw new WrongRandomException();
        }
    }


}
