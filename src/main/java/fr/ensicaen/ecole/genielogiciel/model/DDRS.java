package fr.ensicaen.ecole.genielogiciel.model;

public class DDRS extends Case{
    public DDRS(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
