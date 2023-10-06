package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.BurnOut;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BurnOutTest {
    private Player player;
    private BurnOut burnOutTile;

    @BeforeEach
    public void setUp() {
        player = new Player("John", SoftSkill.HARDWORKING, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.BLUE);
        burnOutTile = new BurnOut(10);
    }

    @Test
    public void testApplyTileEffect() {
        player.setPosition(5);
        burnOutTile.applyTileEffect(player);
        Assertions.assertEquals(0, player.getPosition());
    }

    @Test
    public void testGetPosition() {
        Assertions.assertEquals(10, burnOutTile.getPosition());
    }
}
