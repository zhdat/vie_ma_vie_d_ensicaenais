package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;

public class Thermodynamics extends Tile{
    public Thermodynamics(int position) { super(position);}

    @Override
    public void appliquerEffet(Player player) {
        if (player.getFiliere() == Sector.MATERIAUX){
            player.setCompetence(1);
        }
    }
}