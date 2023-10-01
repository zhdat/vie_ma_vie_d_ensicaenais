package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Filiere;
import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;

public class Crypto extends Case{
    public Crypto(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        if (joueur.getFiliere() == Filiere.INFORMATIQUE){
            joueur.setCompetence(1);
        }
    }
}
