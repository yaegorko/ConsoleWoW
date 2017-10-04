package ru.war.bodiesaliance.elf;

import org.junit.Test;
import ru.war.bodiesaliance.human.HumanWarrior;
import ru.war.warclases.Solider;

public class ElfArcherTest {
    @Test
    public void testAttack() {
        Solider elfArcher = new ElfArcher();
        elfArcher.chooseAction(new HumanWarrior());
    }
}
