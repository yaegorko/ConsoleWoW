package ru.war.bodiesaliance.elf;

import org.junit.Assert;
import org.junit.Test;
import ru.war.OutputTest;
import ru.war.bodieshorde.orc.OrcWarrior;
import ru.war.warclases.Solider;

/**
 * Тест.
 */
public class ElfWarriorTest extends OutputTest {
    /**
     * Тест.
     */
    @Test
    public void elfWarriorTest() {
        Solider elfWarrior = new ElfWarrior();
        elfWarrior.chooseAction(new OrcWarrior());
        Assert.assertEquals("ElfWarrior (100 HP) Атакую мечом OrcWarrior (100 HP) на 15!\r\n", getOutput().toString());
    }
}
