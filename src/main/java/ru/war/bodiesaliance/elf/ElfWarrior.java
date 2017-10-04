package ru.war.bodiesaliance.elf;

import ru.war.races.Elf;
import ru.war.warclases.Solider;
import ru.war.warclases.Warrior;

public class ElfWarrior extends Warrior implements Elf {

    public void attack(Solider target) {
        System.out.println(String.format("%s Атакую мечом %s на 15!", this.toString(), target.toString()));
        target.setHealth(target.getHealth() - 15);
    }
}
