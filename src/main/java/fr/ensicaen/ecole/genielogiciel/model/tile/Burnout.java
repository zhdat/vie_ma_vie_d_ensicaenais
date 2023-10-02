package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Burnout extends Tile {
    public Burnout(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setPosition(0);
    }
}
