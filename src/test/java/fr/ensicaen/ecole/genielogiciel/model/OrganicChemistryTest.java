package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.OrganicChemistry;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OrganicChemistryTest {
    private Player player;
    private OrganicChemistry chemistryTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.HARDWORKING, FormerStudies.PREPA, Major.MATERIALS, Color.RED);
        chemistryTile = new OrganicChemistry(40);
    }

    @Test
    public void testApplyTileEffectMaterials() {
        chemistryTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());
    }

    @Test
    public void testApplyTileEffectOtherStudies() {
        player.setMajor(Major.COMPUTER_SCIENCE);
        chemistryTile.applyTileEffect(player);
        assertEquals(0, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(40, chemistryTile.getPosition());
    }
}
