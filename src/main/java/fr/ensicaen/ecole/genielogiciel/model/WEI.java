package fr.ensicaen.ecole.genielogiciel.model;

public class WEI extends Case{
    public WEI(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.randomSoftskill();
    }
}
