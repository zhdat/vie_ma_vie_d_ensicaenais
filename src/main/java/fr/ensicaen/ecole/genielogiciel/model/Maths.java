package fr.ensicaen.ecole.genielogiciel.model;

public class Maths extends Case{
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
