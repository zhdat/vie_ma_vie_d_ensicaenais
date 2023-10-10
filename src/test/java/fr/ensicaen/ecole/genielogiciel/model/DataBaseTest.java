package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.DataBase;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DataBaseTest {
    private Player player;
    private DataBase dataBaseTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.HARDWORKING, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.GREEN);
        dataBaseTile = new DataBase(20);
    }

    @Test
    public void testApplyTileEffect() {
        dataBaseTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());

        player = new Player("Bob", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.MATERIALS, Color.RED);
        dataBaseTile = new DataBase(25);

        dataBaseTile.applyTileEffect(player);
        assertEquals(0, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(20, dataBaseTile.getPosition());
    }
}
