package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.SoftSkill;
import fr.ensicaen.ecole.genielogiciel.model.tile.RecruitmentCourse;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RecruitmentCourseTest {
    private Player player;
    private RecruitmentCourse recruitmentCourseTile;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", SoftSkill.BRILLIANT, FormerStudies.AST, Major.COMPUTER_SCIENCE, Color.RED);
        recruitmentCourseTile = new RecruitmentCourse(20);
    }

    @Test
    public void testApplyTileEffect() {
        recruitmentCourseTile.applyTileEffect(player);
        assertEquals(1, player.getSkillLevel());
    }

    @Test
    public void testGetPosition() {
        assertEquals(20, recruitmentCourseTile.getPosition());
    }
}
