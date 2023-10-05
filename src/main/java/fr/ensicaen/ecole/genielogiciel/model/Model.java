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
    private final int _nbCases = 64;
    private List<Observer> _observers;
    private final int _nbPlayer = 4;
    private Dice _dice;
    private int _diceResult;

    public Model() {
        _tiles = new Tile[_nbCases];
        _tiles[0] = new Rentree(0);
        _tiles[1] = new English(1);
        _tiles[2] = new Sensor(2);
        _tiles[3] = new English(3);
        _tiles[4] = new IWE(4);
        _tiles[5] = new Cplusplus(5);
        _tiles[6] = new LVTwo(6);
        _tiles[7] = new Revision(7);
        _tiles[8] = new Thermodynamics(8);
        _tiles[9] = new ChemistryManipulation(9);
        _tiles[10] = new Party(10);
        _tiles[11] = new DDRS(11);
        _tiles[12] = new Maths(12);
        _tiles[13] = new English(13);
        _tiles[14] = new LVTwo(14);
        _tiles[15] = new GestionFinancière(15);
        _tiles[16] = new SmartCard(16);
        _tiles[17] = new BurnOut(17);
        _tiles[18] = new GestionFinancière(18);
        _tiles[19] = new Cryptography(19);
        _tiles[20] = new DDRS(20);
        _tiles[21] = new Examens(21);
        _tiles[22] = new Rentree(22);
        _tiles[23] = new Party(23);
        _tiles[24] = new English(24);
        _tiles[25] = new SmartCard(25);
        _tiles[26] = new IWE(26);
        _tiles[27] = new Hollidays(27);
        _tiles[28] = new Party(28);
        _tiles[29] = new DataBase(29);
        _tiles[30] = new Revision(30);
        _tiles[31] = new LVTwo(31);
        _tiles[32] = new ChemistryManipulation(32);
        _tiles[33] = new SylvieMaloMeeting(33);
        _tiles[34] = new Maths(34);
        _tiles[35] = new Hollidays(35);
        _tiles[36] = new DDRS(36);
        _tiles[37] = new Party(37);
        _tiles[38] = new Waves(38);
        _tiles[39] = new RecruitmentCourse(39);
        _tiles[40] = new OrganicChemistry(40);
        _tiles[41] = new Cplusplus(41);
        _tiles[42] = new Examens(42);
        _tiles[43] = new Rentree(43);
        _tiles[44] = new RecruitmentCourse(44);
        _tiles[45] = new Maths(45);
        _tiles[46] = new DDRS(46);
        _tiles[47] = new SmartCard(47);
        _tiles[48] = new Sensor(48);
        _tiles[49] = new Party(49);
        _tiles[50] = new OrganicChemistry(50);
        _tiles[51] = new Revision(51);
        _tiles[52] = new Thermodynamics(52);
        _tiles[53] = new ChemistryManipulation(53);
        _tiles[54] = new Cplusplus(54);
        _tiles[55] = new SylvieMaloMeeting(55);
        _tiles[56] = new DataBase(56);
        _tiles[57] = new Cryptography(57);
        _tiles[58] = new IWE(58);
        _tiles[59] = new Party(59);
        _tiles[60] = new LVTwo(60);
        _tiles[61] = new Waves(61);
        _tiles[62] = new English(62);
        _tiles[63] = new DDRS(63);


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
        System.out.println("Initial Position : " + initialPosition);
        System.out.println("Résultat dé : " + (int) (Math.ceil(_diceResult * _players[playerIndex].softskill())));
        int i = 0;
        while (i < (int) (Math.ceil(_diceResult * _players[playerIndex].softskill())) && (_players[playerIndex].getPosition() + 1 <= _nbCases)) {
            _players[playerIndex].goForward(1);
            notifyObservers();
            i++;
        }
        if (_players[playerIndex].getPosition() == _nbCases && (i == (int) Math.ceil(_diceResult * _players[playerIndex].softskill()) - 1)) {
            System.out.println(_players[playerIndex].getName() + " Win !!!");
        } else if (i != (int) (Math.ceil(_diceResult * _players[playerIndex].softskill()))) {
            _players[playerIndex].goBackward((int) Math.ceil(_diceResult * _players[playerIndex].softskill()) - i);
            notifyObservers();
        }
        for (int j = 0; j < _nbPlayer; j++){
            if (_players[playerIndex].getPosition() == _players[j].getPosition() && (j != playerIndex)){
                _players[j].setPosition(initialPosition);
                notifyObservers();
            }
        }
        /*_tiles[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/
        System.out.println(_players[playerIndex].getPosition());
    }

    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer) {
        for (int i = 0; i < _nbPlayer; i++) {
            if (originPlayer[i].equalsIgnoreCase("prepa")) {
                _origins[i] = Origin.PREPA;
            } if (originPlayer[i].equalsIgnoreCase("ast")) {
                _origins[i] = Origin.AST;
            } if (majorPlayer[i].equalsIgnoreCase("Informatique")) {
                _majors[i] = Sector.INFORMATIQUE;
            } if (majorPlayer[i].equalsIgnoreCase("MC")) {
                _majors[i] = Sector.MATERIAUX;
            } if (majorPlayer[i].equalsIgnoreCase("Electronique")) {
                _majors[i] = Sector.ELECTRONIQUE;
            }

            if (originPlayer[i].equalsIgnoreCase("prep school")) {
                _origins[i] = Origin.PREPA;
            } if (originPlayer[i].equalsIgnoreCase("aot")) {
                _origins[i] = Origin.AST;
            } if (majorPlayer[i].equalsIgnoreCase("Computer Science")) {
                _majors[i] = Sector.INFORMATIQUE;
            } if (majorPlayer[i].equalsIgnoreCase("Chemistry")) {
                _majors[i] = Sector.MATERIAUX;
            } if (majorPlayer[i].equalsIgnoreCase("Electronics")) {
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
