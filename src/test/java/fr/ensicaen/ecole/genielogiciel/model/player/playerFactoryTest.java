package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.BachelorOrigin;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Assidu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class playerFactoryTest {
    @Test
    void createPlayerTest() {
        Player p1;
        try {
            p1 = playerFactory.createPlayer("oui", "Info", "BachelorOrigin", "Assidu");
        } catch (Exception e) {
            throw new RuntimeException("Error while creating the player\n");
        }
        assertTrue(p1.getOrigin() instanceof BachelorOrigin);
        assertTrue(p1.getSoftskills() instanceof Assidu);
    }
}
