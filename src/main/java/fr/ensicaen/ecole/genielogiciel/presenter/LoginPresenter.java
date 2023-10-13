package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Locale;

public final class LoginPresenter implements Observer{
    private LoginView _view;

    public void setView( LoginView view ) {
        _view = view;
    }

    public void launchGame(String nickName, String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer, Locale selectedLanguage) {
        if (nickName.isEmpty()) {
            _view.displayError(LoginMain.getMessageBundle(selectedLanguage).getString("error.nickname"));
        } else {
            try {
                createAndDisplayGameView(nickName, playerName, originPlayer, majorPlayer, colorPlayer, selectedLanguage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            _view.close();
        }
    }

    private void createAndDisplayGameView(String nickName, String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer, Locale selectedLanguage) throws IOException {
        GameView view = GameView.createView(selectedLanguage);
        GamePresenter gamePresenter = new GamePresenter(nickName);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
        view.createPlayer(playerName, originPlayer, majorPlayer, colorPlayer);
    }

    @Override
    public void update(Object object) {

    }
}
