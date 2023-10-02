package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Rentree extends Tile {
    public Rentree(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setPosition(0); /* @TODO : set la position des cases rentrées*/
    }
}
