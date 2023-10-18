package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public abstract class Tile {
    private final int _position;
    public Tile(int position){
        _position = position;
    } // FIXME peugt etre mis en protected
    public abstract void applyTileEffect(Player player);
    public int getPosition(){
        return _position;
    }
}
