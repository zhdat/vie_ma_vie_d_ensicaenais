package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.FinancialManagement;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class FinancialManagementTest {
    private Player player;
    private FinancialManagement financialManagementTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.HARDWORKING, FormerStudies.AST, Major.MATERIALS, Color.GREEN);
        financialManagementTile = new FinancialManagement(15);
    }

    @Test
    public void testApplyTileEffect() {
        financialManagementTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(15, financialManagementTile.getPosition());
    }
}
