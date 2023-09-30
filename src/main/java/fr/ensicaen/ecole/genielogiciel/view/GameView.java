package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.Case;
import fr.ensicaen.ecole.genielogiciel.model.De;
import fr.ensicaen.ecole.genielogiciel.model.Joueur;
import fr.ensicaen.ecole.genielogiciel.model.Plateau;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView {
    public Button rollButton;
    public TextField diceResult;
    private GamePresenter _gamePresenter;
    private Stage _stage;

    public void initialize(){
        rollButton.setOnAction(this::handleRollButtonClick);
    }

    private void handleRollButtonClick(javafx.event.ActionEvent actionEvent) {
        _gamePresenter.runGameLoop();
    }

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(GameView.class.getResource("Application.fxml"));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 1920, 1080);
        Stage stage = new Stage();
        stage.setScene(scene);
        view._stage = stage;
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> view.onKeyPressed(event.getCode()));
        return view;
    }

    public void setPresenter( GamePresenter gamePresenter ) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed( KeyCode code ) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.runGameLoop();
        }
    }
    public void update(){
        diceResult.setText(String.valueOf(_gamePresenter.getResult()));
    }
}
