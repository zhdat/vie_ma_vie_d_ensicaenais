package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.IWE;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IWETest {
    private Player player;
    private IWE iweTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.HARDWORKING, FormerStudies.AST, Major.MATERIALS, Color.GREEN);
        iweTile = new IWE(4);
    }

    @Test
    public void testApplyTileEffect() {
        iweTile.applyTileEffect(player);
        SoftSkill randomSkill = player.getSoftSkill();
        assertTrue(randomSkill == SoftSkill.HARDWORKING || randomSkill == SoftSkill.BRILLIANT || randomSkill == SoftSkill.DILETTANTE);
    }

    @Test
    public void testGetPosition() {
        assertEquals(4, iweTile.getPosition());
    }
}
