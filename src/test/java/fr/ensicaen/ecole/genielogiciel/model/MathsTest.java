package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Maths;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MathsTest {
    private Player player;
    private Maths mathsTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Bob", SoftSkill.BRILLIANT, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.BLUE);
        mathsTile = new Maths(12);
        player.setSkillLevel(20);
    }

    @Test
    public void testApplyTileEffectAST() {
        mathsTile.applyTileEffect(player);
        assertEquals(19, player.getSkillLevel());
    }

    @Test
    public void testApplyTileEffectOtherStudies() {
        player.setFormerStudies(FormerStudies.PREPA);
        mathsTile.applyTileEffect(player);
        assertEquals(21, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(12, mathsTile.getPosition());
    }
}
