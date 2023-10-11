package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.SmartCard;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SmartCardTest {
    private Player player;
    private SmartCard smartCardTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Bob", SoftSkill.HARDWORKING, FormerStudies.AST, Major.ELECTRONICS, Color.BLUE);
        smartCardTile = new SmartCard(5);
        player.setSkillLevel(20);
    }

    @Test
    public void testApplyTileEffect() {
        smartCardTile.applyTileEffect(player);
        assertEquals(21, player.getSkillLevel());
    }

    @Test
    public void testApplyTileEffect_Prepa() {
        player = new Player("Alice", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.ELECTRONICS, Color.RED);
        player.setSkillLevel(20);
        smartCardTile.applyTileEffect(player);
        assertEquals(19, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(5, smartCardTile.getPosition());
    }
}
