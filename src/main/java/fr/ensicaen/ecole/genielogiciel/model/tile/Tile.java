package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public abstract class Tile {
    private int _position;
    public Tile(int position){
        _position = position;
    }
    public abstract void appliquerEffet(Player player);
    public int getPosition(){
        return _position;
    }
}
