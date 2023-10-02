package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Sector;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Cryptography extends Tile {
    public Cryptography(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        if (player.getFiliere() == Sector.INFORMATIQUE){
            player.setCompetence(1);
        }
    }
}
