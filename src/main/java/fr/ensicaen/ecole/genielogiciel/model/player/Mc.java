package src.main.java.fr.ensicaen.ecole.genielogiciel.model.player;

import src.main.java.fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;
import src.main.java.fr.ensicaen.ecole.genielogiciel.model.origin.Origin;

public class Mc extends AbstractPlayer implements Player {
    public Mc(String name, Softskills softskills, Origin origin){
        _position = 0;
        _name = name;
        _softskills = softskills;
        _origin = origin;
        _level = 0;
        _type = this;
    }
    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Softskills getSoftskills() {
        return null;
    }

    @Override
    public Origin getOrigin() {
        return null;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public Player getType() {
        return this;
    }
}
