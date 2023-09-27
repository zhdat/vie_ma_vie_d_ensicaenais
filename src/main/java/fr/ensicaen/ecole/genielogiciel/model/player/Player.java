package fr.ensicaen.ecole.genielogiciel.model.player;


import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public interface Player {
    int getPosition();
    String getName();
    Softskills getSoftskills();
    Origin getOrigin();
    int getLevel();
    Player getType();
}
