package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public final class LoginMain extends Application {
    public static void main( String[] args ) {
        launch(args);
    }

    public static ResourceBundle getMessageBundle(Locale selectedLocale) {
        if(selectedLocale == Locale.FRENCH)
            return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
        else if(selectedLocale == Locale.ENGLISH)
            return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle_en_US");
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
    }

    @Override
    public void start( final Stage primaryStage ) throws Exception {
        /* Création de la vue et presentateur */
        Locale selectedLocale = determineSelectedLocale(); // Vous devez implémenter cette méthode

        /* Création de la vue et présentateur en fonction de la locale sélectionnée */
        LoginView view = LoginView.createView(primaryStage, "LoginDialog.fxml", selectedLocale);
        LoginPresenter presenter = new LoginPresenter();
        view.setPresenter(presenter);
        presenter.setView(view);
        view.show();
    }

    private Locale determineSelectedLocale() {
        // Affichez une boîte de dialogue ou un menu déroulant pour que l'utilisateur sélectionne la nouvelle langue.
        // Ensuite, retournez la locale correspondante en fonction du choix de l'utilisateur.

        // Exemple de code pour afficher une boîte de dialogue :
        Alert languageDialog = new Alert(Alert.AlertType.CONFIRMATION);
        languageDialog.setTitle("Choose the language");
        languageDialog.setHeaderText("Select your language :");

        ButtonType frenchButton = new ButtonType("Français", ButtonBar.ButtonData.OK_DONE);
        ButtonType englishButton = new ButtonType("English", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        languageDialog.getButtonTypes().setAll(frenchButton, englishButton, cancelButton);

        Optional<ButtonType> result = languageDialog.showAndWait();

        if (result.isPresent()) {
            if (result.get() == frenchButton) {
                return Locale.FRENCH;
            } else if (result.get() == englishButton) {
                System.out.println("Anglais");
                System.out.println(Locale.ENGLISH);
                System.out.println(Locale.getDefault());
                return Locale.ENGLISH;
            }
        }

        // Si l'utilisateur annule, retournez la locale actuelle.
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle").getLocale();
    }

}
