package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Party extends Tile {
    public Party(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        player.setSkillLevel(-1);
    }
}
