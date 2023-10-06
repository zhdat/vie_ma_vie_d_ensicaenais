package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void softSkillTest() {
        Player player = new Player("test", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.RED);
        assertEquals(2, 1 * player.softSkillEffect());
        assertEquals(8, 4 * player.softSkillEffect());
        Player player1 = new Player("test", SoftSkill.DILETTANTE, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.RED);
        assertEquals(3, Math.ceil (6 * player1.softSkillEffect()));
        assertEquals(1, Math.ceil (1 * player1.softSkillEffect()));
    }

    @Test
    void movementTest(){
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
}
