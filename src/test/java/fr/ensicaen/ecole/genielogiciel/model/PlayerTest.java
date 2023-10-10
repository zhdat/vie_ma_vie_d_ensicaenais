package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {
    private Player player;
    @BeforeEach
    public void setUp() {
        System.out.println("Fonction setup");
        player = new Player("John", SoftSkill.HARDWORKING, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.BLUE);
    }
    @Test
    public void softSkillTest() {
        Player player = new Player("test", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.RED);
        assertEquals(2, 1 * player.softSkillEffect());
        assertEquals(8, 4 * player.softSkillEffect());
        Player player1 = new Player("test", SoftSkill.DILETTANTE, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.RED);
        assertEquals(3, Math.ceil (6 * player1.softSkillEffect()));
        assertEquals(1, Math.ceil (1 * player1.softSkillEffect()));
    }

    @Test
    public void movementTest(){
        Player player = new Player("test", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.BLUE);
        Player player1 = new Player("test", SoftSkill.DILETTANTE, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.ALICEBLUE);

        assertEquals(0, player.getPosition());
        player.goForward(5);
        assertEquals(5, player.getPosition());
        player.goBackward(5);
        assertEquals(0, player.getPosition());

        player.goBackward(2);
        assertEquals(-2, player.getPosition());
        player1.goForward(65);
        assertEquals(65, player1.getPosition());
    }

    @Test
    public void testGoForward() {
        player.goForward(3);

        assertEquals(3, player.getPosition());
    }

    @Test
    public void testGoBackward() {
        player.goBackward(2);

        assertEquals(-2, player.getPosition());
    }

    @Test
    public void testSoftSkillEffect() {
        player.setSoftSkill(SoftSkill.HARDWORKING);
        assertEquals(1.0, player.softSkillEffect(), 0.01);

        player.setSoftSkill(SoftSkill.BRILLIANT);
        assertEquals(2.0, player.softSkillEffect(), 0.01);

        player.setSoftSkill(SoftSkill.DILETTANTE);
        assertEquals(0.5, player.softSkillEffect(), 0.01);
    }

    @Test
    public void testIncreaseSkillLevel() {
        player.increaseSkillLevel(5);

        assertEquals(5, player.getSkillLevel());
    }

    @Test
    public void testSetRandomSoftSkill() {
        player.setRandomSoftSkill();

        assertNotNull(player.getSoftSkill());
    }

}
