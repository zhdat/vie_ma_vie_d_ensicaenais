package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public class Rentrée extends Case {
    public Rentrée(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setPosition(0); /* @TODO : set la position des cases rentrées*/
    }
}
