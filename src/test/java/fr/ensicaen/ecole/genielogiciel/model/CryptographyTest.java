package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Cryptography;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CryptographyTest {
    private Player player;
    private Cryptography cryptographyTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Eve", SoftSkill.HARDWORKING, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.BLUE);
        cryptographyTile = new Cryptography(10);
    }

    @Test
    public void testApplyTileEffect() {
        cryptographyTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());

        player = new Player("Frank", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.MATERIALS, Color.PURPLE);
        cryptographyTile = new Cryptography(15);

        cryptographyTile.applyTileEffect(player);
        assertEquals(0, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(10, cryptographyTile.getPosition());
    }
}
