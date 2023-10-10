package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.Waves;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class WavesTest {
    private Player player;
    private Waves wavesTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Bob", SoftSkill.HARDWORKING, FormerStudies.AST, Major.ELECTRONICS, Color.BLUE);
        wavesTile = new Waves(8);
    }

    @Test
    public void testApplyTileEffectMajorElectronics() {
        int initialSkillLevel = player.getSkillLevel();
        wavesTile.applyTileEffect(player);
        assertEquals(initialSkillLevel + 1, player.getSkillLevel());
    }

    @Test
    public void testApplyTileEffectOtherMajor() {
        player.setMajor(Major.MATERIALS);
        int initialSkillLevel = player.getSkillLevel();
        wavesTile.applyTileEffect(player);
        assertEquals(initialSkillLevel, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(8, wavesTile.getPosition());
    }
}
