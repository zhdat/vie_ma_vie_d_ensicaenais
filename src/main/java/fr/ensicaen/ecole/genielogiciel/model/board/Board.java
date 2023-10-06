package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.tile.Tile;

public abstract class Board {
    protected Tile[] _tiles;
    protected int _numberOfTiles;
    protected int[] _holidaysPositions;
    protected int[] _examsPositions;
    protected int[] _newYearsPositions;
    public Tile getTile(int position) {
        return _tiles[position];
    }

    public int[] getHolidaysPositions() {
        return _holidaysPositions;
    }

    public int[] getExamsPositions() {
        return _examsPositions;
    }

    public int[] get_newYearsPositions() {
        return _newYearsPositions;
    }

    public int getNumberOfTiles() {
        return _numberOfTiles;
    }
}
