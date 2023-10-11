package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.ChemistryManipulation;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChemistryManipulationTest {
    private Player player;
    private ChemistryManipulation chemistryTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.MATERIALS, Color.RED);
        chemistryTile = new ChemistryManipulation(5);
        player.setSkillLevel(20);
    }

    @Test
    public void testApplyTileEffect() {
        chemistryTile.applyTileEffect(player);
        assertEquals(19, player.getSkillLevel());

        player = new Player("Bob", SoftSkill.BRILLIANT, FormerStudies.AST, Major.MATERIALS, Color.GREEN);
        chemistryTile = new ChemistryManipulation(10);
        player.setSkillLevel(20);

        chemistryTile.applyTileEffect(player);
        assertEquals(21, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(5, chemistryTile.getPosition());
    }
}
