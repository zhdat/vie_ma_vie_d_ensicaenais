package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Sensor;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SensorTest {
    private Player player;
    private Sensor sensorTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.BRILLIANT, FormerStudies.AST, Major.ELECTRONICS, Color.RED);
        sensorTile = new Sensor(2);
    }

    @Test
    public void testApplyTileEffect() {
        sensorTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(2, sensorTile.getPosition());
    }
}
