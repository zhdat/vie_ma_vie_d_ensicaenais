package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;

public class Sensor extends Tile {
    
    public Sensor(int position) { super(position);}

    @Override
    public void appliquerEffet(Player player) {
        if (player.getFiliere() == Sector.ELECTRONIQUE){
            player.setCompetence(1);
        }
    }
}
