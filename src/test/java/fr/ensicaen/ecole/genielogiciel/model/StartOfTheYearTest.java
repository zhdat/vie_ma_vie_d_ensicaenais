package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.StartOfTheYear;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StartOfTheYearTest {
    private Player player;
    private StartOfTheYear startOfTheYearTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Bob", SoftSkill.HARDWORKING, FormerStudies.AST, Major.ELECTRONICS, Color.BLUE);
        startOfTheYearTile = new StartOfTheYear(7);
    }

    @Test
    public void testApplyTileEffect() {
        player.setPosition(3);
        startOfTheYearTile.applyTileEffect(player);
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testGetPosition() {
        assertEquals(7, startOfTheYearTile.getPosition());
    }
}
