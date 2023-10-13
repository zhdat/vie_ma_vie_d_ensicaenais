package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.FinalExam;
import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    @Test
    void should_get_nickname_when_set_nickname() {
        GameLogic gameLogic = new GameLogic();
        Model loginModel = new Model(gameLogic);
        final String testString = "Toto";
        gameLogic.setNickname(testString);
        assertEquals(testString, gameLogic.getNickname());
    }


    @Test
    void testCreatePlayer() {
        GameLogic gameLogic = new GameLogic();
        Model mock = new Model(gameLogic);
        mock.createPlayer(new String[]{"a", "b", "c", "d"},
                new String[] {"prepa", "ast", "ast", "prepa"},
                new String[]{"informatique", "mc", "electronique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 1, 0), new Color(1, 0, 0, 0), new Color(0, 1, 0, 0)});
        Player [] tab  = gameLogic.getPlayers();
        Player player1 = tab[0];
        Player player2 = tab[1];
        assertEquals(player1.getName(), "a");
        assertEquals(player1.getMajor(), Major.COMPUTER_SCIENCE);
        assertEquals(player1.getFormerStudies(), FormerStudies.PREPA);
        assertEquals(player2.getName(), "b");
        assertEquals(player2.getMajor(), Major.MATERIALS);
        assertEquals(player2.getFormerStudies(), FormerStudies.AST);
    }

    @Test
    void testStartGame() {
        GameLogic gameLogic = new GameLogic();
        Model mock = new Model(gameLogic);

        mock.createPlayer(new String[]{"a", "a", "a", "a"},
                new String[] {"prepa", "prepa", "prepa", "prepa"},
                new String[]{"informatique", "informatique", "informatique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)});
        mock.startGame();
        Player tab[] = gameLogic.getPlayers();
        SoftSkill s = tab[1].getSoftSkill();
        assertTrue(s == SoftSkill.HARDWORKING || s == SoftSkill.BRILLIANT || s == SoftSkill.DILETTANTE);
        return;
    }

    @Test
    void testPlayTurn() {
        GameLogic gameLogic = new GameLogic();
        Model mock = new Model(gameLogic);

        mock.createPlayer(new String[]{"a", "a", "a", "a"},
                new String[] {"prepa", "prepa", "prepa", "prepa"},
                new String[]{"informatique", "informatique", "informatique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)});
        mock.startGame();
        int oldPos = gameLogic.getPlayers()[0].getPosition();
        mock.playTurn(0);
        int moves = gameLogic.getPlayers()[0].getPosition() - oldPos;
        assertTrue(moves > 0 && moves < 13);
    }
}