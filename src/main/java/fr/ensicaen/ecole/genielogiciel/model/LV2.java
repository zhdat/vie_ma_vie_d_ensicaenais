package fr.ensicaen.ecole.genielogiciel.model;

public class LV2 extends Case{
    public LV2(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
