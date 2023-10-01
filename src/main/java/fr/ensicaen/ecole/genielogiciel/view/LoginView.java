package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.player.Filiere;
import fr.ensicaen.ecole.genielogiciel.model.origin.Provenance;
import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.LoginMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
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

    @FXML
    private void launchGame() {
        _presenter.launchGame(_nickName.getText());
    }
    public String getNickname(){
        return _nickName.getText();
    }
    public Filiere getFiliere(){
        if (_filiere.getText().equalsIgnoreCase("informatique")){
            return Filiere.INFORMATIQUE;
        } else if (_filiere.getText().equalsIgnoreCase("materiaux")) {
            return Filiere.MATERIAUX;
        } else if (_filiere.getText().equalsIgnoreCase("electronique")) {
            return Filiere.ELECTRONIQUE;
        }
        return null;
    }
    public Provenance getProvenance(){
        if (_provenance.getText().equalsIgnoreCase("prepa")) return Provenance.PREPA;
        else if (_provenance.getText().equalsIgnoreCase("ast")) return Provenance.AST;
        return null;
    }
}
