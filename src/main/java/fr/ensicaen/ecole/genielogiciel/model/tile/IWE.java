package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class IWE extends Tile {
    public IWE(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        player.setRandomSoftSkill();
    }
}
