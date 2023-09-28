package fr.ensicaen.ecole.genielogiciel.model.game;

import fr.ensicaen.ecole.genielogiciel.model.Dice;
import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Elec;
import fr.ensicaen.ecole.genielogiciel.model.player.Info;
import fr.ensicaen.ecole.genielogiciel.model.player.Mc;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Assidu;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Brillant;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Dilétante;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public class Game {
    public static Player createPlayer(String name, Softskills softskills, Origin origin, String type){
        return switch (type) {
            case "Elec" -> new Elec(name, softskills, origin);
            case "Mc" -> new Mc(name, softskills, origin);
            case "Info" -> new Info(name, softskills, origin);
            default -> null;
        };
    }
    public static Softskills createSoftskills(String type){
        return switch (type) {
            case "Assidus" -> new Assidu();
            case "Dilettante" -> new Dilétante();
            case "Brillant" -> new Brillant();
            default -> null;
        };
    }
    public static Dice createDice(){
        return new Dice();
    }
    public static void main(String[] args) {
        int nbTurns = 10;
        int nbDies = 1;
        int i = 0;
        Player player1 = createPlayer("toto1", createSoftskills("Assidus"), null, "Elec");
        Player player2 = createPlayer("toto2", createSoftskills("Dilettante"), null, "Mc");
        Player player3 = createPlayer("toto3", createSoftskills("Brillant"), null, "Info");
        Player player4 = createPlayer("toto4", null, null, "Elec");
        Dice dice = createDice();
        while (i < nbTurns){
            int diceValue = dice.roll(nbDies);
            player1.goForward(diceValue);
            System.out.println("Tour " + i);
            System.out.println("Position joueur 1 " + player1.getPosition());

            diceValue = dice.roll(nbDies);
            player2.goForward(diceValue);
            System.out.println("Position joueur 2 " + player2.getPosition());

            diceValue = dice.roll(nbDies);
            player3.goForward(diceValue);
            System.out.println("Position joueur 3 " + player3.getPosition());

            diceValue = dice.roll(nbDies);
            player4.goForward(diceValue);
            System.out.println("Position joueur 4 " + player4.getPosition());

            i++;
        }
    }
}
