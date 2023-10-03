package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import fr.ensicaen.ecole.genielogiciel.model.tile.*;

public class Model {
    private String _nickname;
    private final Player[] _players;
    private final Board _board;
    private final Tile[] _tiles;
    private int _turn;
    private final int _nbCases = 63;

    public Model() {
        _tiles = new Tile[_nbCases];
        _tiles[0] = new Rentree(0);
        _tiles[1] = new English(1);
        _tiles[2] = new English(2);
        _tiles[3] = new IWE(3);
        _tiles[4] = new Cplusplus(4);
        _tiles[5] = new LVTwo(5);
        _tiles[6] = new Revision(6);
        _tiles[7] = new Cryptography(7);
        _tiles[8] = new Party(8);
        _tiles[9] = new RecruitmentCourse(9);
        _tiles[10] = new DataBase(10);
        _tiles[11] = new BurnOut(11);

        _board = new Board(_tiles);
        _players = new Player[4];
        Player player1 = new Player("Calliste", null, Origin.AST, Sector.INFORMATIQUE);
        Player player2 = new Player("Clément", null, Origin.PREPA, Sector.INFORMATIQUE);
        Player player3 = new Player("Maxime", null, Origin.PREPA, Sector.INFORMATIQUE);
        Player player4 = new Player("Blaise", null, Origin.PREPA, Sector.INFORMATIQUE);
        _players[0] = player1;
        _players[1] = player2;
        _players[2] = player3;
        _players[3] = player4;
    }

    public void startGame() {
        for (Player player : _players) {
            player.randomSoftskill();
        }
        _turn = 1;
    }

    public int playTurn(int playerIndex, int dice) {
        System.out.println(_players[playerIndex].getName());
        int initialPosition = _players[playerIndex].getPosition();
        System.out.println("Initial Position : " + initialPosition);
        int i = 1;
        while (i <= ((int)(dice * _players[playerIndex].softskill())) && (_players[playerIndex].getPosition() + 1 < _nbCases)){
            _players[playerIndex].goForward(1);
            i++;
        }
        if (_players[playerIndex].getPosition() == _nbCases && (i == dice * _players[playerIndex].softskill())) {
            System.out.println(_players[playerIndex].getName() + " Win !!!");
        } else if (i != (dice * _players[playerIndex].softskill())) {
            _players[playerIndex].goBackward((int)(dice * _players[playerIndex].softskill()) - i);
        }
        /*_tiles[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/
        System.out.println(_players[playerIndex].getPosition());
        return _players[playerIndex].getPosition();
    }

    public String getNickname() {
        return _nickname;
    }

    public void setNickname(String nickname) {
        _nickname = nickname;
    }

    public Player[] getPlayers() {
        return _players;
    }

    public Board getBoard() {
        return _board;
    }

    public Tile[] getCases() {
        return _tiles;
    }

    public int getTurn() {
        return _turn;
    }

}
