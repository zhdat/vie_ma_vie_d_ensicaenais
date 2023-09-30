package fr.ensicaen.ecole.genielogiciel.model;

public class Recruitment extends Case{
    public Recruitment(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
