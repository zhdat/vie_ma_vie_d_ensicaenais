package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Revision extends Tile {
    public Revision(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        player.increaseSkillLevel(2);
    }
}
