package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public class Burnout extends Case{
    public Burnout(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setPosition(0);
    }
}
