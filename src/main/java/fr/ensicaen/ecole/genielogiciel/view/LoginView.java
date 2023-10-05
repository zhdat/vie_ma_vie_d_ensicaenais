package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.LoginMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    public ListView<String> _listView;
    private LoginPresenter _presenter;
    private Stage _stage;
    @FXML
    private TextField _nickName;
    @FXML
    private TextField _filiere;
    @FXML
    private TextField _provenance;
    @FXML
    private Label _errorLabel;

    @FXML
    private ColorPicker _colorPicker;

    @FXML
    private Circle _player;

    @FXML
    private ChoiceBox<String> _sector;

    @FXML
    private ChoiceBox<String> _origin;
    private final int _nbPlayer = 4;
    private int _playerIndex = 0;
    private String[] _playerName = new String[_nbPlayer];
    private String[] _originPlayer = new String[_nbPlayer];
    private String[] _majorPlayer = new String[_nbPlayer];
    private ObservableList<String> items = FXCollections.observableArrayList();
    private Color[] _colorPlayer = new Color[_nbPlayer];

    public void setPresenter(LoginPresenter presenter) {
        _presenter = presenter;
    }

    public static LoginView createView(Stage primaryStage, String resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginView.class.getResource(resourceName), LoginMain.getMessageBundle());
        Parent root = loader.load();
        // getController() does not return a presenter but actually a class of the View
        // if we want the presenter independent of the API JavaFX.
        LoginView view = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        view._stage = primaryStage;
        return view;
    }

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    public void displayError(String message) {
        _errorLabel.setText(message);
    }

    public void initialize() {
        initializeSectorChoiceBox();
        initializeOriginChoiceBox();
        _colorPicker.setOnAction(event -> {
            Color selectedColor = _colorPicker.getValue();
            _player.setFill(selectedColor);
        });
    }

    private void initializeSectorChoiceBox() {
        _sector.getItems().addAll("Informatique", "MC", "Electronique");
        _sector.getSelectionModel().selectFirst();
    }

    private void initializeOriginChoiceBox() {
        _origin.getItems().addAll("Prepa", "AST");
        _origin.getSelectionModel().selectFirst();
    }

    @FXML
    private void launchGame() {
        _presenter.launchGame(_nickName.getText(), _playerName, _originPlayer, _majorPlayer, _colorPlayer);
    }

    @FXML
    private void addPlayer() {
        _playerName[_playerIndex] = _nickName.getText();
        _originPlayer[_playerIndex] = _origin.getValue();
        _majorPlayer[_playerIndex] = _sector.getValue();
        _colorPlayer[_playerIndex] = _colorPicker.getValue();

        items.add(_playerName[_playerIndex] + " ; " +  _originPlayer[_playerIndex] + " ; " + _majorPlayer[_playerIndex]);
        _listView.setItems(items);

        _playerIndex++;
    }

}
