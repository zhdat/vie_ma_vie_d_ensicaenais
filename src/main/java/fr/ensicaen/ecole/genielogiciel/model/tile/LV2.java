package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class LV2 extends Tile {
    public LV2(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setCompetence(1);
    }
}
