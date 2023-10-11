package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.GameLogic;
import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    public void setUp() {
        gameLogic = new GameLogic();
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4"};
        String[] originPlayers = {"prepa", "ast", "prepa", "ast"};
        String[] majorPlayers = {"Informatique", "MC", "Informatique", "MC"};
        Color[] colorPlayers = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        gameLogic.createPlayers(playerNames, originPlayers, majorPlayers, colorPlayers);

    }

    @Test
    public void testStartGame() {
        gameLogic.startGame();
        assertEquals(1, gameLogic.getTurn());
    }

    @Test
    public void testCreatePlayers() {
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4"};
        String[] originPlayers = {"prepa", "ast", "prepa", "ast"};
        String[] majorPlayers = {"Informatique", "MC", "Informatique", "MC"};
        Color[] colorPlayers = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        gameLogic.createPlayers(playerNames, originPlayers, majorPlayers, colorPlayers);

        assertEquals(4, gameLogic.getPlayers().length);

        assertEquals("Player1", gameLogic.getPlayers()[0].getName());
        assertEquals(FormerStudies.PREPA, gameLogic.getPlayers()[0].getFormerStudies());
        assertEquals(Major.COMPUTER_SCIENCE, gameLogic.getPlayers()[0].getMajor());
        assertEquals(Color.RED, gameLogic.getPlayers()[0].getColor());

        assertEquals("Player2", gameLogic.getPlayers()[1].getName());
        assertEquals(FormerStudies.AST, gameLogic.getPlayers()[1].getFormerStudies());
        assertEquals(Major.MATERIALS, gameLogic.getPlayers()[1].getMajor());
        assertEquals(Color.BLUE, gameLogic.getPlayers()[1].getColor());

    }

    @Test
    public void testPlayTurn() {
        gameLogic.startGame();
        gameLogic.createPlayers(new String[]{"Player1", "Player2", "Player3", "Player4"}, new String[]{"prepa", "prepa", "ast", "ast"}, new String[]{"Informatique", "Informatique", "electronique", "mc"}, new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW});
        gameLogic.getPlayers()[0].setRandomSoftSkill();
        gameLogic.getPlayers()[1].setRandomSoftSkill();
        gameLogic.getPlayers()[2].setRandomSoftSkill();
        gameLogic.getPlayers()[3].setRandomSoftSkill();

        int initialPosition = gameLogic.getPlayers()[0].getPosition();

        gameLogic.playTurn(0);

        assertNotEquals(initialPosition, gameLogic.getPlayers()[0].getPosition());

    }

    @Test
    public void testMajorFormerStudies() {
        String[] originPlayers = {"prepa", "ast", "prepa", "ast"};
        String[] majorPlayers = {"Informatique", "MC", "Informatique", "MC"};

        FormerStudies[] formerStudies = new FormerStudies[4];
        Major[] majors = new Major[4];

        GameLogic.majorFormerStudies(originPlayers, majorPlayers, 4, formerStudies, majors);

        assertEquals(FormerStudies.PREPA, formerStudies[0]);
        assertEquals(FormerStudies.AST, formerStudies[1]);
        assertEquals(FormerStudies.PREPA, formerStudies[2]);
        assertEquals(FormerStudies.AST, formerStudies[3]);

        assertEquals(Major.COMPUTER_SCIENCE, majors[0]);
        assertEquals(Major.MATERIALS, majors[1]);
        assertEquals(Major.COMPUTER_SCIENCE, majors[2]);
        assertEquals(Major.MATERIALS, majors[3]);
    }

}
