package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.tile.English;
import fr.ensicaen.ecole.genielogiciel.model.tile.Tile;

public class Board {
    private int _boardSize;
    private Tile[] _board;

    public Board(int boardSize){
        _boardSize = boardSize;
        _board = new Tile[_boardSize];

        //We temporarily fill the board with only English classes
        for (int i = 0; i < _boardSize; i++) {
            _board[i] = new English(null);
        }
    }
}
