package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public abstract class Case {
    private int _position;
    public Case(int position){
        _position = position;
    }
    public abstract void appliquerEffet(Joueur joueur);
    public int getPosition(){
        return _position;
    }
}
