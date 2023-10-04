package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.Observer;

public final class GamePresenter implements Observer{
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int _nbTurn = 0;
    private int _turn = 0;
    private int _valueTurn = 0;

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
        if (_nbTurn > 3){
            _nbTurn = 0;
        }
        if (_turn == 0){
            _model.startGame();
        }
        if (_turn %4 == 0){
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
        _view.displayPlayer(positions);
        _view.displayDice(_model.getDiceResult());
        _view.displayPlayerName(_model.getPlayers());
        _view.displayCharacteristics(_model.getPlayers());
        _view.displayTurn(_valueTurn);
    }
}
