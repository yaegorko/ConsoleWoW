package ru.war.bodieshorde.orc;

import ru.war.races.Orc;
import ru.war.warclases.Archer;
import ru.war.warclases.Solider;

public class OrcArcher extends Archer implements Orc {

    public void rangeAttack(Solider target) {
        System.out.println(String.format("%s Стреляю из лука по %s на 3!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 3);
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Waaaaaaaaagh! Атакую еще раз!");
            rangeAttack(target);
        }
    }

    public void attack(Solider target) {
        System.out.println(String.format("%s Удар клинком по %s на 2!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 2);
        if (this.isBlesed()) {
            this.setBlesed(false);
            System.out.println("Waaaaaaaaagh! Атакую еще раз!");
            attack(target);
        }
    }
}
