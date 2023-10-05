package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.Observer;
import javafx.scene.paint.Color;

public final class GamePresenter implements Observer{
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int _nbTurn = 0;
    private int _turn = 0;
    private int _valueTurn = 0;
    private final int _nbPlayer = 4;

    public GamePresenter(String nickName) {
        _model = new Model();
        _model.setNickname(nickName);
        _model.addObserver(this);
    }

    public void setView(GameView view) {
        _view = view;
    }

    public void runGameLoop() {
        System.out.println("Et c'est parti...");
        if (_nbTurn > (_nbPlayer - 1)){
            _nbTurn = 0;
        }
        if (_turn == 0){
            _model.startGame();
        }
        if (_turn %_nbPlayer == 0){
            _valueTurn++;
        }
        _model.playTurn(_nbTurn);
        _nbTurn++;
        _turn++;
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }

    @Override
    public void update(Object O) {
        int[] positions = new int[_model.getNbPlayer()];
        Player[] players = ((Model)O).getPlayers();
        for (int i = 0; i < _model.getNbPlayer(); i++){
            positions[i] = players[i].getPosition();
        }
        String[] playersName = new String[_nbPlayer];
        for (int i = 0; i < _nbPlayer; i++){
            playersName[i] = _model.getPlayers()[i].getName();
        }
        String[] major = new String[_nbPlayer];
        String[] origin = new String[_nbPlayer];
        String[] softskill = new String[_nbPlayer];
        for (int i = 0; i < _nbPlayer; i++){
            major[i] = String.valueOf(_model.getPlayers()[i].getFiliere());
            origin[i] = String.valueOf(_model.getPlayers()[i].getProvenance());
            softskill[i] = String.valueOf(_model.getPlayers()[i].getSoftskill());
        }
        Color[] colors = new Color[_nbPlayer];
        for (int i = 0; i < _nbPlayer; i++){
            colors[i] = players[i].getColor();
        }


        _view.displayPlayer(positions, colors);
        _view.displayDice(_model.getDiceResult());
        _view.displayPlayerName(playersName);
        _view.displayCharacteristics(major, origin, softskill);
        _view.displayTurn(_valueTurn);
    }
    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer){
        _model.createPlayer(playerName, originPlayer, majorPlayer, colorPlayer);
    }
}
