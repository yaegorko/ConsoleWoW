package ru.war.start;

import ru.war.bodiesaliance.elf.ElfArcher;
import ru.war.bodiesaliance.elf.ElfWarrior;
import ru.war.bodiesaliance.elf.ElfWizard;
import ru.war.bodiesaliance.human.HumanArcher;
import ru.war.bodiesaliance.human.HumanWarrior;
import ru.war.bodiesaliance.human.HumanWizard;
import ru.war.bodieshorde.orc.OrcArcher;
import ru.war.bodieshorde.orc.OrcWarrior;
import ru.war.bodieshorde.orc.OrcWizard;
import ru.war.bodieshorde.undead.UndeadArcher;
import ru.war.bodieshorde.undead.UndeadWarrior;
import ru.war.bodieshorde.undead.UndeadWizard;
import ru.war.exceptions.WrongRandomException;
import ru.war.warclases.Solider;
import ru.war.warclases.Wizard;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Arrays.asList;

public class GenerateFights {

    private ArrayList<Solider> teamAlliance;
    private ArrayList<Solider> teamHorde;

    public ArrayList<Solider> getTeamAlliance() {
        return teamAlliance;
    }

    public ArrayList<Solider> getTeamHorde() {
        return teamHorde;
    }

    public int random(int number) {
        Random random = new Random();
        int num = random.nextInt(number);
        return num;
    }

    private void generateTeams(){
        int teamAllianceGenerate = random(2);
        int teamHordeGenerate = random(2);
        if (teamAllianceGenerate == 0) {
            this.teamAlliance = new ArrayList<>(asList(new ElfWizard(),
                                               new ElfArcher(), new ElfArcher(), new ElfArcher(),
                                               new ElfWarrior(), new ElfWarrior(), new ElfWarrior(), new ElfWarrior()));
        } else if (teamAllianceGenerate == 1){
            this.teamAlliance = new ArrayList<>(asList(new HumanWizard(),
                                               new HumanArcher(), new HumanArcher(), new HumanArcher(),
                                               new HumanWarrior(), new HumanWarrior(), new HumanWarrior(), new HumanWarrior()));
        } else {
            throw new WrongRandomException();
        }

        if (teamHordeGenerate == 0) {
            this.teamHorde = new ArrayList<>(asList(new OrcWizard(),
                                            new OrcArcher(), new OrcArcher(), new OrcArcher(),
                                            new OrcWarrior(), new OrcWarrior(), new OrcWarrior(), new OrcWarrior()));
        } else if (teamHordeGenerate == 1) {
            this.teamHorde = new ArrayList<>(asList(new UndeadWizard(),
                                            new UndeadArcher(), new UndeadArcher(), new UndeadArcher(),
                                            new UndeadWarrior(), new UndeadWarrior(), new UndeadWarrior(), new UndeadWarrior()));
        } else {
            throw new WrongRandomException();
        }
    }

    public void startFight() {
        generateTeams();
        int whoStart = random(2);
        if (whoStart == 1) {
            fight(getTeamAlliance(), getTeamHorde());
        } else if (whoStart == 0){
            fight(getTeamHorde(), getTeamAlliance());
        } else {
            throw new WrongRandomException();
        }
    }

    public int checkTeamFatigue(ArrayList<Solider> team) {

        int count = 0;
        for (Solider solider: team) {
            if (solider.isFatigue()) {
                count++;
            }
        }
        return count;
    }

    public void removeTeamFatigue(ArrayList<Solider> team) {
        for (Solider solider: team) {
            solider.setFatigue(false);
        }
    }
    int count = 0;
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

    public void action(ArrayList<Solider> teamAttack, ArrayList<Solider> teamDefence) {

        int actionSoliderNumber;

        if (teamAttack.size() != checkTeamFatigue(teamAttack)) {
            actionSoliderNumber = random(teamAttack.size() - checkTeamFatigue(teamAttack));
        } else {
            removeTeamFatigue(teamAttack);
            actionSoliderNumber = random(teamAttack.size());
        }

        int allySoliderNumber = random(teamAttack.size());
        int enemySoliderNumber = random(teamDefence.size());

        if (!teamAttack.get(actionSoliderNumber).isFatigue()) {
            if (teamAttack.get(actionSoliderNumber) instanceof Wizard) {
                teamAttack.get(actionSoliderNumber).chooseAction(teamDefence.get(enemySoliderNumber), teamAttack.get(allySoliderNumber));
            } else {
                teamAttack.get(actionSoliderNumber).chooseAction(teamDefence.get(enemySoliderNumber));
            }
            teamAttack.get(actionSoliderNumber).setFatigue(true);
            Solider temp = teamAttack.get(actionSoliderNumber);
            teamAttack.remove(actionSoliderNumber);
            teamAttack.add(teamAttack.size(), temp);

            if (teamDefence.get(enemySoliderNumber).getHealth() <= 0) {
                System.out.println(teamDefence.get(enemySoliderNumber).toString() + " Умер!");
                teamDefence.remove(teamDefence.get(enemySoliderNumber));
            }

        } else {
            return;
        }
    }
}
