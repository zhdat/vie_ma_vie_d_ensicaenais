package fr.ensicaen.ecole.genielogiciel.model;

public class Anglais extends Case{
    public Anglais(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
