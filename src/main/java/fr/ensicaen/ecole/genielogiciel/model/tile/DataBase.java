package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class DataBase extends Tile {
    public DataBase(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.COMPUTER_SCIENCE){
            player.increaseSkillLevel(1);
        }
    }
}

