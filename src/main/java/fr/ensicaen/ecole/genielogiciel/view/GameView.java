package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.De;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView {
    public Button rollButton;
    public TextField diceResult;
    public Circle _player1;
    public Circle _tileStart;
    public Circle _tile1;
    public Circle _tile2;
    public Circle _tile3;
    public Circle _tile4;
    public Circle _tile5;
    public Circle _tile6;
    public Circle _tile7;
    public Circle _tile8;
    public Circle _tile9;
    public Circle _tile10;
    public Circle _tile11;
    public Circle _tile12;
    public Circle _player2;
    public Circle _player3;
    public Circle _player4;
    private GamePresenter _gamePresenter;
    private Stage _stage;
    private int _result;
    private double[] _tabX;
    private double[] _tabY;
    private Circle[] _tabPlayer;
    private int _nbTurn = 0;

    public void initialize() {
        _tabX = new double[63];
        _tabX[0] = _tileStart.getLayoutX();
        _tabX[1] = _tile1.getLayoutX();
        _tabX[2] = _tile2.getLayoutX();
        _tabX[3] = _tile3.getLayoutX();
        _tabX[4] = _tile4.getLayoutX();
        _tabX[5] = _tile5.getLayoutX();
        _tabX[6] = _tile6.getLayoutX();
        _tabX[7] = _tile7.getLayoutX();
        _tabX[8] = _tile8.getLayoutX();
        _tabX[9] = _tile9.getLayoutX();
        _tabX[10] = _tile10.getLayoutX();
        _tabX[11] = _tile11.getLayoutX();
        _tabX[12] = _tile12.getLayoutX();

        _tabY = new double[63];
        _tabY[0] = _tileStart.getLayoutY();
        _tabY[1] = _tile1.getLayoutY();
        _tabY[2] = _tile2.getLayoutY();
        _tabY[3] = _tile3.getLayoutY();
        _tabY[4] = _tile4.getLayoutY();
        _tabY[5] = _tile5.getLayoutY();
        _tabY[6] = _tile6.getLayoutY();
        _tabY[7] = _tile7.getLayoutY();
        _tabY[8] = _tile8.getLayoutY();
        _tabY[9] = _tile9.getLayoutY();
        _tabY[10] = _tile10.getLayoutY();
        _tabY[11] = _tile11.getLayoutY();
        _tabY[12] = _tile12.getLayoutY();

        _tabPlayer = new Circle[4];
        _tabPlayer[0] = _player1;
        _tabPlayer[1] = _player2;
        _tabPlayer[2] = _player3;
        _tabPlayer[3] = _player4;
        rollButton.setOnAction(this::handleRollButtonClick);
    }

    private void handleRollButtonClick(ActionEvent actionEvent) {
        if (_nbTurn > 3){
            _nbTurn = 0;
        }
        System.out.println(_nbTurn);
        De de = new De();
        _result = de.lancerDe();
        int position = _gamePresenter.runGameLoop(_result);
        _tabPlayer[_nbTurn].setLayoutX(_tabX[position]);
        _tabPlayer[_nbTurn].setLayoutY(_tabY[position]);
        _nbTurn++;
        update();
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

    public void setPresenter(GamePresenter gamePresenter) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed(KeyCode code) {
        if (code == KeyCode.ENTER) {
            _gamePresenter.runGameLoop(_result);
        }
    }

    public void update() {
        diceResult.setText(String.valueOf(_result));
    }
}
