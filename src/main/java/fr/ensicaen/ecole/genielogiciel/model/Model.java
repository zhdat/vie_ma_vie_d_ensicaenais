package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.presenter.Observer;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observable {
    private final GameLogic _gameLogic;
    private final List<Observer> _observers;

    public Model(GameLogic gameLogic) {
        _gameLogic = gameLogic;
        _observers = new ArrayList<>();
    }

    public void startGame() {
        _gameLogic.startGame();
        notifyObservers();
    }

    public void playTurn(int playerIndex) {
        _gameLogic.playTurn(playerIndex);
        notifyObservers();
    }

    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer) {
        _gameLogic.createPlayers(playerName, originPlayer, majorPlayer, colorPlayer);
        notifyObservers();
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
