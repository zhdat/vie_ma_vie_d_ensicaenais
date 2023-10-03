package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.Dice;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView{
    public Button _rollButton;
    public TextField _diceResult;
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
    public Circle _tile13;
    public Circle _tile14;
    public Circle _tile15;
    public Circle _tile16;
    public Circle _tile17;
    public Circle _tile18;
    public Circle _tile19;
    public Circle _tile20;
    public Circle _tile21;
    public Circle _tile22;
    public Circle _tile23;
    public Circle _tile24;
    public Circle _tile25;
    public Circle _tile26;
    public Circle _tile27;
    public Circle _tile28;
    public Circle _tile29;
    public Circle _tile30;
    public Circle _tile31;
    public Circle _tile32;
    public Circle _tile33;
    public Circle _tile34;
    public Circle _tile35;
    public Circle _tile36;
    public Circle _tile37;
    public Circle _tile38;
    public Circle _tile39;
    public Circle _tile40;
    public Circle _tile41;
    public Circle _tile42;
    public Circle _tile43;
    public Circle _tile44;
    public Circle _tile45;
    public Circle _tile46;
    public Circle _tile47;
    public Circle _tile48;
    public Circle _tile49;
    public Circle _tile50;
    public Circle _tile51;
    public Circle _tile52;
    public Circle _tile53;
    public Circle _tile54;
    public Circle _tile55;
    public Circle _tile56;
    public Circle _tile57;
    public Circle _tile58;
    public Circle _tile59;
    public Circle _tile60;
    public Circle _tile61;
    public Circle _tile62;
    public Circle _tile63;
    public TextArea _characteristics;
    public Label _round;
    public Circle playerColor;
    public Label _playerNickname;
    private GamePresenter _gamePresenter;
    private Stage _stage;
    private int _result;
    private double[] _tabX;
    private double[] _tabY;
    private Circle[] _tabPlayer;
    private Circle[] _tabTile;
    private int _nbTurn = 0;
    private static final int _nbCases = 64;

    public void initialize() {
        _tabTile = new Circle[_nbCases];
        _tabTile[0] = _tileStart;
        _tabTile[1] = _tile1;
        _tabTile[2] = _tile2;
        _tabTile[3] = _tile3;
        _tabTile[4] = _tile4;
        _tabTile[5] = _tile5;
        _tabTile[6] = _tile6;
        _tabTile[7] = _tile7;
        _tabTile[8] = _tile8;
        _tabTile[9] = _tile9;
        _tabTile[10] = _tile10;
        _tabTile[11] = _tile11;
        _tabTile[12] = _tile12;
        _tabTile[13] = _tile13;
        _tabTile[14] = _tile14;
        _tabTile[15] = _tile15;
        _tabTile[16] = _tile16;
        _tabTile[17] = _tile17;
        _tabTile[18] = _tile18;
        _tabTile[19] = _tile19;
        _tabTile[20] = _tile20;
        _tabTile[21] = _tile21;
        _tabTile[22] = _tile22;
        _tabTile[23] = _tile23;
        _tabTile[24] = _tile24;
        _tabTile[25] = _tile25;
        _tabTile[26] = _tile26;
        _tabTile[27] = _tile27;
        _tabTile[28] = _tile28;
        _tabTile[29] = _tile29;
        _tabTile[30] = _tile30;
        _tabTile[31] = _tile31;
        _tabTile[32] = _tile32;
        _tabTile[33] = _tile33;
        _tabTile[34] = _tile34;
        _tabTile[35] = _tile35;
        _tabTile[36] = _tile36;
        _tabTile[37] = _tile37;
        _tabTile[38] = _tile38;
        _tabTile[39] = _tile39;
        _tabTile[40] = _tile40;
        _tabTile[41] = _tile41;
        _tabTile[42] = _tile42;
        _tabTile[43] = _tile43;
        _tabTile[44] = _tile44;
        _tabTile[45] = _tile45;
        _tabTile[46] = _tile46;
        _tabTile[47] = _tile47;
        _tabTile[48] = _tile48;
        _tabTile[49] = _tile49;
        _tabTile[50] = _tile50;
        _tabTile[51] = _tile51;
        _tabTile[52] = _tile52;
        _tabTile[53] = _tile53;
        _tabTile[54] = _tile54;
        _tabTile[55] = _tile55;
        _tabTile[56] = _tile56;
        _tabTile[57] = _tile57;
        _tabTile[58] = _tile58;
        _tabTile[59] = _tile59;
        _tabTile[60] = _tile60;
        _tabTile[61] = _tile61;
        _tabTile[62] = _tile62;
        _tabTile[63] = _tile63;

        _tabX = new double[_nbCases];
        _tabY = new double[_nbCases];
        for (int i = 0; i < _nbCases; i++){
            _tabX[i] = _tabTile[i].getLayoutX();
        }
        for (int i = 0; i < _nbCases; i++){
            _tabY[i] = _tabTile[i].getLayoutY();
        }

        _tabPlayer = new Circle[4];
        _tabPlayer[0] = _player1;
        _tabPlayer[1] = _player2;
        _tabPlayer[2] = _player3;
        _tabPlayer[3] = _player4;

        _rollButton.setOnAction(this::handleRollButtonClick);
    }

    private void handleRollButtonClick(ActionEvent actionEvent) {
        if (_nbTurn > 3){
            _nbTurn = 0;
        }
        Dice dice = new Dice();
        _result = dice.roll();
        _gamePresenter.runGameLoop(_result, _characteristics, _round, _playerNickname);
        playerColor.setFill(_tabPlayer[_nbTurn].getFill());
        _nbTurn++;
        update();
    }

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(GameView.class.getResource("Application.fxml"));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 1400, 913);
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
            _gamePresenter.runGameLoop(_result, _characteristics, _round, _playerNickname);
        }
    }

    public void update() {
        _diceResult.setText(String.valueOf(_result));
    }
    public void displayPlayer(int[] positions){
        _tabPlayer[_nbTurn].setLayoutX(_tabX[positions[_nbTurn]]);
        _tabPlayer[_nbTurn].setLayoutY(_tabY[positions[_nbTurn]]);
    }
}
