package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class StartOfTheYear extends Tile {
    public StartOfTheYear(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        player.setPosition(0);
    }
}
