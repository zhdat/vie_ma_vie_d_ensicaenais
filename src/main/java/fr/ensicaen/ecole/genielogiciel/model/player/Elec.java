package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public class Elec extends AbstractPlayer implements Player {
    public Elec(String name, Softskills softskills, Origin origin) {
        _position = 0;
        _name = name;
        _softskills = softskills;
        _origin = origin;
        _level = 0;
        _type = this;
    }

    @Override
    public int getPosition() {
        return _position;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Softskills getSoftskills() {
        return _softskills;
    }

    @Override
    public Origin getOrigin() {
        return _origin;
    }

    @Override
    public int getLevel() {
        return _level;
    }

    @Override
    public Player getType() {
        return this;
    }

    @Override
    public int goForward(int diceValue) {
        _position += diceValue;
        return _position;
    }

    @Override
    public int teleportation(int position) {
        _position = position;
        return _position;
    }
}