package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Thermodynamics;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ThermodynamicsTest {
    private Player player;
    private Thermodynamics thermodynamicsTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.BRILLIANT, FormerStudies.PREPA, Major.MATERIALS, Color.RED);
        thermodynamicsTile = new Thermodynamics(5);
    }

    @Test
    public void testApplyTileEffectMajorMaterials() {
        int initialSkillLevel = player.getSkillLevel();
        thermodynamicsTile.applyTileEffect(player);
        assertEquals(initialSkillLevel + 1, player.getSkillLevel());
    }

    @Test
    public void testApplyTileEffectOtherMajor() {
        player.setMajor(Major.ELECTRONICS);
        int initialSkillLevel = player.getSkillLevel();
        thermodynamicsTile.applyTileEffect(player);
        assertEquals(initialSkillLevel, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(5, thermodynamicsTile.getPosition());
    }
}
