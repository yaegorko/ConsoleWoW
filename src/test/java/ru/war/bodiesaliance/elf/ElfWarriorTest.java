package ru.war.bodiesaliance.elf;

import org.junit.Assert;
import org.junit.Test;
import ru.war.OutputTest;
import ru.war.bodieshorde.orc.OrcWarrior;
import ru.war.warclases.Solider;

public class ElfWarriorTest extends OutputTest {

    @Test
    public void elfWarriorTest() {
        Solider elfWarrior = new ElfWarrior();
        elfWarrior.chooseAction(new OrcWarrior());
        Assert.assertEquals("Бью на 15!\r\n", output.toString());
    }
}
