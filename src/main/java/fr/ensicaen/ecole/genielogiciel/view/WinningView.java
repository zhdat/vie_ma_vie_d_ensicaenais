package fr.ensicaen.ecole.genielogiciel.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class WinningView {

    private Stage stage;

    @FXML
    private Pane rootPane;

    @FXML
    private Label winningMessage;

    public static WinningView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WinningView.class.getResource("Win.fxml"));
        Parent root = fxmlLoader.load();
        WinningView view = fxmlLoader.getController();

        // Create a new stage for the WinningView
        Stage stage = new Stage();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        view.stage = stage;

        return view;
    }

    public Pane getRootPane() {
        return rootPane;
    }

    public void setWinningMessage(String message) {
        winningMessage.setText(message);
    }

    public void show() {
        stage.show();
    }
}
