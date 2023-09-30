package fr.ensicaen.ecole.genielogiciel.model;

public class BaseDeDonnée extends Case{
    public BaseDeDonnée(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        if (joueur.getFiliere() == Filiere.INFORMATIQUE){
            joueur.setCompetence(1);
        }
    }
}
