package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.tile.Tile;

public abstract class Board {
    protected Tile[] _tiles;
    protected int _numberOfTiles;
    public int getNumberOfTiles() {
        return _numberOfTiles;
    }
}
