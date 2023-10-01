package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

import java.util.Arrays;

public final class GamePresenter {
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int nbTour = 0;

    public GamePresenter(String nickName) {
        _model = new Model();
        _model.setNickname(nickName);
    }

    public void setView(GameView view) {
        _view = view;
    }

    public void runGameLoop() {
        System.out.println("Et c'est parti...");
        if (nbTour > 4){
            nbTour = 0;
        }
        Joueur[] players = _model.getPlayers();
        _model.startGame();
        _model.playTurn(nbTour);
        System.out.println("joueur 1" + players[0].getPosition());
        System.out.println("joueur 2" + players[1].getPosition());
        System.out.println("joueur 3" + players[2].getPosition());
        System.out.println("joueur 4" + players[3].getPosition());
        nbTour++;
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}
