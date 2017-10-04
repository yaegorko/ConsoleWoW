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

import java.util.Random;

public class GenerateFights {

    private Solider[] teamAlliance = new Solider[8];
    private Solider[] teamHorde = new Solider[8];

    public Solider[] getTeamAlliance() {
        return teamAlliance;
    }

    public Solider[] getTeamHorde() {
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
            this.teamAlliance = new Solider[] {new ElfWizard(),
                                               new ElfArcher(), new ElfArcher(), new ElfArcher(),
                                               new ElfWarrior(), new ElfWarrior(), new ElfWarrior(), new ElfWarrior()};
        } else if (teamAllianceGenerate == 1){
            this.teamAlliance = new Solider[] {new HumanWizard(),
                                               new HumanArcher(), new HumanArcher(), new HumanArcher(),
                                               new HumanWarrior(), new HumanWarrior(), new HumanWarrior(), new HumanWarrior()};
        } else {
            throw new WrongRandomException();
        }

        if (teamHordeGenerate == 0) {
            this.teamHorde = new Solider[] {new OrcWizard(),
                                            new OrcArcher(), new OrcArcher(), new OrcArcher(),
                                            new OrcWarrior(), new OrcWarrior(), new OrcWarrior(), new OrcWarrior()};
        } else if (teamHordeGenerate == 1) {
            this.teamHorde = new Solider[] {new UndeadWizard(),
                                            new UndeadArcher(), new UndeadArcher(), new UndeadArcher(),
                                            new UndeadWarrior(), new UndeadWarrior(), new UndeadWarrior(), new UndeadWarrior()};
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

    int number = 8;

    public void fight(Solider[] team1, Solider[] team2) {


        while (number >= 0) {
            action(team1, team2);
            action(team2, team1);
        }


        if (number == 0) {
            for (Solider solider : team1) {
                solider.setFatigue(false);
            }
            for (Solider solider : team2) {
                solider.setFatigue(false);
            }

            number = 8;
            fight(team1, team2);
        }
    }



    public void action(Solider[] teamAttack, Solider[] teamDefence) {
        int soliderNumber;
        int enemySoliderNumber = random(8);
        int allySoliderNumber = random(8);
        if (number > 0) {
            soliderNumber = random(number);
        } else soliderNumber = random(1);

        if (!teamAttack[soliderNumber].isFatigue()) {
            if (teamAttack[soliderNumber] instanceof Wizard) {
                teamAttack[soliderNumber].chooseAction(teamDefence[enemySoliderNumber], teamAttack[allySoliderNumber]);
            } else {
                teamAttack[soliderNumber].chooseAction(teamDefence[enemySoliderNumber]);
            }
            teamAttack[soliderNumber].setFatigue(true);
            if (soliderNumber != 7) {
                Solider temp = teamAttack[soliderNumber];
                for (int i = soliderNumber + 1; i < teamAttack.length; i++) {
                    teamAttack[i - 1] = teamAttack[i];
                }
                teamAttack[teamAttack.length - 1] = temp;
            }
        } else {
            number--;
        }
    }
}
