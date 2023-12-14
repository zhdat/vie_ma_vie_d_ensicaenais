module fr.ensicaen.ecole.genielogiciel
{
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.ensicaen.ecole.genielogiciel.view to javafx.fxml;
    exports fr.ensicaen.ecole.genielogiciel;
    exports fr.ensicaen.ecole.genielogiciel.view;
    exports fr.ensicaen.ecole.genielogiciel.presenter;
    opens fr.ensicaen.ecole.genielogiciel.presenter to javafx.fxml;
}