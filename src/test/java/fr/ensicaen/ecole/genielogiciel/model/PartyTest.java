package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Party;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PartyTest {
    private Player player;
    private Party partyTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Bob", SoftSkill.HARDWORKING, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.BLUE);
        partyTile = new Party(10);
        player.setSkillLevel(20);
    }

    @Test
    public void testApplyTileEffect() {
        partyTile.applyTileEffect(player);
        assertEquals(19, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(10, partyTile.getPosition());
    }
}
