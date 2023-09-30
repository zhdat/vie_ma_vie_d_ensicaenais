package fr.ensicaen.ecole.genielogiciel.model;

public class GestionFinancière extends Case{
    public GestionFinancière(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Joueur joueur) {
        joueur.setCompetence(1);
    }
}
