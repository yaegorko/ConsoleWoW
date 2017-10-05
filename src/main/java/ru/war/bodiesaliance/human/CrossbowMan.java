package ru.war.bodiesaliance.human;

import ru.war.races.Human;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

/**
 * Человек Арбалетчик.
 */
public class CrossbowMan extends Archer implements Human {

    /**
     * Дистанционная атака. Может быть двойной если благославлен! Урон может быть снижен если проклят Некромантом.
     * @param target враг.
     */
    public void rangeAttack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Cтреляю из арбалета по %s не на 7, а на 3!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 3);
        } else {
            System.out.println(String.format("%s Стреляю из арбалета по %s на 7!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 5);
        }

        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Света! Я благословлен! Атакую еще раз!");
            rangeAttack(target);
        }
        this.setCursed(false);
    }

    /**
     * Мили атака. Может быть двойной если благославлен! Урон может быть снижен если проклят Некромантом.
     * @param target враг.
     */
    public void attack(Solider target) {
        if (this.isCursed()) {
            System.out.println(String.format("%s Я проклят!!! Атакую по %s не на 3, а на 1!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 1);
        } else {
            System.out.println(String.format("%s Атакую %s на 3!", this.toString(), target.toString()));
            target.setHealth(target.getHealth() - 3);
        }

        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Во имя Света! Я благословлен! Атакую еще раз!");
            attack(target);
        }
        this.setCursed(false);
    }
}
