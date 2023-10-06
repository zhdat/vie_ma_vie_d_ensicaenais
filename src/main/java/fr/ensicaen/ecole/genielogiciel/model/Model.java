package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.tile.*;
import fr.ensicaen.ecole.genielogiciel.view.Observer;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observable {
    private String _nickname;
    private final Player[] _players;
    private Origin[] _origins;
    private Sector[] _majors;
    private final Board _board;
    private final Tile[] _tiles;
    private int _turn;
    private final int _nbCases = 65;
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
        _origins = new Origin[_nbPlayer];
        _majors = new Sector[_nbPlayer];
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
        int i = 0;
        while (i < (int) (Math.ceil(_diceResult * _players[playerIndex].softskill())) && (_players[playerIndex].getPosition() + 1 <= _nbCases - 1)) {
            _players[playerIndex].goForward(1);
            i++;
        }
        if (_players[playerIndex].getPosition() == _nbCases - 1 && (i == (int) Math.ceil(_diceResult * _players[playerIndex].softskill()))) {
            _players[playerIndex].setFinsh();

        } else if (i != (int) (Math.ceil(_diceResult * _players[playerIndex].softskill()))) {
            _players[playerIndex].goBackward((int) Math.ceil(_diceResult * _players[playerIndex].softskill()) - i);
        }
        for (int j = 0; j < _nbPlayer; j++) {
            if (playerIndex != j){
                if (_players[playerIndex].getPosition() == _players[j].getPosition() && !(_players[j].getFinish())) {
                    _players[j].setPosition(initialPosition);
                }
            }
        }
        /*_tiles[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/
        notifyObservers();
    }

    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer) {
        for (int i = 0; i < _nbPlayer; i++) {
            if (originPlayer[i].equalsIgnoreCase("prepa")) {
                _origins[i] = Origin.PREPA;
            }
            if (originPlayer[i].equalsIgnoreCase("ast")) {
                _origins[i] = Origin.AST;
            }
            if (majorPlayer[i].equalsIgnoreCase("Informatique")) {
                _majors[i] = Sector.INFORMATIQUE;
            }
            if (majorPlayer[i].equalsIgnoreCase("MC")) {
                _majors[i] = Sector.MATERIAUX;
            }
            if (majorPlayer[i].equalsIgnoreCase("Electronique")) {
                _majors[i] = Sector.ELECTRONIQUE;
            }
        }

        for (int i = 0; i < _nbPlayer; i++) {
            _players[i] = new Player(playerName[i], null, _origins[i], _majors[i], colorPlayer[i]);
        }

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

    public int getNbPlayer() {
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
        for (Observer o : _observers) {
            o.update(this);
        }
    }

}
