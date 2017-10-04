package ru.war.bodieshorde.orc;

import ru.war.exceptions.WrongRandomException;
import ru.war.races.Elf;
import ru.war.races.Human;
import ru.war.races.Orc;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

import java.util.Random;

public class OrcWizard extends Wizard implements Orc {


    public void debuff(Solider target) {
        System.out.println(String.format("%s Снимаю улучшение на %s", this.toString(), target.toString()));
        target.setBlesed(false);
    }

    @Override
    public void chooseAction(Solider targetEnemy, Solider targetAlly) {
        Random random = new Random();
        int num = random.nextInt(1);
        if (num == 0) {
            super.cast(targetAlly);
        } else if (num == 1) {
            debuff(targetEnemy);
        } else {
            throw new WrongRandomException();
        }
    }


}
