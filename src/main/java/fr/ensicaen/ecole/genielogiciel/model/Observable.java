package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.view.Observer;

public interface Observable {
    void addObserver(Observer O);
    void removeObserver(Observer O);
    void notifyObservers();
}
