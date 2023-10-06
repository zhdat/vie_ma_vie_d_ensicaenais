package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import javafx.scene.paint.Color;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

    @Test
    void should_get_nickname_when_set_nickname() {
        Model loginModel = new Model();
        final String testString = "Toto";
        loginModel.setNickname(testString);
        assertEquals(testString, loginModel.getNickname());
    }
    @Test
    void have_competence_level_for_exams(){
        Player player = new Player("test", Softskill.BRILLANT, Origin.PREPA, Sector.INFORMATIQUE, Color.RED);
        player.setPosition(20); //TODO : Test l'ajout de la contrainte de compétence aux exams
        player.setCompetence(3);

    }
}