package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;

import java.io.IOException;

public final class LoginPresenter {
    private LoginView _view;

    public void setView( LoginView view ) {
        _view = view;
    }

    public void launchGame( String nickName ) {
        if (nickName.isEmpty()) {
            _view.displayError(LoginMain.getMessageBundle().getString("error.nickname"));
        } else {
            try {
                createAndDisplayGameView(nickName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            _view.close();
        }
        Joueur joueur1 = new Joueur(_view.getNickname(), null, _view.getProvenance(), _view.getFiliere());
        System.out.println(joueur1.getName());
        System.out.println(joueur1.getProvenance());
        System.out.println(joueur1.getFiliere());
        joueur1.randomSoftskill();
        System.out.println(joueur1.getSoftskill());
    }

    private void createAndDisplayGameView( String nickName ) throws IOException {
        GameView view = GameView.createView();
        GamePresenter gamePresenter = new GamePresenter(nickName);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
    }
}
