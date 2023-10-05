package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.view.Observer;

public interface Observable {
    void addObserver(Observer O); // FIXME les paramètres doivent être camelCase
    void removeObserver(Observer O);
    void notifyObservers();
}
