package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.view.Observer;
import fr.ensicaen.ecole.genielogiciel.view.WinningView;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class WinningPresenter implements Observer{

    private WinningView _winningView;
    private Stage stage;

    public WinningPresenter() {
        _winningView = new WinningView();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Victoire");

        Scene scene = new Scene(_winningView.getRootPane(), 600, 400);
        stage.setScene(scene);
    }

    public void show(String winningMessage) {
        _winningView.setWinningMessage(winningMessage);
        stage.show();
    }

    @Override
    public void update(Object O) {

    }

    public void setWinningView(WinningView winningView) {
        _winningView = winningView;
    }
}
