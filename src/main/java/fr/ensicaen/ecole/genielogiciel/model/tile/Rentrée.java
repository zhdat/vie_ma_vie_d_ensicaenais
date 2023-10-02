package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Rentrée extends Tile {
    public Rentrée(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setPosition(0); /* @TODO : set la position des cases rentrées*/
    }
}
