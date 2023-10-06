package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.LVTwo;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LVTwoTest {
    private Player player;
    private LVTwo lvTwoTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.HARDWORKING, FormerStudies.AST, Major.MATERIALS, Color.GREEN);
        lvTwoTile = new LVTwo(6);
    }

    @Test
    public void testApplyTileEffect() {
        lvTwoTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(6, lvTwoTile.getPosition());
    }
}
