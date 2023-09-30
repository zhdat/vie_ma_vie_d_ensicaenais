package fr.ensicaen.ecole.genielogiciel.model;

public class Burnout extends Case{
    public Burnout(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setPosition(0);
    }
}
