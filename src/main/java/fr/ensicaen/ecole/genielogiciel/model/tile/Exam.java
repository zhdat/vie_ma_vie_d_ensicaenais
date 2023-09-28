package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public class Exam implements Tile{
    private Player _player;

    public Exam(Player _player) {
        this._player = _player;
    }
    public int getPlayerLevel(){
        return _player.getLevel();
    }

    public Origin getPlayerOrigin(){
        return _player.getOrigin();
    }

    public Softskills getPlayerSoftskills(){
        return _player.getSoftskills();
    }

    public Player getPlayerType(){
        return _player.getType();
    }
}
