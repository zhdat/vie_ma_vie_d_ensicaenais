package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import fr.ensicaen.ecole.genielogiciel.model.tile.*;

public class Model {
    private String _nickname;
    private Player[] _players;
    private Board _board;
    private Tile[] _tiles;
    private int _turn;
    private int _nbCases = 12;

    public Model() {
        _tiles = new Tile[_nbCases];
        _tiles[0] = new Rentrée(0);
        _tiles[1] = new Anglais(1);
        _tiles[2] = new Anglais(2);
        _tiles[3] = new WEI(3);
        _tiles[4] = new Cpp(4);
        _tiles[5] = new LV2(5);
        _tiles[6] = new Révision(6);
        _tiles[7] = new Crypto(7);
        _tiles[8] = new Soirées(8);
        _tiles[9] = new Recruitment(9);
        _tiles[10] = new BaseDeDonnée(10);
        _tiles[11] = new Burnout(11);

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
        if (_players[playerIndex].getSoftskill() == Softskill.ASSIDUS){
            _players[playerIndex].goForward(dice);
        } else if (_players[playerIndex].getSoftskill() == Softskill.BRILLANT) {
            _players[playerIndex].goForward(dice * 2);
        } else if (_players[playerIndex].getSoftskill() == Softskill.DILETTANTE) {
            _players[playerIndex].goForward(dice / 2);
        }
        System.out.println(_players[playerIndex].getName() + "-->" + _players[playerIndex].getPosition());
        if (_players[playerIndex].getPosition() >= _nbCases){
            System.out.println(_players[playerIndex].getName() + " Win !!!");
        }
        /*_tiles[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/ // @TODO : Résoudre pbm --> error: incompatible types: fr.ensicaen.ecole.genielogiciel.model.player.Player cannot be converted to fr.ensicaen.ecole.genielogiciel.model.Player
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
