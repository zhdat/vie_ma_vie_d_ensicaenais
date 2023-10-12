package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import javafx.scene.paint.Color;

public final class GamePresenter implements Observer{
    private final Model _model;
    private GameView _view;
    private final boolean _end = false;
    private int _nbTurn = 0;
    private int _turn = 0;
    private int _valueTurn = 0;
    private final int _nbPlayer = 4;
    private final int _nbTiles = 64;
    private int _nbPlayerFinish = 0;
    private final GameLogic _gameLogic;

    public GamePresenter(String nickName) {
        _gameLogic = new GameLogic();
        _model = new Model(_gameLogic);
        _gameLogic.setNickname(nickName);
        _model.addObserver(this);
    }

    public void setView(GameView view) {
        _view = view;
    }

    public void runGameLoop() {
        int count = 0;
        System.out.println("Et c'est parti...");
        if (_nbTurn > (_nbPlayer - 1)){
            _nbTurn = 0;
        }
        Player[] players = _gameLogic.getPlayers();
        while (players[_nbTurn].getFinish()){
            count++;
            _nbTurn++;
            if (_nbTurn > (_nbPlayer - 1)){
                _nbTurn = 0;
            }
            if (count >= 8){
                break;
            }
        }
        if (_nbTurn > (_nbPlayer - 1)){
            _nbTurn = 0;
        }
        if (_turn == 0){
            _model.startGame();
        }
        if (_turn % (_nbPlayer - _nbPlayerFinish) == 0){
            _valueTurn++;
        }
        if (players[_nbTurn].getPosition() != _nbTiles){
            _model.playTurn(_nbTurn);
        }
        _nbTurn++;
        _turn++;
    }


    @Override
    public void update(Object object) {
        int[] positions = new int[_gameLogic.getNbPlayer()];
        Player[] players = _gameLogic.getPlayers();
        for (int i = 0; i < _gameLogic.getNbPlayer(); i++){
            positions[i] = players[i].getPosition();
        }
        String[] playersName = new String[_nbPlayer];
        for (int i = 0; i < _nbPlayer; i++){
            playersName[i] = _gameLogic.getPlayers()[i].getName();
        }
        String[] major = new String[_nbPlayer];
        String[] origin = new String[_nbPlayer];
        String[] softskill = new String[_nbPlayer];
        String[] skillLevel = new String[_nbPlayer];

        for (int i = 0; i < _nbPlayer; i++){
            major[i] = String.valueOf(_gameLogic.getPlayers()[i].getMajor());
            origin[i] = String.valueOf(_gameLogic.getPlayers()[i].getFormerStudies());
            softskill[i] = String.valueOf(_gameLogic.getPlayers()[i].getSoftSkill());
            skillLevel[i] = String.valueOf(_gameLogic.getPlayers()[i].getSkillLevel());
        }
        Color[] colors = new Color[_nbPlayer];
        for (int i = 0; i < _nbPlayer; i++){
            colors[i] = players[i].getColor();
        }

        _view.displayPlayer(positions, colors, _nbTurn);
        _view.displayDice(_gameLogic.getDiceResult());
        _view.displayPlayerName(playersName, _nbTurn);
        _view.displayPlayerSoftskill(softskill, _nbTurn);
        _view.displayCharacteristics(major, origin, softskill, skillLevel, _nbTurn);
        _view.displayTurn(_valueTurn);

        if (_gameLogic.getPlayers()[_nbTurn].getFinish()){
            _nbPlayerFinish++;
            _view.popupFinish(playersName[_nbTurn]);
        }
    }
    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer){
        _model.createPlayer(playerName, originPlayer, majorPlayer, colorPlayer);
    }
}
