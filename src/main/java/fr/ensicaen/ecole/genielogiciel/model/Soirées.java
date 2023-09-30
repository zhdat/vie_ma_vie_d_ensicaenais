package fr.ensicaen.ecole.genielogiciel.model;

public class Soirées extends Case{
    public Soirées(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(-1);
    }
}
