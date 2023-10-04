package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.tile.*;
import fr.ensicaen.ecole.genielogiciel.view.Observer;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observable{
    private String _nickname;
    private final Player[] _players;
    private final Board _board;
    private final Tile[] _tiles;
    private int _turn;
    private final int _nbCases = 63;
    private List<Observer> _observers;
    private final int _nbPlayer = 4;
    private Dice _dice;
    private int _diceResult;

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
        _players = new Player[_nbPlayer];
        Player player1 = new Player("Calliste", null, Origin.AST, Sector.INFORMATIQUE);
        Player player2 = new Player("Clément", null, Origin.PREPA, Sector.INFORMATIQUE);
        Player player3 = new Player("Maxime", null, Origin.PREPA, Sector.INFORMATIQUE);
        Player player4 = new Player("Blaise", null, Origin.PREPA, Sector.INFORMATIQUE);
        _players[0] = player1;
        _players[1] = player2;
        _players[2] = player3;
        _players[3] = player4;

        _observers = new ArrayList<>();

        _dice = new Dice();
    }

    public void startGame() {
        for (Player player : _players) {
            player.randomSoftskill();
        }
        _turn = 1;
    }

    public void playTurn(int playerIndex) {
        System.out.println(_players[playerIndex].getName());
        _diceResult = _dice.roll();
        play(playerIndex);
    }

    private void play(int playerIndex) {
        int initialPosition = _players[playerIndex].getPosition();
        System.out.println("Initial Position : " + initialPosition);
        System.out.println("Résultat dé : " + (int)(Math.ceil(_diceResult * _players[playerIndex].softskill())));
        int i = 0;
        while (i < (int)(Math.ceil(_diceResult * _players[playerIndex].softskill())) && (_players[playerIndex].getPosition() + 1 <= _nbCases)){
            _players[playerIndex].goForward(1);
            notifyObservers();
            i++;
        }
        if (_players[playerIndex].getPosition() == _nbCases && (i == (int)Math.ceil(_diceResult * _players[playerIndex].softskill()) - 1)) {
            System.out.println(_players[playerIndex].getName() + " Win !!!");
        } else if (i != (int)(Math.ceil(_diceResult * _players[playerIndex].softskill()))) {
            _players[playerIndex].goBackward((int)Math.ceil(_diceResult * _players[playerIndex].softskill()) - i);
            notifyObservers();
        }
        /*_tiles[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/
        System.out.println(_players[playerIndex].getPosition());
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

    public int getNbPlayer(){
        return _nbPlayer;
    }
    public int getDiceResult() {
        return _diceResult;
    }

    @Override
    public void addObserver(Observer O) {
        _observers.add(O);
    }

    @Override
    public void removeObserver(Observer O) {
        _observers.remove(O);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : _observers){
            o.update(this);
        }
    }
}
