package ru.war.bodiesaliance.elf;

import org.junit.Test;
import ru.war.bodieshorde.orc.OrcWarrior;
import ru.war.warclases.Solider;

public class ElfWizardTest {
    @Test
    public void elfWizardActions() {
        Solider elfWizard = new ElfWizard();
        Solider orc = new OrcWarrior();
        elfWizard.chooseAction(orc);
    }
}
