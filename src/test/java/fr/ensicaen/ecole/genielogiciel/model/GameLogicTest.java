package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Exams;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    private GameLogic _gameLogic;
    private Exams _examsTile1;
    private Exams _examsTile2;

    @BeforeEach
    public void setUp() {
        _gameLogic = new GameLogic();
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4"};
        String[] originPlayers = {"prepa", "ast", "prepa", "ast"};
        String[] majorPlayers = {"Informatique", "MC", "Informatique", "MC"};
        Color[] colorPlayers = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        _gameLogic.createPlayers(playerNames, originPlayers, majorPlayers, colorPlayers);

    }

    @Test
    public void testStartGame() {
        _gameLogic.startGame();
        assertEquals(1, _gameLogic.getTurn());
    }

    @Test
    public void testCreatePlayers() {
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4"};
        String[] originPlayers = {"prepa", "ast", "prepa", "ast"};
        String[] majorPlayers = {"Informatique", "MC", "Informatique", "MC"};
        Color[] colorPlayers = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        _gameLogic.createPlayers(playerNames, originPlayers, majorPlayers, colorPlayers);

        assertEquals(4, _gameLogic.getPlayers().length);

        assertEquals("Player1", _gameLogic.getPlayers()[0].getName());
        assertEquals(FormerStudies.PREPA, _gameLogic.getPlayers()[0].getFormerStudies());
        assertEquals(Major.COMPUTER_SCIENCE, _gameLogic.getPlayers()[0].getMajor());
        assertEquals(Color.RED, _gameLogic.getPlayers()[0].getColor());

        assertEquals("Player2", _gameLogic.getPlayers()[1].getName());
        assertEquals(FormerStudies.AST, _gameLogic.getPlayers()[1].getFormerStudies());
        assertEquals(Major.MATERIALS, _gameLogic.getPlayers()[1].getMajor());
        assertEquals(Color.BLUE, _gameLogic.getPlayers()[1].getColor());

    }

    @Test
    public void testPlayTurn() {
        _gameLogic.startGame();
        _gameLogic.createPlayers(new String[]{"Player1", "Player2", "Player3", "Player4"}, new String[]{"prepa", "prepa", "ast", "ast"}, new String[]{"Informatique", "Informatique", "electronique", "mc"}, new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW});
        _gameLogic.getPlayers()[0].setRandomSoftSkill();
        _gameLogic.getPlayers()[1].setRandomSoftSkill();
        _gameLogic.getPlayers()[2].setRandomSoftSkill();
        _gameLogic.getPlayers()[3].setRandomSoftSkill();

        int initialPosition = _gameLogic.getPlayers()[0].getPosition();

        _gameLogic.playTurn(0);

        assertNotEquals(initialPosition, _gameLogic.getPlayers()[0].getPosition());

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
    @Test
    public void testHoverExam() {
        Model mock = new Model(new GameLogic());
        _gameLogic.createPlayers(new String[]{"Player1", "Player2", "Player3", "Player4"},
                new String[]{"prepa", "prepa", "ast", "ast"},
                new String[]{"Informatique", "Informatique", "electronique", "mc"},
                new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW});

        _gameLogic.getPlayers()[0].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[0].setPosition(20);
        _gameLogic.getPlayers()[0].increaseSkillLevel(3);
        _gameLogic.setDiceResult(2);
        _gameLogic.getPlayers()[0].goForward(2);
        _gameLogic.didPlayerHoverExam(0);
        assertTrue(_gameLogic.getPlayers()[0].getPosition() == 0);

        _gameLogic.getPlayers()[1].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[1].setPosition(20);
        _gameLogic.getPlayers()[1].increaseSkillLevel(5);
        _gameLogic.setDiceResult(4);
        _gameLogic.getPlayers()[1].goForward(4);
        _gameLogic.didPlayerHoverExam(1);
        assertTrue(_gameLogic.getPlayers()[1].getPosition() == 22);

        _gameLogic.getPlayers()[2].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[2].setPosition(40);
        _gameLogic.getPlayers()[2].increaseSkillLevel(3);
        _gameLogic.setDiceResult(2);
        _gameLogic.getPlayers()[2].goForward(2);
        _gameLogic.didPlayerHoverExam(2);
        assertTrue(_gameLogic.getPlayers()[2].getPosition() == 22);

        _gameLogic.getPlayers()[3].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[3].setPosition(40);
        _gameLogic.getPlayers()[3].increaseSkillLevel(9);
        _gameLogic.setDiceResult(4);
        _gameLogic.getPlayers()[3].goForward(4);
        _gameLogic.didPlayerHoverExam(3);
        assertTrue(_gameLogic.getPlayers()[3].getPosition() == 43);
    }

    @Test
    void testFinalExam() {
        Model mock = new Model(new GameLogic());
        _gameLogic.createPlayers(new String[]{"Player1", "Player2", "Player3", "Player4"},
                new String[]{"prepa", "prepa", "ast", "ast"},
                new String[]{"Informatique", "Informatique", "electronique", "mc"},
                new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW});

        _gameLogic.getPlayers()[0].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[0].setPosition(62);
        _gameLogic.getPlayers()[0].increaseSkillLevel(3);
        _gameLogic.setDiceResult(2);
        _gameLogic.getPlayers()[0].goForward(2);
        _gameLogic.applyFinalExamEffect(0);
        assertTrue(_gameLogic.getPlayers()[0].getPosition() == 43);

        _gameLogic.getPlayers()[1].setSoftSkill(SoftSkill.HARDWORKING);
        _gameLogic.getPlayers()[1].setPosition(62);
        _gameLogic.getPlayers()[1].increaseSkillLevel(13);
        _gameLogic.setDiceResult(2);
        _gameLogic.getPlayers()[1].goForward(2);
        _gameLogic.applyFinalExamEffect(1);
        assertTrue(_gameLogic.getPlayers()[1].getPosition() == 64);
    }
}
