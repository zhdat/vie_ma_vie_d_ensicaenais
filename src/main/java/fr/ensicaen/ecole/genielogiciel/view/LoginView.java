package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.LoginMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView{
    private LoginPresenter _presenter;
    private Stage _stage;
    @FXML
    private TextField _nickName;
    @FXML
    private TextField _filiere; // FIXME anglais
    @FXML
    private TextField _provenance; // FIXME anglais
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

    public void setPresenter( LoginPresenter presenter ) {
        _presenter = presenter;
    }

    public static LoginView createView( Stage primaryStage, String  resourceName) throws IOException {
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

    public void displayError( String message ) {
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
        _sector.getItems().addAll("Info", "MC", "Elec");
        _sector.getSelectionModel().selectFirst();
    }

    private void initializeOriginChoiceBox() {
        _origin.getItems().addAll("Prepa", "DUT", "Licence");
        _origin.getSelectionModel().selectFirst();
    }

    @FXML
    private void launchGame() {
        _presenter.launchGame(_nickName.getText());
    }

}
