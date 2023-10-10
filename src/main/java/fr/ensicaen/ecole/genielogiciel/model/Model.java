package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.board.ClassicBoard;
import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.Observer;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observable {
    private String _nickname;
    private final Player[] _players;
    private FormerStudies[] _formerStudies;
    private Major[] _majors;
    private final Board _board;
    private int _turn;
    private final List<Observer> _observers;
    private final int _nbPlayer = 4;
    private Dice _dice;
    private int _diceResult;

    public Model() {
        _board = new ClassicBoard();

        _players = new Player[_nbPlayer];
        _formerStudies = new FormerStudies[_nbPlayer];
        _majors = new Major[_nbPlayer];
        _observers = new ArrayList<>();
        _dice = new Dice();
    }

    public void startGame() {
        for (Player player : _players) {
            player.setRandomSoftSkill();
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

        int effectApplied = 0;
        while (i < (int) (Math.ceil(_diceResult * _players[playerIndex].softSkillEffect())) && (_players[playerIndex].getPosition() + 1 <= _board.getNumberOfTiles())) {
            _players[playerIndex].goForward(1);
            i++;
        }

        if (_players[playerIndex].getPosition() == (_board.getNumberOfTiles() - 1) && (i == (int) Math.ceil(_diceResult * _players[playerIndex].softSkillEffect()))) {
            applyFinalExamEffect(playerIndex);
            effectApplied = 1;
        } else if (i != (int) (Math.ceil(_diceResult * _players[playerIndex].softSkillEffect()))) {
            _players[playerIndex].goBackward((int) Math.ceil(_diceResult * _players[playerIndex].softSkillEffect()) - i);
        }
        for (int j = 0; j < _nbPlayer; j++) {
            if (playerIndex != j){
                if (_players[playerIndex].getPosition() == _players[j].getPosition() && !(_players[j].getFinish())) {
                    _players[j].setPosition(initialPosition);
                }
            }
        }

        if (didPlayerHoverExam(playerIndex) && effectApplied == 0){
            _board.getTile(_players[playerIndex].getPosition()).applyTileEffect(_players[playerIndex]);
        }
        System.out.println(_players[playerIndex].getPosition());
        notifyObservers();
        System.out.println("Compétence");
        System.out.println(_players[playerIndex].getSkillLevel());
    }

    public void applyFinalExamEffect(int playerIndex){
        _board.getTile(_board.getNumberOfTiles() - 1).applyTileEffect(_players[playerIndex]);
    }
    public boolean didPlayerHoverExam(int playerIndex){
        if (_players[playerIndex].getPosition() - _diceResult < _board.getExamsPositions()[0] && _players[playerIndex].getPosition() >= _board.getExamsPositions()[0]){
            _board.getTile(_board.getExamsPositions()[0]).applyTileEffect(_players[playerIndex]);
            return true;
        } else if ( _players[playerIndex].getPosition() - _diceResult < _board.getExamsPositions()[1] && _players[playerIndex].getPosition() >= _board.getExamsPositions()[1]){
            _board.getTile(_board.getExamsPositions()[1]).applyTileEffect(_players[playerIndex]);
            return true;
        }
        return false;
    }

    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer) {
        for (int i = 0; i < _nbPlayer; i++) {
            if (originPlayer[i].equalsIgnoreCase("prepa")) {
                _formerStudies[i] = FormerStudies.PREPA;
            } if (originPlayer[i].equalsIgnoreCase("ast")) {
                _formerStudies[i] = FormerStudies.AST;
            } if (majorPlayer[i].equalsIgnoreCase("Informatique")) {
                _majors[i] = Major.COMPUTER_SCIENCE;
            } if (majorPlayer[i].equalsIgnoreCase("MC")) {
                _majors[i] = Major.MATERIALS;
            } if (majorPlayer[i].equalsIgnoreCase("Electronique")) {
                _majors[i] = Major.ELECTRONICS;
            }

            if (originPlayer[i].equalsIgnoreCase("prep school")) {
                _formerStudies[i] = FormerStudies.PREPA;
            } if (originPlayer[i].equalsIgnoreCase("ast")) {
                _formerStudies[i] = FormerStudies.AST;
            } if (majorPlayer[i].equalsIgnoreCase("Computer Science")) {
                _majors[i] = Major.COMPUTER_SCIENCE;
            } if (majorPlayer[i].equalsIgnoreCase("Materials")) {
                _majors[i] = Major.MATERIALS;
            } if (majorPlayer[i].equalsIgnoreCase("Electronics")) {
                _majors[i] = Major.ELECTRONICS;
            }
        }

        for (int i = 0; i < _nbPlayer; i++) {
            _players[i] = new Player(playerName[i], null, _formerStudies[i], _majors[i], colorPlayer[i]);
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

    public void setDiceResult(int diceResult){
        _diceResult = diceResult; // Used only for test so compile only during tests
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
    public void addObserver(Observer observer) {
        _observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        _observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : _observers) {
            o.update(this);
        }
    }

}
