package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public abstract class AbstractPlayer implements Player {
    int _position;
    String _name;
    Softskills _softskills;
    Origin _origin;
    int _level;
    Player _type;

}
