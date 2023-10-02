package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Maths extends Tile {
    public Maths(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        if (player.getProvenance() == Origin.PREPA){
            player.setCompetence(1);
        } else {
            player.setCompetence(-1);
        }
    }
}
