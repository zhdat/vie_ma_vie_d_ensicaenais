package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Sensor extends Tile {
    
    public Sensor(int position) { super(position);}

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.ELECTRONICS){
            player.increaseSkillLevel(1);
        }
    }
}
