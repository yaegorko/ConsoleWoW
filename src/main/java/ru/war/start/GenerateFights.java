package ru.war.start;

import ru.war.bodiesaliance.elf.ElfArcher;
import ru.war.bodiesaliance.elf.ElfWarrior;
import ru.war.bodiesaliance.elf.ElfWizard;
import ru.war.bodiesaliance.human.CrossbowMan;
import ru.war.bodiesaliance.human.HumanWarrior;
import ru.war.bodiesaliance.human.HumanWizard;
import ru.war.bodieshorde.orc.Goblin;
import ru.war.bodieshorde.orc.OrcArcher;
import ru.war.bodieshorde.orc.Shaman;
import ru.war.bodieshorde.undead.Hunter;
import ru.war.bodieshorde.undead.Necromancer;
import ru.war.bodieshorde.undead.Zomby;
import ru.war.exceptions.WrongRandomException;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * Класс событий боя.
 */
public class GenerateFights {
    /**
     * Команда Альянса, Эльфы, Люди.
     */
    private ArrayList<Solider> teamAlliance;
    /**
     * Команда орды. Орки, Нежить.
     */
    private ArrayList<Solider> teamHorde;

    /**
     * Получить команду Альянса.
     * @return команда альянса.
     */
    public ArrayList<Solider> getTeamAlliance() {
        return teamAlliance;
    }

    /**
     * Получить команду Орды.
     * @return команда орды.
     */
    public ArrayList<Solider> getTeamHorde() {
        return teamHorde;
    }

    /**
     * Генератор случайных чисел в диапазоне.
     * @param number  0 <= диапазон < number;
     * @return число из дапазона.
     */
    public int random(int number) {
        Random random = new Random();
        int num = random.nextInt(number);
        return num;
    }

    /**
     * Генерируем команды случайных противников Альянс против Орды.
     */
    private void generateTeams() {
        int teamAllianceGenerate = random(2);
        int teamHordeGenerate = random(2);
        if (teamAllianceGenerate == 0) {
            this.teamAlliance = new ArrayList<>(asList(new ElfWizard(),
                                               new ElfArcher(), new ElfArcher(), new ElfArcher(),
                                               new ElfWarrior(), new ElfWarrior(), new ElfWarrior(), new ElfWarrior()));
        } else if (teamAllianceGenerate == 1) {
            this.teamAlliance = new ArrayList<>(asList(new HumanWizard(),
                                               new CrossbowMan(), new CrossbowMan(), new CrossbowMan(),
                                               new HumanWarrior(), new HumanWarrior(), new HumanWarrior(), new HumanWarrior()));
        } else {
            throw new WrongRandomException();
        }

        if (teamHordeGenerate == 0) {
            this.teamHorde = new ArrayList<>(asList(new Shaman(),
                                            new OrcArcher(), new OrcArcher(), new OrcArcher(),
                                            new Goblin(), new Goblin(), new Goblin(), new Goblin()));
        } else if (teamHordeGenerate == 1) {
            this.teamHorde = new ArrayList<>(asList(new Necromancer(),
                                            new Hunter(), new Hunter(), new Hunter(),
                                            new Zomby(), new Zomby(), new Zomby(), new Zomby()));
        } else {
            throw new WrongRandomException();
        }
    }

    /**
     * Генерируем право первого хода.
     */
    public void startFight() {
        generateTeams();
        int whoStart = random(2);
        if (whoStart == 1) {
            fight(getTeamAlliance(), getTeamHorde());
        } else if (whoStart == 0) {
            fight(getTeamHorde(), getTeamAlliance());
        } else {
            throw new WrongRandomException();
        }
    }

    /**
     * Проверяем усталость всей команды.
     * @param team команда.
     * @return количество солдат с усталостью (выполняли действия в этом ходу)
     */
    public int checkTeamFatigue(ArrayList<Solider> team) {

        int count = 0;
        for (Solider solider: team) {
            if (solider.isFatigue()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Снимаем усталось с команды.
     * @param team команда.
     */
    public void removeTeamFatigue(ArrayList<Solider> team) {
        for (Solider solider: team) {
            solider.setFatigue(false);
        }
    }

    /**
     * Счетчик ходов. Нет в условии.
     */
    private int count = 0;

    /**
     * Бой.
     * @param team1 команда ходящая первой.
     * @param team2 команда ходящая второй.
     */
    public void fight(ArrayList<Solider> team1, ArrayList<Solider> team2) {

        while (true) {
            if (team1.size() == 0 || team2.size() == 0) {
                break;
            }
            if (team1.size() > 0 & team2.size() > 0) {
                action(team1, team2);
            }

            if (team1.size() > 0 & team2.size() > 0) {
                action(team2, team1);
            }

            if (checkTeamFatigue(team1) == team1.size()) {
                removeTeamFatigue(team1);
            }
            if (checkTeamFatigue(team2) == team2.size()) {
                removeTeamFatigue(team2);
            }
            count++;
        }

        if ((team1.size() > 0 && team2.size() == 0)) {
            System.out.println("Конец боя за " + count + " ходов. Победил " + team1);
        } else if (team1.size() == 0 && team2.size() > 0) {
            System.out.println("Конец боя за " + count + " ходов. Победил " + team2);
        }
    }

    /**
     * События в бою.
     * @param teamAttack  Атакующая команда (активная команда, чей ход)
     * @param teamDefence Защищающаяся команда.
     */
    public void action(ArrayList<Solider> teamAttack, ArrayList<Solider> teamDefence) {
        // активный солдат, солдат который делает действие.
        int actionSoliderNumber;
        // выбор случайного солдата без усталости.
        if (teamAttack.size() != checkTeamFatigue(teamAttack)) {
            actionSoliderNumber = random(teamAttack.size() - checkTeamFatigue(teamAttack));
        } else {
            removeTeamFatigue(teamAttack);
            actionSoliderNumber = random(teamAttack.size());
        }
        // цель враг.
        int enemySoliderNumber = random(teamDefence.size());
        // солдат без усталости - маг или остальные.
        if (!teamAttack.get(actionSoliderNumber).isFatigue()) {
            if (teamAttack.get(actionSoliderNumber) instanceof Wizard) {
                int allySoliderNumber = random(teamAttack.size());
                teamAttack.get(actionSoliderNumber).chooseAction(teamDefence.get(enemySoliderNumber), teamAttack.get(allySoliderNumber));
            } else {
                teamAttack.get(actionSoliderNumber).chooseAction(teamDefence.get(enemySoliderNumber));
            }
            // солдат устал.
            teamAttack.get(actionSoliderNumber).setFatigue(true);
            // перемещаем солдата в конец списка.
            Solider temp = teamAttack.get(actionSoliderNumber);
            teamAttack.remove(actionSoliderNumber);
            teamAttack.add(teamAttack.size(), temp);
            // проверяем смерть врага.
            if (teamDefence.get(enemySoliderNumber).getHealth() <= 0) {
                System.out.println(teamDefence.get(enemySoliderNumber).toString() + " Умер!");
                teamDefence.remove(teamDefence.get(enemySoliderNumber));
            }

        } else {
            return;
        }
    }
}
