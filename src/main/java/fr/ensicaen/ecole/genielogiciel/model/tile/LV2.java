package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public class LV2 extends Case {
    public LV2(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
