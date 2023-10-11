package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Cplusplus;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CplusplusTest {
    private Player player;
    private Cplusplus cplusplusTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Charlie", SoftSkill.HARDWORKING, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.YELLOW);
        cplusplusTile = new Cplusplus(7);
        player.setSkillLevel(20);
    }

    @Test
    public void testApplyTileEffect() {
        cplusplusTile.applyTileEffect(player);
        assertEquals(21, player.getSkillLevel());

        player = new Player("David", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.COMPUTER_SCIENCE, Color.ORANGE);
        cplusplusTile = new Cplusplus(12);
        player.setSkillLevel(20);

        cplusplusTile.applyTileEffect(player);
        assertEquals(19, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(7, cplusplusTile.getPosition());
    }
}
