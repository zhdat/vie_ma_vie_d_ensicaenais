package src.main.java.fr.ensicaen.ecole.genielogiciel.model.player;

import src.main.java.fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;
import src.main.java.fr.ensicaen.ecole.genielogiciel.model.origin.Origin;

public interface Player {
    int getPosition();
    String getName();
    Softskills getSoftskills();
    Origin getOrigin();
    int getLevel();
    Player getType();
}
