package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public class Anglais extends Case{
    public Anglais(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
