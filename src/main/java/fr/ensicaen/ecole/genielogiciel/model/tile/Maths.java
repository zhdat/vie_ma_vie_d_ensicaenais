package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;
import fr.ensicaen.ecole.genielogiciel.model.origin.Provenance;

public class Maths extends Case {
    public Maths(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        if (joueur.getProvenance() == Provenance.PREPA){
            joueur.setCompetence(1);
        } else {
            joueur.setCompetence(-1);
        }
    }
}
