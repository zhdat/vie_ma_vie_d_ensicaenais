package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.WinningPresenter;
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
    private WinningPresenter _presenter;

    @FXML
    private Pane rootPane;

    @FXML
    private Label winningMessage;

    public static WinningView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(WinningView.class.getResource("Win.fxml"));
        System.out.println(WinningView.class.getResource("Win.fxml"));
        Parent root = fxmlLoader.load();
        final WinningView view = fxmlLoader.getController();
        fxmlLoader.setController(view);

        // Create a new stage for the WinningView
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
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

    public void setPresenter(WinningPresenter presenter) {
        _presenter = presenter;
    }

    public void show() {
        stage.show();
    }
}
