package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public final class GamePresenter implements Observer{
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int nbTour = 0;
    private int _tour = 0;
    private int valueTour = 0;

    public GamePresenter(String nickName) {
        _model = new Model();
        _model.setNickname(nickName);
        _model.addObserver(this);
    }

    public void setView(GameView view) {
        _view = view;
    }

    public void runGameLoop(int dice, TextArea characteristics, Label round, Label playerNickname) {
        System.out.println("Et c'est parti...");
        if (nbTour > 3){
            nbTour = 0;
        }
        if (_tour == 0){
            _model.startGame();
        }
        if (_tour%4 == 0){
            valueTour++;
        }
        _model.playTurn(nbTour, dice);
        Player[] players = _model.getPlayers();
        playerNickname.setText(players[nbTour].getName());
        characteristics.setText("Filière : " + players[nbTour].getFiliere() + "\n" + "Provenance : " + players[nbTour].getProvenance() + "\n" + "Softskill : " + players[nbTour].getSoftskill());
        round.setText("Tour numéro : " + String.valueOf(valueTour));
        nbTour++;
        _tour++;
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
    }
}
