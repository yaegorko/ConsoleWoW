package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

/**
 * Человек Маг.
 */
public class HumanWizard extends Wizard implements Human {

    /**
     * Дистанционная атака магией. Может быть двойной если благославлен!
     * @param target враг.
     */
    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Атакую магией %s на 4!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 4);
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Света! Я благословлен! Атакую еще раз!");
            rangeAttack(target);
        }
    }
}
