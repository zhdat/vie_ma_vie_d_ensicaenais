package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Soirées extends Tile {
    public Soirées(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setCompetence(-1);
    }
}
