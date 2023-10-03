package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void softSkillTest() {
        Player player = new Player("test", Softskill.BRILLANT, Origin.PREPA, Sector.INFORMATIQUE);
        assertEquals(2, 1 * player.softskill());
        assertEquals(8, 4 * player.softskill());
        Player player1 = new Player("test", Softskill.DILETTANTE, Origin.PREPA, Sector.INFORMATIQUE);
        assertEquals(3, (int) (6 * player1.softskill()));
        assertEquals(1, (int) (1 * player1.softskill()));
    }

    @Test
    void movementTest(){
        Player player = new Player("test", Softskill.BRILLANT, Origin.PREPA, Sector.INFORMATIQUE);
        Player player1 = new Player("test", Softskill.DILETTANTE, Origin.PREPA, Sector.INFORMATIQUE);

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
