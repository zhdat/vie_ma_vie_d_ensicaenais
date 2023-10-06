package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;

import javafx.scene.paint.Color;
import jdk.jfr.StackTrace;

import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    @Test
    void should_get_nickname_when_set_nickname() {
        Model loginModel = new Model();
        final String testString = "Toto";
        loginModel.setNickname(testString);
        assertEquals(testString, loginModel.getNickname());
    }

    @Test
    void testCreatePlayer() {
        Model mock = new Model();
        mock.createPlayer(new String[]{"a", "b", "c", "d"},
                new String[] {"prepa", "ast", "ast", "prepa"},
                new String[]{"informatique", "mc", "electronique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 1, 0), new Color(1, 0, 0, 0), new Color(0, 1, 0, 0)});
        Player [] tab  = mock.getPlayers();
        Player player1 = tab[0];
        Player player2 = tab[1];
        assertEquals(player1.getName(), "a");
        assertEquals(player1.getFiliere(), Sector.INFORMATIQUE);
        assertEquals(player1.getProvenance(), Origin.PREPA);
        assertEquals(player2.getName(), "b");
        assertEquals(player2.getFiliere(), Sector.MATERIAUX);
        assertEquals(player2.getProvenance(), Origin.AST);
    }

    @Test
    void testStartGame() {
        Model mock = new Model();

        mock.createPlayer(new String[]{"a", "a", "a", "a"},
                new String[] {"prepa", "prepa", "prepa", "prepa"},
                new String[]{"informatique", "informatique", "informatique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)});
        mock.startGame();
        Player tab[] = mock.getPlayers();
        Softskill s = tab[1].getSoftskill();
        assertTrue(s == Softskill.ASSIDU || s == Softskill.BRILLANT || s == Softskill.DILETTANTE);
        return;
    }

    @Test
    void testPlayTurn() {
        Model mock = new Model();

        mock.createPlayer(new String[]{"a", "a", "a", "a"},
                new String[] {"prepa", "prepa", "prepa", "prepa"},
                new String[]{"informatique", "informatique", "informatique", "informatique"},
                new Color[]{new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)});
        mock.startGame();
        int oldPos = mock.getPlayers()[0].getPosition();
        mock.playTurn(0);
        int moves = mock.getPlayers()[0].getPosition() - oldPos;
        assertTrue(moves > 0 && moves < 13);

    }
}