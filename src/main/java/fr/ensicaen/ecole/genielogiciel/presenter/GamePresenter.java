package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public final class GamePresenter {
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int nbTour = 0;
    private int _tour = 0;

    public GamePresenter(String nickName) {
        _model = new Model();
        _model.setNickname(nickName);
    }

    public void setView(GameView view) {
        _view = view;
    }

    public int runGameLoop(int dice) {
        System.out.println("Et c'est parti...");
        if (nbTour > 3){
            nbTour = 0;
        }
        if (_tour == 0){
            _model.startGame();
        }
        int position = _model.playTurn(nbTour, dice);
        nbTour++;
        _tour++;
        return position;
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}
