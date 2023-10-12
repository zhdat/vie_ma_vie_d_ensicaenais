package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public final class GameView{
    public Button _rollButton;
    public ImageView _diceResult;
    public ImageView _softSkill;
    public AnchorPane _board;
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
    public Circle _tile64;
    public TextArea _characteristics;
    public Label _round;
    public Circle playerColor;
    public Label _playerNickname;
    public ProgressBar _skillProgress;
    private GamePresenter _gamePresenter;
    private Stage _stage;
    private int _result;
    private double[] _xPosOfTile;
    private double[] _yPosOfTile;
    private Circle[] _tabPlayer;
    private Circle[] _tabTile;
    private int _turn = 0;
    private static final int _numberOfTiles = 65;

    private Locale _selectedLanguage;

    public void initialize() {
        _tabTile = new Circle[_numberOfTiles];
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
        _tabTile[64] = _tile64;

        _xPosOfTile = new double[_numberOfTiles];
        _yPosOfTile = new double[_numberOfTiles];
        for (int i = 0; i < _numberOfTiles; i++){
            _xPosOfTile[i] = _tabTile[i].getLayoutX();
        }
        for (int i = 0; i < _numberOfTiles; i++){
            _yPosOfTile[i] = _tabTile[i].getLayoutY();
        }

        _tabPlayer = new Circle[4];
        _tabPlayer[0] = _player1;
        _tabPlayer[1] = _player2;
        _tabPlayer[2] = _player3;
        _tabPlayer[3] = _player4;

        _rollButton.setOnAction(this::handleRollButtonClick);
    }

    private void handleRollButtonClick(ActionEvent actionEvent) {
        if (_turn > 3){
            _turn = 0;
        }
        _gamePresenter.runGameLoop();
        _turn++;
    }

    public static GameView createView(Locale selectedLanguage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("Application.fxml"), LoginMain.getMessageBundle(selectedLanguage));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 1423, 947);
        Stage stage = new Stage();
        stage.setScene(scene);
        view._stage = stage;
        if (selectedLanguage == Locale.ENGLISH){
            view._board.getStyleClass().clear();
            view._board.getStyleClass().add("board_en");
        }
        view._selectedLanguage = selectedLanguage;
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
            _gamePresenter.runGameLoop();
        }
    }
    public void displayPlayer(int[] positions, Color[] colors, int nbTurn){
        for (int i = 0; i < 4; i++){
            _tabPlayer[i].setFill(colors[i]);
            _tabPlayer[i].setLayoutX(_xPosOfTile[positions[i]]);
            _tabPlayer[i].setLayoutY(_yPosOfTile[positions[i]]);
        }
        playerColor.setFill(_tabPlayer[nbTurn].getFill());
    }
    public void displayDice(int diceResult){
        Image _diceImage = new Image("file:src/main/resources/fr/ensicaen/ecole/genielogiciel/view/images/" + diceResult + ".png");
        _diceResult.setImage(_diceImage);
    }

    public void displayPlayerSoftskill(String[] softskill, int nbTurn){
        Image _softSkillImage = new Image("file:src/main/resources/fr/ensicaen/ecole/genielogiciel/view/images/" + softskill[nbTurn] + ".png");
        _softSkill.setImage(_softSkillImage);
    }
    public void displayPlayerName(String[] playersName, int nbTurn){
        _playerNickname.setText(playersName[nbTurn]);
    }
    public void displayCharacteristics(String[] major, String[] origin, String[] softskill, String[] skillLevel, int nbTurn){
        if (_selectedLanguage == Locale.ENGLISH)
            _characteristics.setText("Major : " + major[nbTurn] + "\n" + "Former Studies : " + origin[nbTurn] + "\n" + "Softskill : " + softskill[nbTurn] + "\n" + "SkillLevel : " + skillLevel[nbTurn]);

        else if (_selectedLanguage == Locale.FRENCH) {
            String majorFR = "";
            String originFR = "";
            String softskillFR = "";
            String skillLevelFR = "";

            switch (softskill[nbTurn]) {
                case "HARDWORKING":
                    softskillFR = "Assidu";
                    break;
                case "BRILLIANT":
                    softskillFR = "Brillant";
                    break;
                case "DILETTANTE":
                    softskillFR = "Dilettante";
                    break;
            }

            switch (origin[nbTurn]){
                case "PREPA":
                    originFR = "Prépa";
                    break;
                case "AST":
                    originFR = "AST";
                    break;
            }

            switch (major[nbTurn]){
                case "COMPUTER_SCIENCE":
                    majorFR = "Informatique";
                    break;
            case "MATERIALS":
                    majorFR = "Matériaux";
                    break;
            case "ELECTRONICS":
                    majorFR = "Electronique";
                    break;
            }
            _characteristics.setText("Filière : " + majorFR + "\n" + "Provenance : " + originFR + "\n" + "Softskill : " + softskillFR + "\n" + "Niveau de compétence : " + skillLevel[nbTurn]);
        }
        _skillProgress.setProgress(Double.valueOf(skillLevel[nbTurn]) / 4);
    }
    public void displayTurn(int turn){
        if (_selectedLanguage == Locale.ENGLISH)
            _round.setText("Turn number : " + turn);
        else if (_selectedLanguage == Locale.FRENCH)
            _round.setText("Tour numéro : " + turn);
    }
    public void createPlayer(String[] playerName, String[] originPlayer, String[] majorPlayer, Color[] colorPlayer){
        _gamePresenter.createPlayer(playerName, originPlayer, majorPlayer, colorPlayer);
    }
    public void popupFinish(String winner){
        Alert languageDialog = new Alert(Alert.AlertType.INFORMATION);
        if (_selectedLanguage == Locale.ENGLISH){
            languageDialog.setTitle("End of game");
            languageDialog.setHeaderText("Well played to :" + winner);
        }
        else if (_selectedLanguage == Locale.FRENCH){
            languageDialog.setTitle("Fin de jeu");
            languageDialog.setHeaderText("Bien joué à :" + winner);
        }
        languageDialog.showAndWait();
    }
}
