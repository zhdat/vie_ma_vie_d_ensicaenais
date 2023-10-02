package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class WEI extends Tile {
    public WEI(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.randomSoftskill();
    }
}
