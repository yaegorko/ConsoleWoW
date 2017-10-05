package ru.war.start;

import org.junit.Test;

/**
 * Тесты боя.
 */
public class GenerateFightsTest {
    /**
     * тест.
     */
    @Test
    public void fightTest() {
        GenerateFights fights = new GenerateFights();
        fights.startFight();
    }
}
