package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class English extends Tile {
    public English(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        player.increaseSkillLevel(1);
        System.out.println("English!!");
        System.out.println(player.getSkillLevel());
    }
}
