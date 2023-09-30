package fr.ensicaen.ecole.genielogiciel.model;

public class Cpp extends Case{
    public Cpp(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        if (joueur.getFiliere() == Filiere.INFORMATIQUE){
            if (joueur.getProvenance() == Provenance.AST){
                joueur.setCompetence(1);
            } else if (joueur.getProvenance() == Provenance.PREPA) {
                joueur.setCompetence(-1);
            }
        }
    }
}
