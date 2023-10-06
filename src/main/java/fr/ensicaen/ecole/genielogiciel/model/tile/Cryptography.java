package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Cryptography extends Tile {
    public Cryptography(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.COMPUTER_SCIENCE){
            player.increaseSkillLevel(1);
        }
    }
}
