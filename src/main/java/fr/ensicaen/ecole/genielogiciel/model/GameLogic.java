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

public class GameLogic {
    private String _nickname;
    private final Player[] _players;
    private FormerStudies[] _formerStudies;
    private Major[] _majors;
    private final Board _board;
    private int _turn;
    private final int _nbPlayer = 4;
    private Dice _dice;
    private int _diceResult;

    public GameLogic() {
        _board = new ClassicBoard();
        _players = new Player[_nbPlayer];
        _formerStudies = new FormerStudies[_nbPlayer];
        _majors = new Major[_nbPlayer];
        _dice = new Dice();
    }

    public void startGame() {
        for (Player player : _players) {
            player.setRandomSoftSkill();
        }
        _turn = 1;
    }

    public void playTurn(int playerIndex) {
        _diceResult = _dice.roll();
        play(playerIndex);
    }

    private void play(int playerIndex) {
        int initialPosition = _players[playerIndex].getPosition();
        int i = 0;
        while ((i < (int) (Math.ceil(_diceResult * _players[playerIndex].softSkillEffect()))) && ((_players[playerIndex].getPosition() + 1) <= (_board.getNumberOfTiles() - 1))) {
            _players[playerIndex].goForward(1);
            i++;
        }
        testFinish(playerIndex, i, _players, _board, _diceResult);
        for (int j = 0; j < _nbPlayer; j++) {
            if (playerIndex != j) {
                if (_players[playerIndex].getPosition() == _players[j].getPosition() && !_players[j].getFinish()) {
                    _players[j].setPosition(initialPosition);
                }
            }
        }
    }

    static void testFinish(int playerIndex, int i, Player[] players, Board board, int diceResult) {
        if (players[playerIndex].getPosition() == (board.getNumberOfTiles() - 1) && (i == (int) Math.ceil(diceResult * players[playerIndex].softSkillEffect()))) {
            players[playerIndex].setFinish();
        } else if (i != (int) (Math.ceil(diceResult * players[playerIndex].softSkillEffect()))) {
            players[playerIndex].goBackward((int) Math.ceil(diceResult * players[playerIndex].softSkillEffect()) - i);
        }
    }

    public void createPlayers(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer) {
        majorFormerStudies(originPlayer, majorPlayer, _nbPlayer, _formerStudies, _majors);
        for (int i = 0; i < _nbPlayer; i++) {
            _players[i] = new Player(playerName[i], null, _formerStudies[i], _majors[i], colorPlayer[i]);
        }
    }

    static void majorFormerStudies(String[] originPlayer, String[] majorPlayer, int nbPlayer, FormerStudies[] formerStudies, Major[] majors) {
        for (int i = 0; i < nbPlayer; i++) {
            if (originPlayer[i].equalsIgnoreCase("prepa")) {
                formerStudies[i] = FormerStudies.PREPA;
            }
            if (originPlayer[i].equalsIgnoreCase("ast")) {
                formerStudies[i] = FormerStudies.AST;
            }
            if (majorPlayer[i].equalsIgnoreCase("Informatique")) {
                majors[i] = Major.COMPUTER_SCIENCE;
            }
            if (majorPlayer[i].equalsIgnoreCase("MC")) {
                majors[i] = Major.MATERIALS;
            }
            if (majorPlayer[i].equalsIgnoreCase("Electronique")) {
                majors[i] = Major.ELECTRONICS;
            }

            if (originPlayer[i].equalsIgnoreCase("prep school")) {
                formerStudies[i] = FormerStudies.PREPA;
            }
            if (originPlayer[i].equalsIgnoreCase("aot")) {
                formerStudies[i] = FormerStudies.AST;
            }
            if (majorPlayer[i].equalsIgnoreCase("Computer Science")) {
                majors[i] = Major.COMPUTER_SCIENCE;
            }
            if (majorPlayer[i].equalsIgnoreCase("Chemistry")) {
                majors[i] = Major.MATERIALS;
            }
            if (majorPlayer[i].equalsIgnoreCase("Electronics")) {
                majors[i] = Major.ELECTRONICS;
            }
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

    public int getTurn() {
        return _turn;
    }

    public int getNbPlayer() {
        return _nbPlayer;
    }

    public int getDiceResult() {
        return _diceResult;
    }
}
